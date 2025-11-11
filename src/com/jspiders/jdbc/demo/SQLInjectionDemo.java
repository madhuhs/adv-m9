package com.jspiders.jdbc.demo;

import java.sql.*;

public class SQLInjectionDemo {

    static String dbUrl = "jdbc:mysql://localhost:3306/appusers";
    static String username = "root";
    static String password = "root";

    public static void loginV2(String mobile,String pass)
    {
        String selectSql = "SELECT * FROM users WHERE mobile = ? AND password = ?;";

        try
        {
            //establish the connection with DataBase
            Connection con =
                    DriverManager.getConnection(dbUrl,username,password);

            PreparedStatement psm1 = con.prepareStatement(selectSql);
            psm1.setString(1,mobile);
            psm1.setString(2,pass);

            System.out.println("query : "+psm1);

            ResultSet rs = psm1.executeQuery();
            if(rs.next()) {
                System.out.println("Login SUCCESS");
            }
            else {
                System.out.println("Login FAILED");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public static void login(String mobile,String pass)
    {
        String selectSql = "SELECT * FROM users " +
                "WHERE mobile = '" + mobile + "' AND password = '" + pass + "'";

        try
        {
            Connection con = DriverManager.getConnection(dbUrl,username,password);

            Statement stm1 = con.createStatement();

            System.out.println("query : "+selectSql);

            ResultSet rs = stm1.executeQuery(selectSql);
           if(rs.next()) {
               System.out.println("Login SUCCESS");
           }
           else {
               System.out.println("Login FAILED");
           }
        }
        catch (SQLException e)
        {
           e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String mobile = "' OR '1'='1";
        String pass = "' OR '1'='1";
        login(mobile,pass);
    }
}
