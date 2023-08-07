package dev.chha.incidenttracker;

import dev.chha.incidenttracker.Incident;
import org.springframework.data.repository.CrudRepository;

public interface IncidentRepository extends CrudRepository<Incident, Integer> {
}
