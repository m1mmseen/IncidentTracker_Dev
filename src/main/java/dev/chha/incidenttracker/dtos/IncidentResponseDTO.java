package dev.chha.incidenttracker.dtos;

public class IncidentResponseDTO {

    private Long incidentId;

    private String title;

    private String description;

    private String reportdate;

    private boolean solved;

    private String assignedUser;

    public IncidentResponseDTO() {
    }

    public IncidentResponseDTO(Long incidentId, String title, String description, String reportdate, boolean solved, String assignedUser) {
        this.incidentId = incidentId;
        this.title = title;
        this.description = description;
        this.reportdate = reportdate;
        this.solved = solved;
        this.assignedUser = assignedUser;
    }

    public Long getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(Long incidentId) {
        this.incidentId = incidentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReportdate() {
        return reportdate;
    }

    public void setReportdate(String reportdate) {
        this.reportdate = reportdate;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public String getAssignedUser(String username) {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }
}
