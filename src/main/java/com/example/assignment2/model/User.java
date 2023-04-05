package com.example.assignment2.model;


import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_user;
    @Column (name="username",nullable = false,length = 20)
    private String username;
    @Column (name="nume",nullable = false,length = 20)
    private String nume;
    @Column(name="prenume",nullable = false,length = 20)
    private String prenume;
    @Column(nullable = false,unique = true,length = 45)
    private String email;
    @Column(length = 500)
    private String password;
    @Column(name = "role", length = 20)
    private String role;
    @Column(name = "group_name", length = 20)
    private String group;
    @Column(name = "hobby", length = 20)
    private String hobby;

    public User() {
    }

    public User(String username, String nume, String prenume, String email, String password, String role, String group, String hobby) {
        this.username = username;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.password = password;
        this.role = role;
        this.group = group;
        this.hobby = hobby;
    }

    public User(Long id_user, String username, String nume, String prenume, String email, String password, String role, String group, String hobby) {
        this.id_user = id_user;
        this.username = username;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.password = password;
        this.role = role;
        this.group = group;
        this.hobby = hobby;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
