# E-Voting System for Class Representative Elections

## Project Overview

The E-Voting System is a role-based voting application developed using Java, JDBC, and MySQL. The system is designed to conduct Class Representative (CR) elections in colleges securely and efficiently.

The application allows Head of Departments (HODs) to nominate candidates and students to cast votes. Each student can vote only once, ensuring transparency and fairness in the election process.

---

## Features

### HOD Module

* Secure HOD login
* Add CR candidates
* Manage candidate information
* View election details

### Student Module

* Student login using Roll Number
* View available candidates
* Cast vote for preferred candidate
* One-time voting validation

### Voting Module

* Secure vote recording
* Prevent duplicate voting
* Automatic vote counting
* Display election results

---

## Technologies Used

* Java 21
* JDBC (Java Database Connectivity)
* MySQL Database
* IntelliJ IDEA
* Git & GitHub

---

## Database Tables

### students

| Column  | Type         |
| ------- | ------------ |
| id      | INT          |
| name    | VARCHAR(100) |
| roll_no | VARCHAR(20)  |
| voted   | BOOLEAN      |

### candidates

| Column     | Type         |
| ---------- | ------------ |
| id         | INT          |
| name       | VARCHAR(100) |
| department | VARCHAR(50)  |
| votes      | INT          |

### hod

| Column   | Type        |
| -------- | ----------- |
| username | VARCHAR(50) |
| password | VARCHAR(50) |

---

## Project Structure

src/

├── com.evoting

│ ├── TestDB.java

│ ├── db

│ │ └── DBConnection.java

│ └── service

│ ├── AuthService.java

│ ├── HODService.java

│ └── VotingService.java

---

## Workflow

1. HOD logs into the system.
2. HOD adds CR candidates.
3. Student logs in using Roll Number.
4. System verifies student eligibility.
5. Available candidates are displayed.
6. Student selects a candidate.
7. Vote is stored in MySQL database.
8. Student status is updated to voted.
9. Duplicate voting is prevented.
10. Election results are generated.

---

## How to Run

1. Install Java 21.
2. Install MySQL Server.
3. Create the `evoting` database.
4. Create required tables.
5. Configure database credentials in `DBConnection.java`.
6. Run `TestDB.java`.
7. Login as HOD or Student.
8. Conduct voting and view results.

---

## Future Enhancements

* Java Swing GUI
* Spring Boot Web Application
* OTP Verification
* Email Notifications
* Election Analytics Dashboard

---

## Author

**CH. Rohithkumar**

Sreenidhi Institute of Science & Technology

Branch: Computer Science Engineering (CSE)
