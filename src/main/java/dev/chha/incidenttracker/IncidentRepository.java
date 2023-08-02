package dev.chha.incidenttracker;

import org.springframework.data.repository.CrudRepository;

public interface IncidentRepository extends CrudRepository<Incident, Integer> {
}
