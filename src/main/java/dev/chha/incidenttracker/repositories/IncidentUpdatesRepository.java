package dev.chha.incidenttracker.repositories;

import dev.chha.incidenttracker.entities.IncidentUpdates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IncidentUpdatesRepository extends JpaRepository<IncidentUpdates, Long> {

    List<IncidentUpdates> findAllByIncident_IdOrderByCreatedAtDesc(Long incidentId);

}
