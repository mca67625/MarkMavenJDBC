package com.mark;

import java.io.FileNotFoundException;
import java.sql.*;

import static java.lang.Class.forName;

public class JDBCInClassChallenge {

    public void connectToDB() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/classicmodels";
        String user = "***"; // The db username and password needs to be entered for code to work
        String password = "***";
        System.out.println("---------MySQL JDBC Connection Demo---------");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);

            String SelectSQL = "select * from employees";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SelectSQL);

            while (rs.next()) {
                String EmployeeID = rs.getString("employeeNumber");
                String fname = rs.getString("firstName");
                String lname = rs.getString("lastName");
                System.out.println(EmployeeID + "|" + fname + "|" + lname);
            }

            connection.close();

    }
}

