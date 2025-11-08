package com.jspiders.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {

    public static void main(String[] args)
    {
        System.out.println("Program starts...");

        String dbUrl = "jdbc:mysql://localhost:3306/appusers";
        String username = "root";
        String password = "root";

        String insertSql = "insert into appusers.users values" +
                "(0,'DeleteUser','7654543210','pass789');";

        try
        {
            //establish the connection with DataBase
            Connection con =
                    DriverManager.getConnection(dbUrl,username,password);

            System.out.println("Connected to appusers-db successfully");

           Statement stm1 = con.createStatement();
           //executeUpdate(String sql): executes DML staments and returns int
           int rowsAffected = stm1.executeUpdate(insertSql);
           System.out.println(rowsAffected+" row(s) added");
        }
        catch (SQLException e)
        {
            throw new DuplicatePhoneNumberException("User with mobile number already exists");
        }
        System.out.println("Program ends...");

    }
}
