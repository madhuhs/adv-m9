package com.jspiders.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDemo {

    public static void main(String[] args) {
        System.out.println("Program starts...");

        String dbUrl = "jdbc:mysql://localhost:3306/appusers";
        String username = "root";
        String password = "root";

        String updateSql = "update appusers.users set mobile = '7654321098' where userid = 1;";

        try
        {
            //establish the connection with DataBase
            Connection con =
                    DriverManager.getConnection(dbUrl,username,password);

            System.out.println("Connected to appusers-db successfully");

            Statement stm1 = con.createStatement();
            //executeUpdate(String sql): executes DML staments and returns int
            int rowsAffected = stm1.executeUpdate(updateSql);
            System.out.println(rowsAffected+" row(s) updated");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Unable to connect to appusers-db ");
        }

        System.out.println("Program ends...");

    }
}
