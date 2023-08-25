package dev.chha.incidenttracker;

import dev.chha.incidenttracker.entities.Role;
import dev.chha.incidenttracker.entities.User;
import dev.chha.incidenttracker.repositories.RoleRepository;
import dev.chha.incidenttracker.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class IncidentTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(IncidentTrackerApplication.class, args);
    }

    @Bean
    CommandLineRunner run(RoleRepository roleRepo, UserRepository userRepo, PasswordEncoder passwordEncoder) {
        return args ->  {
            if(roleRepo.findByAuthority("ADMIN").isPresent()) return;

            Role adminRole = roleRepo.save(new Role("ADMIN"));
            roleRepo.save(new Role("USER"));

            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);

            User admin = new User(1L, "admin", passwordEncoder.encode("password"), "Rüdiger", "Rust", roles);

            userRepo.save(admin);

        };
    }

}
