package com.mark;

import java.sql.*;
//GLAB_305.2.1
public class Insert_preparedSt_Example {
    public void preparedStatementInsertExample(){
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/classicmodels";
        String user = "****"; // The db username and password needs to be entered for code to work
        String password = "****";
    try{
        con = DriverManager.getConnection(url, user, password);
        System.out.println(" Connection Established successfully");
/*------ Lets insert one record using a prepared statement ---------*/
        String sqlQuery = "insert into EMPLOYEES " +
                "(officeCode,firstName,lastName,email,extension,reportsTo,VacationHours,employeeNumber,jobTitle)" +
                "" +
                " VALUES (?,?,?,?,?,?,?,?,?)";
        prepStmt = con.prepareStatement(sqlQuery);
        prepStmt.setInt(1,6);
        prepStmt.setString(2,"Jam");
        prepStmt.setString(3,"Rock");
        prepStmt.setString(4,"jr@gmail.com");
        prepStmt.setString(5,"2759");
        prepStmt.setInt(6,1143);
        prepStmt.setInt(7,9);
        prepStmt.setInt(8,0023);
        prepStmt.setString(9,"Manager");
        int affectedRows = prepStmt.executeUpdate();
        System.out.println(affectedRows + " rows affected !!");

        /* ------ Lets pull data from the database for an inserted record ------*/
        // Query which needs parameters
        prepStmt = con.prepareStatement("select * from EMPLOYEES where employeeNumber = ?");
        prepStmt.setInt(1,0003);
        //execute select query
        rs = prepStmt.executeQuery();
        //Display function to show the Resultset
        while(rs.next()){
            //System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
            System.out.println(rs.getString("firstName"));
            System.out.println(rs.getString("lastName"));
            System.out.println(rs.getString("email"));
            System.out.println(rs.getString("officeCode"));
        }
       prepStmt.close();
       con.close();

    }catch (SQLException sqle){
        sqle.printStackTrace();
        }
    }
}
