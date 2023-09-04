package dev.chha.incidenttracker.dtos;

public class IncidentUpdateDTO {

    private String shortDescription;
    private String updateText;

    private Long incidentId;

    private Long userId;

    private String username;

    private long createdAt;

    public IncidentUpdateDTO() {}

    public IncidentUpdateDTO(String shortDescription, String updateText, Long incidentId, Long userId, String username, long createdAt) {
        this.shortDescription = shortDescription;
        this.updateText = updateText;
        this.incidentId = incidentId;
        this.userId = userId;
        this.username = username;
        this.createdAt = createdAt;
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

    public Long getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(Long incidentId) {
        this.incidentId = incidentId;
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

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}

