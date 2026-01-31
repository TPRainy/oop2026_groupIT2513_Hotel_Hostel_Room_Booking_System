package com.hotel.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://aws-1-ap-northeast-1.pooler.supabase.com:5432/postgres?sslmode=require";
    private static final String USER = "postgres.imumyrbfjafmmvkrycts";
    private static final String PASSWORD = loadPassword();

    private static String loadPassword() {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            props.load(input);
            String value = props.getProperty("DB_PASSWORD");
            if (value == null) return "FILE_NOT_READING_KEY";
            return value.trim();
        } catch (IOException e) {
            return "FILE_NOT_FOUND";
        }
    }

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        System.out.println("--- DB DEBUG ---");
        System.out.println("Connecting as: " + USER);
        System.out.println("Password loaded? " + (!PASSWORD.equals("FILE_NOT_FOUND") && !PASSWORD.equals("FILE_NOT_READING_KEY")));
        System.out.println("Password length: " + PASSWORD.length());
        System.out.println("-----------------");

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}