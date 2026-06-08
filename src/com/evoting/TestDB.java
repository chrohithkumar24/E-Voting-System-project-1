package com.evoting;

import com.evoting.service.AuthService;
import com.evoting.service.VotingService;
import com.evoting.service.HODService;

import java.util.Scanner;

public class TestDB {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Student Login");
        System.out.println("2. HOD Login");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // clear buffer

        // 🔴 STUDENT FLOW
        if (choice == 1) {

            AuthService auth = new AuthService();
            VotingService vs = new VotingService();

            System.out.print("Enter Roll No: ");
            String roll = sc.nextLine();

            System.out.print("Enter Password: ");
            String pass = sc.nextLine();

            int studentId = auth.login(roll, pass);

            if (studentId != -1) {

                System.out.println("\nLogin Successful!");

                vs.showCandidates();

                System.out.print("\nEnter Candidate ID: ");
                int cid = sc.nextInt();

                vs.vote(studentId, cid);

                vs.showResults();

            } else {
                System.out.println("Invalid Login!");
            }

        }

        // 🔴 HOD FLOW
        else if (choice == 2) {

            HODService hod = new HODService();

            System.out.print("Enter Username: ");
            String user = sc.nextLine();

            System.out.print("Enter Password: ");
            String pass = sc.nextLine();

            if (hod.login(user, pass)) {

                System.out.println("\nHOD Login Successful!");

                System.out.print("Enter Candidate Name: ");
                String cname = sc.nextLine();

                System.out.print("Enter Department: ");
                String dept = sc.nextLine();

                hod.addCandidate(cname, dept);

            } else {
                System.out.println("Invalid HOD Login!");
            }
        }

        sc.close();
    }
}