package com.example.assignment2.model;

import javax.persistence.*;

@Entity
@Table(name="assignment_submission")
public class AssignmentSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_assignment_submission;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_assignment")
    private Assignment assignment;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_user")
    private User user;
    @Column(name="link")
    private String link;
    @Column(name="comment")
    private String comment;
    @Column(name="grade")
    private Integer grade;

    public AssignmentSubmission() {
    }

    public AssignmentSubmission(Assignment assignment, User user, String link, String comment, int grade) {
        this.assignment = assignment;
        this.user = user;
        this.link = link;
        this.comment = comment;
        this.grade = grade;
    }

    public AssignmentSubmission(Long id_assignment_submission, Assignment assignment, User user, String link, String comment, int grade) {
        this.id_assignment_submission = id_assignment_submission;
        this.assignment = assignment;
        this.user = user;
        this.link = link;
        this.comment = comment;
        this.grade = grade;
    }

    public Long getId_assignment_submission() {
        return id_assignment_submission;
    }

    public void setId_assignment_submission(Long id_assignment_submission) {
        this.id_assignment_submission = id_assignment_submission;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
