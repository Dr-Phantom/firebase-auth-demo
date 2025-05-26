package com.example.firebase_auth_demo.dto;

public class LoginRequest {
    private String idToken;

    // Default constructor
    public LoginRequest() {
    }

    // Constructor with fields
    public LoginRequest(String idToken) {
        this.idToken = idToken;
    }

    // Getter and Setter
    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }
}