package dev.chha.incidenttracker.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class IncidentSeverity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int severityId;

    @Column(name = "severity")
    private String severityName;

    @Column(name = "assignedIncidents")
    @OneToMany(mappedBy = "severity", cascade = CascadeType.PERSIST)
    private Set<Incident> incidents;

    public IncidentSeverity() {
    }

    public IncidentSeverity(int severityId, String severityName) {
        this.severityId = severityId;
        this.severityName = severityName;
    }

    public int getSeverityId() {
        return severityId;
    }

    public void setSeverityId(int severityId) {
        this.severityId = severityId;
    }

    public String getSeverityName() {
        return severityName;
    }

    public void setSeverityName(String severityName) {
        this.severityName = severityName;
    }
}
