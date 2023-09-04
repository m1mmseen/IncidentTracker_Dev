package dev.chha.incidenttracker.services;


import dev.chha.incidenttracker.dtos.LoginResponseDTO;
import dev.chha.incidenttracker.dtos.UserDTO;
import dev.chha.incidenttracker.entities.Role;
import dev.chha.incidenttracker.entities.User;
import dev.chha.incidenttracker.repositories.RoleRepository;
import dev.chha.incidenttracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public User registerUser(String username, String password, String firstname, String lastname) {
        String encodedPassword = encoder.encode(password);

        Role userRole = roleRepo.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);

        return userRepo.save(new User(0L, username, encodedPassword, firstname, lastname, authorities));
    }

    public LoginResponseDTO loginUser(String username, String password) {

        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            User userOpt = userRepo.findByUsername(username).get();


            UserDTO user = new UserDTO();
            user.setUserId(userOpt.getUserId());
            user.setUsername(userOpt.getUsername());
            user.setRoles((Collection<GrantedAuthority>) userOpt.getAuthorities());
            user.setFirstname(userOpt.getFirstname());
            user.setLastname(userOpt.getLastname());

            return new LoginResponseDTO(user, token);

        } catch (AuthenticationException e) {
            return new LoginResponseDTO(null, "");
        }

    }
}
