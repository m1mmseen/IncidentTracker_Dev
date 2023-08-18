package dev.chha.incidenttracker.repositories;

import dev.chha.incidenttracker.entities.Incident;
import org.springframework.data.repository.CrudRepository;

public interface IncidentRepository extends CrudRepository<Incident, Long> {
}
