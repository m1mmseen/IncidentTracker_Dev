package dev.chha.incidenttracker.entities;

import jakarta.persistence.*;

@Entity
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;
}
