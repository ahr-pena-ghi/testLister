package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.CategsAds;

import java.sql.ResultSet;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    Ad findAdsById(Long id);
    List<Ad> usersAds(Long idOfUser);
    void deleteAd(Long id);
    void updateAd(Ad ad);
    void insertCategoryAds(CategsAds categsAds);
    List<CategsAds> findCategoriesByAdId(Long adId);
    void deleteCatAds(Long id);
}
