package dev.chha.incidenttracker.controller;

import dev.chha.incidenttracker.repositories.IncidentRepository;
import dev.chha.incidenttracker.entities.Incident;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/api")
public class IncidentController {

    @Autowired
    private IncidentRepository incidentRepo;

    @GetMapping("/incident/{incidentId}")
    public ResponseEntity hello(@PathVariable int incidentId) {

        Optional<Incident> incident = incidentRepo.findById(incidentId);

        if (incident.isPresent()) {
            return new ResponseEntity<>(incident.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Incident not found with id: " + incidentId, HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/incident/{incidentId}")
    public void delete(@PathVariable int incidentId) {

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
    public ResponseEntity<Incident> createIncident(@RequestBody Incident incident) {

        Incident newIncident = incidentRepo.save(incident);

        return new ResponseEntity<Incident>(newIncident, HttpStatus.OK);

    }

    @PutMapping("/incidents/edit/{incidentId}")
    @Transactional
    public ResponseEntity updateIncident(@PathVariable int incidentId,
                                         @RequestBody Incident incident) {
        Optional<Incident> updatedIncident = incidentRepo.findById(incidentId);

        if (updatedIncident.isPresent()) {

            Incident savedIncident = incidentRepo.save(incident);
            return new ResponseEntity<>(savedIncident, HttpStatus.OK);
        }
        return new ResponseEntity<>("Incident not found with id" + incidentId, HttpStatus.NOT_FOUND);
    }

}