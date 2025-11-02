package com.jspiders.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args)
    {
        System.out.println("Program starts...");

        String dbUrl = "jdbc:mysql://localhost:3306/testDB";
        String username = "root";
        String password = "root";

        try
        {
            //establish the connection with DataBase
           Connection connection =
                   DriverManager.getConnection(dbUrl,username,password);

            System.out.println("Datatbase connection successfull");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Unable to connect to the DataBase");
        }

        System.out.println("Program ends...");
    }
}
