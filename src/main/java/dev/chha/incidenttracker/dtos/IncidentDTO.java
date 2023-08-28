package dev.chha.incidenttracker.dtos;

public class IncidentDTO {

    private long incidentId;

    private String titel;

    private String description;

    private String reportdate;

    private boolean isSolved;

    private Long user_id;

    private String username;

    public IncidentDTO() {
    }

    public IncidentDTO(Long incidentId,String titel, String description, String reportdate, boolean isSolved, Long user_id, String username) {
        this.titel = titel;
        this.description = description;
        this.reportdate = reportdate;
        this.isSolved = isSolved;
        this.user_id = user_id;
        this.username = username;
        this.incidentId = incidentId;
    }

    public long getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(long incidentId) {
        this.incidentId = incidentId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
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
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "IncidentDTO{" +
                "titel='" + titel + '\'' +
                ", description='" + description + '\'' +
                ", reportdate='" + reportdate + '\'' +
                ", isSolved=" + isSolved +
                ", user_id=" + user_id +
                ", username='" + username + '\'' +
                '}';
    }
}
