package com.klu;

import java.sql.*;

public class JDBCcreate {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/fsad3";
        String usr = "root";
        String pwd = "Ashu@2005";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, usr, pwd);
            System.out.println("Database Connection established");

            Statement st = con.createStatement();

            String createDept =
                    "CREATE TABLE IF NOT EXISTS Dept (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "dept_name VARCHAR(20)" +
                    ")";
            st.executeUpdate(createDept);

            String createEmp =
                    "CREATE TABLE IF NOT EXISTS Emp (" +
                    "emp_id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(50), " +
                    "sal DOUBLE, " +
                    "dept_id INT, " +
                    "FOREIGN KEY (dept_id) REFERENCES Dept(id)" +
                    ")";
            st.executeUpdate(createEmp);

            st.executeUpdate("INSERT INTO Dept (dept_name) VALUES ('CSE')");
            st.executeUpdate("INSERT INTO Dept (dept_name) VALUES ('ECE')");

            st.executeUpdate("INSERT INTO Emp (name, sal, dept_id) VALUES ('Ravi', 45000, 1)");
            st.executeUpdate("INSERT INTO Emp (name, sal, dept_id) VALUES ('Sita', 55000, 2)");

            System.out.println("Data inserted successfully");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}