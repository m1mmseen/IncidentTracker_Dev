package dev.chha.incidenttracker.controller;

import dev.chha.incidenttracker.dtos.SortRequestDTO;
import dev.chha.incidenttracker.entities.User;
import dev.chha.incidenttracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>("User not found with id: " + userId, HttpStatus.NOT_FOUND);

    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getAllUsers() {

        Iterable<User> users = userRepo.findAll(Sort.by(Sort.Direction.ASC, "lastname"));

        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @PostMapping("/usersCustomSort")
    public ResponseEntity<?> getAllUsers(@RequestBody SortRequestDTO sortRequest) {

        String sort = sortRequest.getSorting();

        if ("id".equals(sortRequest.getSorting())) {
            Iterable<User> users = userRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else if ("first".equals(sortRequest.getSorting())) {
            Iterable<User> users = userRepo.findAll(Sort.by(Sort.Direction.ASC, "firstname"));
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else if ("last".equals(sortRequest.getSorting())) {
            Iterable<User> users = userRepo.findAll(Sort.by(Sort.Direction.ASC, "lastname"));
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else if ("role".equals(sortRequest.getSorting())) {
            Iterable<User> users = userRepo.findAll(Sort.by(Sort.Direction.ASC, "role"));
            return new ResponseEntity<>(users, HttpStatus.OK);
        }

        return new ResponseEntity<>("Sorting ID not found", HttpStatus.BAD_REQUEST);

    }
}
