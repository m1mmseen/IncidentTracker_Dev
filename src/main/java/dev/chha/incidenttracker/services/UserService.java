package dev.chha.incidenttracker.services;

import dev.chha.incidenttracker.entities.User;
import dev.chha.incidenttracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import dev.chha.incidenttracker.entities.Role;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {


    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));

    }
}
