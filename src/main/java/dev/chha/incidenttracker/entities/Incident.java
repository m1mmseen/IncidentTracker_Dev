package dev.chha.incidenttracker.entities;

import jakarta.persistence.*;
import java.util.List;


@Entity
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incidentId;

    @Column
    private String Titel;

    @Column(length = 500)
    private String Description;

    //@Column(insertable = false, updatable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    //private Date Reportdate;

    @Column(nullable = false)
    private boolean isSolved;

    @OneToMany(mappedBy = "incident")
    private List<IncidentUpdates> updates;

    public Long getId() {
        return incidentId;
    }

    public void setId(Long id) {
        this.incidentId = id;
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

//    public Date getReportdate() {
//        return Reportdate;
//    }
//
//    public void setReportdate(Date reportdate) {
//        Reportdate = reportdate;
//    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

}
