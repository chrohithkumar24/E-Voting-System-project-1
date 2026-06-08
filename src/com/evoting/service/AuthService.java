package com.evoting.service;

import com.evoting.db.DBConnection;
import java.sql.*;

public class AuthService {

    public int login(String roll, String password) {

        String query = "SELECT id FROM students WHERE roll_no=? AND password=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, roll);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id"); // return student ID
            }

        } catch (Exception e) {
            System.out.println("Login error: " + e.getMessage());
        }

        return -1; // login failed
    }
}