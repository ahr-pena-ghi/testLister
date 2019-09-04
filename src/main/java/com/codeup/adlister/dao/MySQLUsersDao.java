package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
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
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, phone_number, email, password, city, state) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPhone_number());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            stmt.setString(5, user.getCity());
            stmt.setString(6, user.getState());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("phone_number"),
            rs.getString("email"),
            rs.getString("password"),
            rs.getString("city"),
            rs.getString("state")
        );
    }


    public void updateUser(User user) {
        PreparedStatement stmt = null;
        try{
            stmt = connection.prepareStatement("UPDATE users SET id = ?, username = ?, email = ?, phone_number=?, password = ?, city = ?, state = ? WHERE id =" + user.getId());
            stmt.setLong(1,user.getId());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPhone_number());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            stmt.setString(6, user.getCity());
            stmt.setString(7, user.getState());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating user", e);
        }

    }


}
