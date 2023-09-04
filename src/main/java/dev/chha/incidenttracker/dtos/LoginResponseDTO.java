package dev.chha.incidenttracker.dtos;

import dev.chha.incidenttracker.entities.User;

public class LoginResponseDTO{

    private UserDTO user;

    private String jwt;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(UserDTO user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
