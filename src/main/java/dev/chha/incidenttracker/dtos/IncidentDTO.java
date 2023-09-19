package dev.chha.incidenttracker.dtos;


public class IncidentDTO {

    private long incidentId;

    private String titel;

    private String description;

    private String reportdate;

    private boolean isSolved;

    private Long user_id;

    private String username;

    private int category;

    private int severity;

    private String categoryName;

    private String severityName;



    public IncidentDTO() {
    }

    public IncidentDTO(long incidentId, String titel, String description, String reportdate, boolean isSolved, Long user_id, String username, int category, int severity, String categoryName, String severityName) {
        this.incidentId = incidentId;
        this.titel = titel;
        this.description = description;
        this.reportdate = reportdate;
        this.isSolved = isSolved;
        this.user_id = user_id;
        this.username = username;
        this.category = category;
        this.severity = severity;
        this.categoryName = categoryName;
        this.severityName = severityName;
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public String getCategoryName(String categoryName) {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSeverityName() {
        return severityName;
    }

    public void setSeverityName(String severityName) {
        this.severityName = severityName;
    }


    @Override
    public String toString() {
        return "IncidentDTO{" +
                "incidentId=" + incidentId +
                ", titel='" + titel + '\'' +
                ", description='" + description + '\'' +
                ", reportdate='" + reportdate + '\'' +
                ", isSolved=" + isSolved +
                ", user_id=" + user_id +
                ", username='" + username + '\'' +
                ", category=" + category +
                ", severity=" + severity +
                ", categoryName='" + categoryName + '\'' +
                ", severityName='" + severityName + '\'' +
                '}';
    }
}
