package com.thuannguyen.bookstorepos.models;

public class User {
    private String username;
    private String password;
    private String phoneNumber;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public String getUsername() {
        return username;
    }
}
