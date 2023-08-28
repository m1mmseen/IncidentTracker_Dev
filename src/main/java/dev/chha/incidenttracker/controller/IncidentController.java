package dev.chha.incidenttracker.controller;

import dev.chha.incidenttracker.dtos.IncidentDTO;
import dev.chha.incidenttracker.entities.User;
import dev.chha.incidenttracker.repositories.IncidentRepository;
import dev.chha.incidenttracker.entities.Incident;
import dev.chha.incidenttracker.repositories.UserRepository;
import dev.chha.incidenttracker.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.lang.module.ResolutionException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class IncidentController {

    @Autowired
    private IncidentRepository incidentRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService userService;

    @GetMapping("/incident/{incidentId}")
    public ResponseEntity<?> hello(@PathVariable Long incidentId) {

        Optional<Incident> incidentOpt = incidentRepo.findById(incidentId);

        if(!incidentOpt.isPresent()) {
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
    public ResponseEntity<Iterable<Incident>> getAll(){

        Iterable<Incident> newIncident = incidentRepo.findAll();

        return new ResponseEntity<Iterable<Incident>>(newIncident, HttpStatus.OK);

    }

    @PostMapping("/incidents/create")
    @Transactional
    public ResponseEntity<?> createIncident(@RequestBody IncidentDTO incidentDTO) {


        Optional<User> user = userRepo.findById(incidentDTO.getUser_id());

        if(!user.isPresent()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        Incident newIncident = new Incident();

        newIncident.setUser(user.get());
        newIncident.setTitel(incidentDTO.getTitel());
        newIncident.setDescription(incidentDTO.getDescription());
        newIncident.setReportdate(incidentDTO.getReportdate());
        newIncident.setSolved(incidentDTO.isSolved());


        incidentRepo.save(newIncident);

        return new ResponseEntity<Incident>(newIncident, HttpStatus.CREATED);

    }

    @PutMapping("/incidents/edit/{incidentId}")
    @Transactional
    public ResponseEntity updateIncident(@PathVariable Long incidentId,
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

}