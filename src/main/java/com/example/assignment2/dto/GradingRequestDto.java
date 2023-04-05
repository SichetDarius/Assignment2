package com.example.assignment2.dto;

public class GradingRequestDto {
    private int grade;

    public GradingRequestDto() {
    }

    public GradingRequestDto(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
