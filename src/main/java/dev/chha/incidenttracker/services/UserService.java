package dev.chha.incidenttracker.services;

import dev.chha.incidenttracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

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
