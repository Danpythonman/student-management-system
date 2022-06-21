package com.example.demo.registration;

public class RegistrationRequest {

    private final String fname;
    private final String lname;
    private final String email;
    private final String password;

    public RegistrationRequest(String fname, String lname, String email, String password) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
    }

    public String getFname() {
        return this.fname;
    }

    public String getLname() {
        return this.lname;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

}
