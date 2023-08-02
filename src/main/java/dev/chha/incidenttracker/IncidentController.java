package dev.chha.incidenttracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class IncidentController {

    @Autowired
    private IncidentRepository incidentRepo;

    @GetMapping("/incident")
    public ResponseEntity<Incident> getIncidentById(@RequestParam(value = "id")int id){

        Optional<Incident> newIncident = incidentRepo.findById(id);

        if (newIncident.isPresent()) {
            return new ResponseEntity<>(newIncident.get(), HttpStatus.OK);
        }
        return new ResponseEntity("Kein Incident mit dieser Id gefunden", HttpStatus.NOT_FOUND);

    }

    @GetMapping("/incidents")
    public ResponseEntity<Iterable<Incident>> getAll(){

        Iterable<Incident> newIncident = incidentRepo.findAll();


        return new ResponseEntity<Iterable<Incident>>(newIncident, HttpStatus.NOT_FOUND);

    }

    @PostMapping("/incidents/create")
    public ResponseEntity<Incident> createIncident(@RequestBody Incident incident) {
        incidentRepo.save(incident);
        return new ResponseEntity<>(incident, HttpStatus.CREATED);
    }
}