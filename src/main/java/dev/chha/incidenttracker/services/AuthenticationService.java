package dev.chha.incidenttracker.services;


import dev.chha.incidenttracker.entities.Role;
import dev.chha.incidenttracker.entities.User;
import dev.chha.incidenttracker.repositories.RoleRepository;
import dev.chha.incidenttracker.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    private final PasswordEncoder encoder;
    private final RoleRepository roleRepo;
    private final UserRepository userRepo;

    public AuthenticationService(UserRepository userRepo, RoleRepository roleRepo, PasswordEncoder encoder) {
        this.encoder = encoder;
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
    }

    public User registerUser(String username, String password, String firstname, String lastname) {
        String encodedPassword = encoder.encode(password);

        Role userRole = roleRepo.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);

        return userRepo.save(new User(0L, username, encodedPassword, firstname, lastname, authorities));
    }
}
