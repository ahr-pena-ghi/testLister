package com.codeup.adlister.models;

public class User {
    private long id;
    private String username;
//    private String phone_number;
    private String email;
    private String password;

    public User(String username, String phone_number, String email, String password) {}

    public User(String username, String email, String password) {
        this.username = username;
//        this.phone_number = phone_number;
        this.email = email;
        this.password = password;
    }

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
//        this.phone_number = phone_number;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public String getPhone_number() {
//        return phone_number;
//    }

//    public void setPhone_number(String phone_number) {
//        this.phone_number = phone_number;
//    }

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
}
