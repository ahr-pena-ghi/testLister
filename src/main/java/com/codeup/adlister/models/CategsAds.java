package com.codeup.adlister.models;

public class CategsAds {
    private Long categId;
    private Long adId;

    public CategsAds(Long categId, Long adId) {
        this.categId = categId;
        this.adId = adId;
    }

    public Long getCategId() {
        return categId;
    }

    public void setCategId(Long categId) {
        this.categId = categId;
    }

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

    @Override
    public String toString() {
        return "CategsAds{" +
                "categId=" + categId +
                ", adId=" + adId +
                '}';
    }
}
