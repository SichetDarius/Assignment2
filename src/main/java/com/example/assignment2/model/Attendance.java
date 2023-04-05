package com.example.assignment2.model;


import javax.persistence.*;

@Entity
@Table(name="attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_attendance;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_laboratory")
    private Laboratory laboratory;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_user")
    private User user;

    public Attendance(Long id_attendance, Laboratory laboratory, User user) {
        this.id_attendance = id_attendance;
        this.laboratory = laboratory;
        this.user = user;
    }

    public Attendance(Laboratory laboratory, User user) {
        this.laboratory = laboratory;
        this.user = user;
    }

    public Attendance() {

    }

    public Long getId_attendance() {
        return id_attendance;
    }

    public void setId_attendance(Long id_attendance) {
        this.id_attendance = id_attendance;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
