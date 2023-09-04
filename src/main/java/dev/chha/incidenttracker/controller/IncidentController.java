package dev.chha.incidenttracker.controller;

import dev.chha.incidenttracker.dtos.IncidentDTO;
import dev.chha.incidenttracker.entities.User;
import dev.chha.incidenttracker.repositories.IncidentRepository;
import dev.chha.incidenttracker.entities.Incident;
import dev.chha.incidenttracker.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api")
public class IncidentController {

    private final IncidentRepository incidentRepo;

    private final UserRepository userRepo;

    public IncidentController(IncidentRepository incidentRepo, UserRepository userRepo) {
        this.incidentRepo = incidentRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/incident/{incidentId}")
    public ResponseEntity<?> hello(@PathVariable Long incidentId) {

        Optional<Incident> incidentOpt = incidentRepo.findById(incidentId);

        if(incidentOpt.isEmpty()) {
            return new ResponseEntity<>("No Incident found", HttpStatus.NOT_FOUND);
        }
        Incident incident = incidentOpt.get();
        IncidentDTO responseIncidentDTO = getFieldsFromIncident(incident);

        return new ResponseEntity<>(responseIncidentDTO, HttpStatus.OK);

    }
    @DeleteMapping("/incident/{incidentId}")
    public void delete(@PathVariable Long incidentId) {

        Optional<Incident> incident = incidentRepo.findById(incidentId);

        if (incident.isPresent()) {
            incidentRepo.deleteById(incidentId);
        }
    }
    @GetMapping("/incidents")
    public ResponseEntity<Iterable<IncidentDTO>> getAll(){

        Iterable<Incident> newIncident = incidentRepo.findAll();

        return new ResponseEntity<>(incidentList(newIncident), HttpStatus.OK);

    }

    @PostMapping("/incidents/create")
    @Transactional
    public ResponseEntity<?> createIncident(@RequestBody IncidentDTO incidentDTO) {


        Optional<User> user = userRepo.findById(incidentDTO.getUser_id());

        if(user.isEmpty()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        Incident newIncident = new Incident();

        newIncident.setUser(user.get());
        newIncident.setTitel(incidentDTO.getTitel());
        newIncident.setDescription(incidentDTO.getDescription());
        newIncident.setReportdate(incidentDTO.getReportdate());
        newIncident.setSolved(incidentDTO.isSolved());


        incidentRepo.save(newIncident);

        return new ResponseEntity<>(newIncident, HttpStatus.CREATED);

    }

    @PutMapping("/incidents/edit/{incidentId}")
    @Transactional
    public ResponseEntity<?> updateIncident(@PathVariable Long incidentId,
                                         @RequestBody Incident incident) {
        Optional<Incident> updatedIncident = incidentRepo.findById(incidentId);

        if (updatedIncident.isPresent()) {

            Incident savedIncident = incidentRepo.save(incident);
            return new ResponseEntity<>(savedIncident, HttpStatus.OK);
        }
        return new ResponseEntity<>("Incident not found with id" + incidentId, HttpStatus.NOT_FOUND);
    }

    private IncidentDTO getFieldsFromIncident(Incident incident) {
        IncidentDTO dto = new IncidentDTO();

        dto.setIncidentId(incident.getIncidentId());
        dto.setTitel(incident.getTitel());
        dto.setDescription(incident.getDescription());
        dto.setReportdate(incident.getReportdate());

        if(incident.getUser() != null){
            dto.setUser_id(incident.getUser().getUserId());
            dto.setUsername(incident.getUser().getUsername());
        }
        return dto;
    }

    public Iterable<IncidentDTO> incidentList(Iterable<Incident> incidents) {

        return StreamSupport.stream(incidents.spliterator(), false)
                .map(this::getFieldsFromIncident)
                .collect(Collectors.toList());


    }

}