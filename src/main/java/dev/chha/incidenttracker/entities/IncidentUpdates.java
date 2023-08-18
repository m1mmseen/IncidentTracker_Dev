package dev.chha.incidenttracker.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "incident_updates")
public class IncidentUpdates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long updatetId;

    @Column(name = "shortDescription", length = 25)
    private String shortDescription;

    @Column(name = "longDescription", length = 500)
    private String updateText;

    @ManyToOne
    @JoinColumn(name = "incidentId")
    private Incident incident;

    private long createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = System.currentTimeMillis() / 1000;  // Convert milliseconds to seconds
    }
}
