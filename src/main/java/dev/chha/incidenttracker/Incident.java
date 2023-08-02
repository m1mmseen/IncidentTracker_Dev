package dev.chha.incidenttracker;

import jakarta.persistence.*;

@Entity
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String Titel;

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
}
