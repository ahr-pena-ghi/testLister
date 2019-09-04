package com.codeup.adlister.models;

public class User {
    private long id;
    private String username;
    private String phone_number;
    private String email;
    private String password;
    private String city;
    private String state;

    public User(String username, String phone_number, String email, String password, String city, String state) {
        this.username = username;
        this.phone_number = phone_number;
        this.email = email;
        this.password = password;
        this.city = city;
        this.state = state;
    }

    public User(long id, String username, String phone_number, String email, String password, String city, String state) {
        this.id = id;
        this.username = username;
        this.phone_number = phone_number;
        this.email = email;
        this.password = password;
        this.city = city;
        this.state = state;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}


