package com.mark;

import java.sql.*;

public class PreparedStatementExamples {

    /*
    Select all employees whose officecode is 1 and 4.
    Select all orderdetails whose orderNumber is 10100 and 10102.
    Update the extension number of employees whose officecode is 2, and the new extension number will be “5698.”
    Select all employees whose last name is less than five characters in length.
    **/

    public void selectOrderDetail() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url =  "jdbc:mysql://localhost:3306/classicmodels";
    final String USER = "****";// The db username and password needs to be entered for code to work
    final String PASS = "****";
    Connection conn = DriverManager.getConnection(url, USER , PASS );
    String SelectSQL = "  select* \n" +
            "      from  orderdetails \n" +
            "      where orderNumber = ? or orderNumber = ?;";
    PreparedStatement mystmt = conn.prepareStatement(SelectSQL);
    mystmt.setInt(1, 10100);
    mystmt.setInt(2, 10102);

    ResultSet result = mystmt.executeQuery();

    while(result.next())
    {
        int orderNumber = result.getInt("orderNumber");
        String productCode  = result.getString("productCode");
        String quantityOrdered = result.getString("quantityOrdered");
        String priceEach  = result.getString("priceEach");
        String orderLineNumber = result.getString("orderLineNumber");

        System.out.println(orderNumber +" | " + productCode+" | " + quantityOrdered+" | " + priceEach+" | " + orderLineNumber);
    }
    conn.close();
}

    public void updateExtensionNum() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url =  "jdbc:mysql://localhost:3306/classicmodels";
        final String USER = "****";// The db username and password needs to be entered for code to work
        final String PASS = "****";
        Connection conn = DriverManager.getConnection(url, USER , PASS );
        // Update the extension number of employees whose officecode is 2, and the new extension number will be “5698.”
        String SelectSQL ="update employees set extension =? where officecode =?";
        PreparedStatement mystmt = conn.prepareStatement(SelectSQL);
        mystmt.setString(1, "5698");
        mystmt.setString(2, "2");
        mystmt.executeUpdate();
        conn.close();
}
    public void employeeLastNameLenght() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url =  "jdbc:mysql://localhost:3306/classicmodels";
        final String USER = "****";// The db username and password needs to be entered for code to work
        final String PASS = "****";
        Connection conn = DriverManager.getConnection(url, USER , PASS );
        //Select all employees whose last name is  less than five characters in length.
        String SelectSQL = " select* from employees where LENGTH(lastName) < ?; ";
        PreparedStatement mystmt = conn.prepareStatement(SelectSQL);
        mystmt.setInt(1, 5);
        ResultSet result = mystmt.executeQuery();
        while(result.next())
        {
            String lastName  = result.getString("lastName");
            System.out.println(lastName);
        }
        conn.close();
    }

}
