package com.evoting.service;

import com.evoting.db.DBConnection;
import java.sql.*;

public class VotingService {

    // 🔴 1. SHOW CANDIDATES
    public void showCandidates() {

        String query = "SELECT id, name FROM candidates";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            System.out.println("\nAvailable Candidates:");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                                rs.getString("name")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔴 2. VOTE METHOD (CORE LOGIC)
    public void vote(int studentId, int candidateId) {

        try (Connection con = DBConnection.getConnection()) {

            // ✅ Step 1: Check if already voted
            String checkQuery = "SELECT has_voted FROM students WHERE id=?";
            PreparedStatement ps1 = con.prepareStatement(checkQuery);
            ps1.setInt(1, studentId);

            ResultSet rs = ps1.executeQuery();

            if (rs.next() && rs.getBoolean("has_voted")) {
                System.out.println("❌ You already voted!");
                return;
            }

            // ✅ Step 2: Insert vote
            String insertVote = "INSERT INTO votes(student_id, candidate_id) VALUES(?, ?)";
            PreparedStatement ps2 = con.prepareStatement(insertVote);
            ps2.setInt(1, studentId);
            ps2.setInt(2, candidateId);
            ps2.executeUpdate();

            // ✅ Step 3: Update student
            String update = "UPDATE students SET has_voted=TRUE WHERE id=?";
            PreparedStatement ps3 = con.prepareStatement(update);
            ps3.setInt(1, studentId);
            ps3.executeUpdate();

            System.out.println("✅ Vote Successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔴 3. SHOW RESULTS
    public void showResults() {

        String query =
                "SELECT c.name, COUNT(v.id) AS total_votes " +
                        "FROM candidates c LEFT JOIN votes v " +
                        "ON c.id = v.candidate_id " +
                        "GROUP BY c.id";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            System.out.println("\nElection Results:");

            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + " - " +
                                rs.getInt("total_votes") + " votes"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}