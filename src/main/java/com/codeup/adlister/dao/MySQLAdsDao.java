package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.CategsAds;
import com.mysql.cj.jdbc.Driver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }


    @Override
    public List<Ad> usersAds(Long idOfUser) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads where user_id =" + idOfUser);

            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving users ads.", e);
        }
    }


    @Override
    public void deleteAd(Long id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("DELETE FROM ads WHERE id =" + id);
             stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting ads");
        }
    }


    public void deleteCatAds(Long id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("DELETE FROM categs_ads WHERE ad_id =" + id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting ads");
        }
    }

    @Override
    public void updateAd(Ad ad) {
        PreparedStatement stmt = null;
        try{
            stmt = connection.prepareStatement("UPDATE ads SET id = ?, user_id = ?, title = ?, description = ?, price = ?, picture = ? WHERE id =" + ad.getId());
            stmt.setLong(1, ad.getId());
            stmt.setLong(2, ad.getUserId());
            stmt.setString(3, ad.getTitle());
            stmt.setString(4, ad.getDescription());
            stmt.setString(5, ad.getPrice());
            stmt.setString(6, ad.getPicture());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating ads", e);
        }

    }
    public List<CategsAds> findCategoriesByAdId(Long adId) {
//        String  query = "SELECT * FROM ads JOIN categs_ads ON ad_id = ?";
//        String query = "SELECT ads.title AS ad_title, ads.description AS ad_description FROM ads JOIN categs_ads ON ad_id = ?";
        String query = "SELECT * FROM categs_ads WHERE ad_id = ?";
        try {
            List<CategsAds> cats = new ArrayList<>();
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, adId);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            while(rs.next()) {
                cats.add(extractCategsAds(rs));
            }
            return cats;
        } catch (SQLException e) {
            throw new RuntimeException("Error finding Ad", e);
        }
    }

    private CategsAds extractCategsAds(ResultSet rs) throws SQLException {
        return new CategsAds(
                rs.getLong("categ_id"),
                rs.getLong("ad_id")
        );
    }




    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description, price, picture) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setString(4,ad.getPrice());
            stmt.setString(5,ad.getPicture());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getString("price"),
            rs.getString("picture")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    public Ad findAdsById(Long id) {
        String query = "SELECT * FROM ads WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return (Ad) extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding Ad", e);
        }
    }

    public void insertCategoryAds(CategsAds categsAds) {
        try {
            String query = "INSERT INTO categs_ads(categ_id, ad_id) VALUES (?, ?)";
                PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                stmt.setLong(1, categsAds.getCategId());
                stmt.setLong(2, categsAds.getAdId());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting category");
        }

    }




}
