package com.codeup.adlister.models;

public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;
    private String price;
    private String picture;
    private CategsAds categsAds;

    public Ad(long id, long userId, String title, String description, String price, String picture) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.picture = picture;
    }

    public Ad(long userId, String title, String description, String price, String picture) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.picture = picture;
    }

    // Cat Ads

    public Ad(long userId, String title, String description, String price, String picture, CategsAds categsAds) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.picture = picture;
        this.categsAds = categsAds;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public CategsAds getCategsAds() {
        return categsAds;
    }

    public void setCategsAds(CategsAds categsAds) {
        this.categsAds = categsAds;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
