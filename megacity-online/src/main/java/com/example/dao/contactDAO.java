package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Contact;

public class contactDAO {
	
	public static boolean addContact(Contact contact) {
		
		String query = "INSERT INTO contact(name, email, subject, message) VALUES (?, ?, ?, ?)";
		
		try (Connection connection = DBConnectionFactroy.getConnection()){
			if(connection == null) {
				System.err.println("Database Connection null");
				return false;
			}
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, contact.getName());
            statement.setString(2, contact.getEmail());
            statement.setString(3, contact.getSubject());
            statement.setString(4, contact.getMessage());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	

	     
	}