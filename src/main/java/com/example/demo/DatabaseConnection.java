package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private Connection databaselink;
    public Connection getConnection() {
        String databaseName = "qltv";
        String databaseuser = "demo";
        String databasepassword = "putyourpasswordhere";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink = DriverManager.getConnection(url, databaseuser, databasepassword);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return databaselink;
    }
}
