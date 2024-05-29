package com.mark;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

       // PreparedStatementExamples pse = new PreparedStatementExamples();
        //pse.selectOrderDetail();
        //pse.updateExtensionNum();
        //pse.employeeLastNameLenght();

//        Insert_preparedSt_Example ipe = new Insert_preparedSt_Example();
//        ipe.preparedStatementInsertExample();

//        Update_preparedSt_Example upex = new Update_preparedSt_Example();
//        upex.updatePreparedStExample();

        JDBCInClassChallenge inClassChallenge = new JDBCInClassChallenge();
        inClassChallenge.connectToDB();
    }
}