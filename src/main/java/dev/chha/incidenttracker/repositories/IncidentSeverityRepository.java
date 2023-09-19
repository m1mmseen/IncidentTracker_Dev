package dev.chha.incidenttracker.repositories;

import dev.chha.incidenttracker.entities.IncidentCategories;
import dev.chha.incidenttracker.entities.IncidentSeverity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IncidentSeverityRepository extends CrudRepository<IncidentSeverity, Integer> {

}
