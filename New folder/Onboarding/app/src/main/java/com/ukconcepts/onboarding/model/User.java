package com.ukconcepts.onboarding.model;

public class User {
    private String fullname;
    private String email;
    private String dob;
    private String password;


    public User(String fullname, String email, String dob, String password) {
        this.fullname = fullname;
        this.email = email;
        this.dob = dob;
        this.password = password;
    }


    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public String getPassword() {
        return password;
    }
}
