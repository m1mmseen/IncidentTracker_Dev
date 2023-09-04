package dev.chha.incidenttracker.controller;

import dev.chha.incidenttracker.dtos.IncidentDTO;
import dev.chha.incidenttracker.dtos.IncidentUpdateDTO;
import dev.chha.incidenttracker.entities.Incident;
import dev.chha.incidenttracker.entities.IncidentUpdates;
import dev.chha.incidenttracker.entities.User;
import dev.chha.incidenttracker.repositories.IncidentRepository;
import dev.chha.incidenttracker.repositories.IncidentUpdatesRepository;
import dev.chha.incidenttracker.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
@RequestMapping("/api")
public class IncidentUpdatesController {


    private final IncidentUpdatesRepository updateRepo;

    private final IncidentRepository incidentRepo;

    private final UserRepository userRepo;

    public IncidentUpdatesController(IncidentUpdatesRepository updateRepo, IncidentRepository incidentRepo, UserRepository userRepo) {
        this.updateRepo = updateRepo;
        this.incidentRepo = incidentRepo;
        this.userRepo = userRepo;
    }

    @PostMapping("/newUpdate")
    public ResponseEntity<?> updateIncident(@RequestBody IncidentUpdateDTO incidentUpdateDto) {


        IncidentUpdates update =  new IncidentUpdates();

        Optional<Incident> incident = incidentRepo.findById(incidentUpdateDto.getIncidentId());
        Optional<User> user = userRepo.findByUsername(incidentUpdateDto.getUsername());

        if(incident.isEmpty()) {
            return new ResponseEntity<>("THere is no Incident with id" + incidentUpdateDto.getIncidentId(), HttpStatus.NOT_FOUND);
        }
        if(user.isEmpty()) {
            return new ResponseEntity<>("THere is no User with id" + incidentUpdateDto.getUserId(), HttpStatus.NOT_FOUND);
        }


        Incident relatedIncident = incident.get();

        update.setShortDescription(incidentUpdateDto.getShortDescription());
        update.setUpdateText(incidentUpdateDto.getUpdateText());
        update.setIncident(relatedIncident);
        update.setUser(user.get());

        updateRepo.save(update);

        return new ResponseEntity<>(update, HttpStatus.CREATED);

    }
    @GetMapping("/allUpdates")
    public ResponseEntity<Iterable<IncidentUpdateDTO>> getAllUpdatesBy() {

        Iterable<IncidentUpdates> updates = updateRepo.findAll();

        return new ResponseEntity<>(updateList(updates), HttpStatus.OK);


    }
    @GetMapping("/updates/{incidentId}")
    public ResponseEntity<?> getAllUpdatesByIncident(@PathVariable Long incidentId) {
        List<IncidentUpdates> updates = updateRepo.findAllByIncident_IdOrderByCreatedAtDesc(incidentId);
        return new ResponseEntity<>(updateList(updates), HttpStatus.OK);
    }

    private IncidentUpdateDTO getFieldsFromUpdate(IncidentUpdates incidentUpdates) {
        IncidentUpdateDTO dto = new IncidentUpdateDTO();

        dto.setShortDescription(incidentUpdates.getShortDescription());
        dto.setUpdateText(incidentUpdates.getUpdateText());
        dto.setCreatedAt(incidentUpdates.getCreatedAt());

        if(incidentUpdates.getUser() != null){
            dto.setUserId(incidentUpdates.getUser().getUserId());
            dto.setUsername(incidentUpdates.getUser().getUsername());
        }

        if(incidentUpdates.getIncident() != null){
            dto.setIncidentId(incidentUpdates.getIncident().getIncidentId());
        }
        return dto;
    }
    public Iterable<IncidentUpdateDTO> updateList(Iterable<IncidentUpdates> incidentUpdates) {

        return StreamSupport.stream(incidentUpdates.spliterator(), false)
                .map(this::getFieldsFromUpdate)
                .collect(Collectors.toList());


    }



}