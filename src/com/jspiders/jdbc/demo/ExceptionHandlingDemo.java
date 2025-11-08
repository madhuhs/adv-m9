package com.jspiders.jdbc.demo;

import java.sql.*;

public class ExceptionHandlingDemo {
    public static Connection getDbConnection()
    {
        Connection con = null;

        String dbUrl = "jdbc:mysql://localhost:3306/appusers";
        String username = "root";
        String password = "root";

        try
        {
            con = DriverManager.getConnection(dbUrl,username,password);
            System.out.println("Connected to appusers-db successfully");
        }
        catch (SQLException e)
        {
            System.err.println("ERROR while connecting to Database : "+e.getMessage());
            throw new DBConnectionException(e.getMessage());
        }
        return con;
    }

    public static void addUser()
    {
        String insertSql = "insert into appusers.users values" +
                "(0,'DeleteUser','7654543213','pass789');";

        try
        {
            Connection con = getDbConnection();
            Statement stm1 = con.createStatement();
            int rowsAffected = stm1.executeUpdate(insertSql);
            System.out.println(rowsAffected+" row(s) added");
        }

        catch (SQLSyntaxErrorException ex)
        {
            throw new RuntimeException(ex.getMessage());
        }

        catch (SQLException e)
        {
            throw new DuplicatePhoneNumberException("User with mobile number already exists");
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Program starts...");
        addUser();
        System.out.println("Program ends...");
    }
}
