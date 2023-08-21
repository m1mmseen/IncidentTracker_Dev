package dev.chha.incidenttracker.controller;

import dev.chha.incidenttracker.dtos.IncidentUpdateDTO;
import dev.chha.incidenttracker.dtos.UpdatesRequestDTO;
import dev.chha.incidenttracker.entities.Incident;
import dev.chha.incidenttracker.entities.IncidentUpdates;
import dev.chha.incidenttracker.repositories.IncidentRepository;
import dev.chha.incidenttracker.repositories.IncidentUpdatesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class IncidentUpdatesController {


    private final IncidentUpdatesRepository updateRepo;

    private final IncidentRepository incidentRepo;

    public IncidentUpdatesController(IncidentUpdatesRepository updateRepo, IncidentRepository incidentRepo) {
        this.updateRepo = updateRepo;
        this.incidentRepo = incidentRepo;
    }

    @PostMapping("/newUpdate")
    public ResponseEntity updateIncident(@RequestBody IncidentUpdateDTO incidentUpdateDto) {

        IncidentUpdates update =  new IncidentUpdates();

        Optional<Incident> incident = incidentRepo.findById(incidentUpdateDto.getIncidentId());

        if(!incident.isPresent()) {
            return new ResponseEntity("THere is no Incident with id" + incidentUpdateDto.getIncidentId(), HttpStatus.NOT_FOUND);
        }

        Incident relatedIncident = incident.get();

        update.setShortDescription(incidentUpdateDto.getShortDescription());
        update.setUpdateText(incidentUpdateDto.getUpdateText());
        update.setIncident(relatedIncident);

        updateRepo.save(update);

        return new ResponseEntity(update, HttpStatus.CREATED);

    }

    @GetMapping("/allUpdates")
    public ResponseEntity<?> getAllUpdatesBy() {


        List<IncidentUpdates> updates = updateRepo.findAll();

        return new ResponseEntity(updates, HttpStatus.OK);


    }
    @GetMapping("/updates/{incidentId}")
    public ResponseEntity<?> getAllUpdatesByIncident(@PathVariable Long incidentId) {
        List<IncidentUpdates> updates = updateRepo.findAllByIncident_IdOrderByCreatedAtDesc(incidentId);
        return new ResponseEntity<>(updates, HttpStatus.OK);
    }


}