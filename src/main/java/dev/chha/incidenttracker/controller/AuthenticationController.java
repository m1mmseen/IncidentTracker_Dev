package dev.chha.incidenttracker.controller;

import dev.chha.incidenttracker.dtos.LoginResponseDTO;
import dev.chha.incidenttracker.dtos.LoginUserDTO;
import dev.chha.incidenttracker.dtos.RegisterUserDTO;
import dev.chha.incidenttracker.entities.User;
import dev.chha.incidenttracker.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegisterUserDTO user) {
        return authService.registerUser(user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody LoginUserDTO user) {
        return authService.loginUser(user.getUsername(), user.getPassword());
    }
}
