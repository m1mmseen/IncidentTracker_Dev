package dev.chha.incidenttracker.repositories;

import dev.chha.incidenttracker.entities.IncidentUpdates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentUpdatesRepository extends JpaRepository<IncidentUpdates, Long> {
}
