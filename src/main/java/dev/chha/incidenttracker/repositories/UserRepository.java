package dev.chha.incidenttracker.repositories;

import dev.chha.incidenttracker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
