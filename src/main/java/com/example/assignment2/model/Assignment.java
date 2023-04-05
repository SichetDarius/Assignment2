package com.example.assignment2.model;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table (name="assignment")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_assignment;
    @Column(name="nume",nullable = false,length = 20)
    private String nume;
    @Column(name ="data", length = 20)
    private LocalDateTime data;
    @Column(name = "description", length = 200)
    private String description;

    public Assignment(Long id_assignment, String nume, LocalDateTime data, String description) {
        this.id_assignment = id_assignment;
        this.nume = nume;
        this.data = data;
        this.description = description;
    }

    public Assignment(String nume, LocalDateTime data, String description) {
        this.nume = nume;
        this.data = data;
        this.description = description;
    }

    public Assignment(){

    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId_assignment() {
        return id_assignment;
    }

    public void setId_assignment(Long id_assignment) {
        this.id_assignment = id_assignment;
    }

}
