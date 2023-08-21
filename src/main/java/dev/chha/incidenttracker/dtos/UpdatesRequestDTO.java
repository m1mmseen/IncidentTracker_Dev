package dev.chha.incidenttracker.dtos;

public class UpdatesRequestDTO {

    private Long incident_id;

    public Long getIncidentRequestId() {
        return incident_id;
    }

    public void setIncidentRequestId(Long incidentRequestId) {
        this.incident_id = incidentRequestId;
    }
}
