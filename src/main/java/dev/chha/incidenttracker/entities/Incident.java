package dev.chha.incidenttracker;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String Titel;

    @Column(columnDefinition ="VARCHAR(MAX)")
    private String Description;

    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date Reportdate;

    @Column(nullable = false)
    private boolean isSolved;

    @OneToMany
    @JoinColumn(name = "id")
    private Set<Tags> tags;

    @OneToOne
    @JoinColumn(name = "id")
    private Priority priority ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitel() {
        return Titel;
    }

    public void setTitel(String titel) {
        Titel = titel;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getReportdate() {
        return Reportdate;
    }

    public void setReportdate(Date reportdate) {
        Reportdate = reportdate;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

    public Set<Tags> getTags() {
        return tags;
    }

    public void setTags(Set<Tags> tags) {
        this.tags = tags;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
