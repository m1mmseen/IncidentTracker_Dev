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
        createdAt = System.currentTimeMillis();
    }

    public IncidentUpdates() {
    }

    public Long getUpdatetId() {
        return updatetId;
    }

    public void setUpdatetId(Long updatetId) {
        this.updatetId = updatetId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getUpdateText() {
        return updateText;
    }

    public void setUpdateText(String updateText) {
        this.updateText = updateText;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
