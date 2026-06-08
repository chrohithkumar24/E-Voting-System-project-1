package com.evoting.service;

import com.evoting.db.DBConnection;
import java.sql.*;

public class HODService {

    // 🔴 1. LOGIN METHOD
    public boolean login(String username, String password) {

        String query = "SELECT * FROM hod WHERE username=? AND password=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // 🔴 2. ADD CANDIDATE
    public void addCandidate(String name, String dept) {

        String query = "INSERT INTO candidates(name, department) VALUES(?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, name);
            ps.setString(2, dept);

            ps.executeUpdate();

            System.out.println("Candidate added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}