package com.jspiders.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionsDemo {

    private  static  final String dbUrl = "jdbc:mysql://localhost:3306/appusers";
    private  static  final String username = "root";
    private  static  final String password = "root";
    private  static Connection con = null;
    public static void main(String[] args) {

        System.out.println("Program starts...");
        try
        {
            con = DriverManager.getConnection(dbUrl,username,password);
            con.setAutoCommit(false);
            //sql
            System.out.println("Adding user");
            String insertSql = "insert into appusers.users values" +
                    "(0,'TransactionUser','1000000000','pass789');";
            Statement stmt1 = con.createStatement();
            stmt1.executeUpdate(insertSql);
            System.out.println("Adding user successful");

            System.out.println("Update user");
            String updateSql = "update appusers.users " +
                               "set mobile = '2000000000' where mobile = '7654543210';";
            Statement stm2 = con.createStatement();
            int rowsAffected = stm2.executeUpdate(updateSql);
            if(rowsAffected == 0)
            {
                throw new SQLException("User with mobile number not found");
            }
            System.out.println("Updating user successful for "+rowsAffected+" user(s)");
            con.commit();//save All
        }
        catch (SQLException e)
        {
            try
            {
                con.rollback();//dont save
                System.err.println("TRANSACTION FAILED!!!");
                System.err.println("ROLLBACK CHANGES");
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }


        System.out.println("Program ends...");

    }
}











