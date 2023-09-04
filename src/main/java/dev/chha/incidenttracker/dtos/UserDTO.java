package dev.chha.incidenttracker.dtos;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserDTO {

    private Long userId;

    private String username;

    private String firstname;

    private String lastname;

    private Collection<GrantedAuthority> roles;

    private int assignedIncidents;

    private int openIncidents;


    public UserDTO() {
    }

    public UserDTO(Long userId, String username, String firstname, String lastname, Collection<GrantedAuthority> roles, int assignedIncidents, int openIncidents) {
        this.userId = userId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.roles = roles;
        this.assignedIncidents = assignedIncidents;
        this.openIncidents = openIncidents;

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Collection<GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<GrantedAuthority> roles) {
        this.roles = roles;
    }

    public int getAssignedIncidents() {
        return assignedIncidents;
    }

    public void setAssignedIncidents(int assignedIncidents) {
        this.assignedIncidents = assignedIncidents;
    }

    public int getOpenIncidents() {
        return openIncidents;
    }

    public void setOpenIncidents(int openIncidents) {
        this.openIncidents = openIncidents;
    }


    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", Username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", roles=" + roles +
                ", assignedIncidents=" + assignedIncidents +
                ", openIncidents=" + openIncidents +
                '}';
    }
}
