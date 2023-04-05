package com.example.assignment2.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="laboratory")
public class Laboratory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_laboratory;
    @Column(name = "number")
    private int number;
    @Column(name = "title", length = 60)
    private String title;
    @Column(name ="data", length = 20)
    private LocalDateTime data;
    @Column(name = "topics", length = 60)
    private String topics;
    @Column(name = "description", length = 60)
    private String description;

    public Laboratory() {
    }

    public Laboratory(int number, String title, LocalDateTime data, String topics, String description) {
        this.number = number;
        this.title = title;
        this.data = data;
        this.topics = topics;
        this.description = description;
    }

    public Laboratory(Long id_laboratory, int number, String title, LocalDateTime data, String topics, String description) {
        this.id_laboratory = id_laboratory;
        this.number = number;
        this.title = title;
        this.data = data;
        this.topics = topics;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Long getId_laboratory() {
        return id_laboratory;
    }

    public void setId_laboratory(Long id_laboratory) {
        this.id_laboratory = id_laboratory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
