package dev.chha.incidenttracker.repositories;

import dev.chha.incidenttracker.entities.IncidentCategories;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IncidentCategoriesRepository  extends CrudRepository<IncidentCategories, Integer> {
}
