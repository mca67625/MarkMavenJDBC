package com.mark;

import java.sql.*;
//GLAB_305.2.1
public class Update_preparedSt_Example {
    public void updatePreparedStExample() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String durl = "jdbc:mysql://localhost:3306/classicmodels";
        String user = "****";  // The db username and password needs to be entered for code to work
        String password = "****";
    try{
        con = DriverManager.getConnection(durl, user, password);
        System.out.println("Connected to database established successfully.");
        String sql = "Update employees set firstName=?, lastName = ? where employeeNumber = ?";

        ps = con.prepareStatement(sql);
        ps.setString(1, "Gary");
        ps.setString(2, "Larson");
        ps.setLong(3, 0003);

        int affectedRows = ps.executeUpdate();
        System.out.println(affectedRows + " rows affected.");

        ps = con.prepareStatement("select * from employees where employeeNumber = ?");
        ps.setInt(1, 1401);
        rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("firstName") + " |" + rs.getString("lastName") + " |" + rs.getString("email") + " |" + rs.getString("officeCode"));
        }

        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
