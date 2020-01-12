package com.ukconcepts.onboarding.model;

public class LoginDetails {
    private String userId;
    private String password;

    public LoginDetails(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
