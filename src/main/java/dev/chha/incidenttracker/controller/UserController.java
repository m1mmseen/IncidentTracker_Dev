package dev.chha.incidenttracker.controller;

import dev.chha.incidenttracker.entities.User;
import dev.chha.incidenttracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/user/{userId}")
    public ResponseEntity getUserDetails(@PathVariable Long userId) {

        Optional<User> user = userRepo.findById(userId);

        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Incident not found with id: " + userId, HttpStatus.NOT_FOUND);

    }
}
