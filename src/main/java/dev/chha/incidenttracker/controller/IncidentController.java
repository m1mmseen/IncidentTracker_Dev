package dev.chha.incidenttracker.controller;

import dev.chha.incidenttracker.dtos.IncidentDTO;
import dev.chha.incidenttracker.entities.IncidentCategories;
import dev.chha.incidenttracker.entities.IncidentSeverity;
import dev.chha.incidenttracker.entities.User;
import dev.chha.incidenttracker.repositories.IncidentCategoriesRepository;
import dev.chha.incidenttracker.repositories.IncidentRepository;
import dev.chha.incidenttracker.entities.Incident;
import dev.chha.incidenttracker.repositories.IncidentSeverityRepository;
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

    private final IncidentCategoriesRepository catRepo;

    private final IncidentSeverityRepository sevRepo;

    public IncidentController(IncidentRepository incidentRepo, UserRepository userRepo, IncidentCategoriesRepository catRepo, IncidentSeverityRepository sevRepo) {
        this.incidentRepo = incidentRepo;
        this.userRepo = userRepo;
        this.catRepo = catRepo;
        this.sevRepo = sevRepo;
    }

    @GetMapping("/incident/{incidentId}")
    public ResponseEntity<?> hello(@PathVariable Long incidentId) {

        Optional<Incident> incidentOpt = incidentRepo.findById(incidentId);

        if(incidentOpt.isEmpty()) {
            return new ResponseEntity<>("No Incident found", HttpStatus.NOT_FOUND);
        }
        System.out.println(incidentOpt.get().toString());
        Incident incident = incidentOpt.get();
        System.out.println(incident.toString());

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

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories(){

        Iterable<IncidentCategories> categories = catRepo.findAll();

        return new ResponseEntity<>( categories, HttpStatus.OK);
    }

    @GetMapping("/severities")
    public ResponseEntity<?> getSeverities() {

        Iterable<IncidentSeverity> severities = sevRepo.findAll();

        return new ResponseEntity<>(severities, HttpStatus.OK);

    }

    @PostMapping("/incidents/create")
    @Transactional
    public ResponseEntity<?> createIncident(@RequestBody IncidentDTO incidentDTO) {


        Optional<User> user = userRepo.findById(incidentDTO.getUser_id());


        if(user.isEmpty()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        Optional<IncidentCategories> cat = catRepo.findById(incidentDTO.getCategory());
        if(cat.isEmpty()) {
            return new ResponseEntity<>("Wrong category", HttpStatus.NOT_FOUND);
        }

        Optional<IncidentSeverity> sev = sevRepo.findById(incidentDTO.getSeverity());
        if(sev.isEmpty()) {
            return new ResponseEntity<>("Wrong severity", HttpStatus.NOT_FOUND);
        }

        Incident newIncident = new Incident();

        newIncident.setUser(user.get());
        newIncident.setTitel(incidentDTO.getTitel());
        newIncident.setDescription(incidentDTO.getDescription());
        newIncident.setReportdate(incidentDTO.getReportdate());
        newIncident.setSolved(incidentDTO.isSolved());
        newIncident.setCategory(cat.get());
        newIncident.setSeverity(sev.get());


        incidentRepo.save(newIncident);

        return new ResponseEntity<>(newIncident, HttpStatus.CREATED);

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
        if(incident.getCategory() != null) {
            dto.setCategoryName(incident.getCategory().getCategoryName());
        }
        if(incident.getSeverity() != null) {
            dto.setSeverityName(incident.getSeverity().getSeverityName());
        }

        return dto;
    }

    public Iterable<IncidentDTO> incidentList(Iterable<Incident> incidents) {

        return StreamSupport.stream(incidents.spliterator(), false)
                .map(this::getFieldsFromIncident)
                .collect(Collectors.toList());
    }

}