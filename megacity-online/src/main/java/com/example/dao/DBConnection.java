package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/megacitydb";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "BATmAN@%888";
	
	
	private static DBConnection instance;
	private static Connection connection;
	
	
	private DBConnection() {
		try {
			System.out.println("Drivers loaded:");
            DriverManager.drivers().forEach(driver -> System.out.println(driver.getClass().getName()));
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver registered!");
            
            this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Database connected successfully.");
		    }catch (ClassNotFoundException e) {
		    	System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
		    	
		    } catch (SQLException e) {
		        System.err.println("Failed to connect to database: " + e.getMessage());
		}
	}
	
	public static DBConnection getInstance() {
		if(instance == null) {
			synchronized(DBConnection.class) {
				if(instance == null) {
					instance = new DBConnection();
				}
			}
		}
		return instance;
	}
	
	public Connection getConnection() {
	    try {
	        if (connection == null || connection.isClosed()) {
	            System.out.println("Reconnecting...");
	            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	            connection.setCatalog("megacitydb");  // Manually select the database
	        }
	    } catch (SQLException e) {
	        System.err.println("Failed to reconnect: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return connection;
	}
}
		
		


