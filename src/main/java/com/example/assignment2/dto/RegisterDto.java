package com.example.assignment2.dto;

public class RegisterDto {
    private String password;

    public RegisterDto() {
    }

    public RegisterDto(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
