package dev.chha.incidenttracker.controller;

import dev.chha.incidenttracker.dtos.IncidentUpdateDTO;
import dev.chha.incidenttracker.entities.Incident;
import dev.chha.incidenttracker.entities.IncidentUpdates;
import dev.chha.incidenttracker.repositories.IncidentRepository;
import dev.chha.incidenttracker.repositories.IncidentUpdatesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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

}
