package com.example.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Customer;

public class customerDAO {
	
     public static boolean addCustomer(Customer customer) {
    	 
    	 String query = "INSERT INTO customer (fullName, NicNumber, address, phoneNumber, Email, Password) VALUES (?, ?, ?, ?, ?, ?)";
    			 
    			try (Connection connection = DBConnectionFactroy.getConnection()){
    				if(connection == null) {
    					System.err.println("Database Connection null");
    					return false;
    				}
    			
    				PreparedStatement statement = connection.prepareStatement(query);
    				statement.setString(1, customer.getFullName());
    				statement.setString(2, customer.getNicNumber());
    				statement.setString(3, customer.getAddress());
    				statement.setString(4, customer.getPhoneNumber());
    				statement.setString(5, customer.getEmail());
    				statement.setString(6, customer.getPassword());
    				
    				
    				int rowsInserted = statement.executeUpdate();
    				return rowsInserted >0;
    				
    	 }catch (SQLException e) {
    		 e.printStackTrace();	// TODO: handle exception
		}
    	return false;
    	 
     }
     
     public static Customer loginCustomer(String Email, String Password) {
         String query = "SELECT * FROM customer WHERE Email = ? AND Password = ?";
         try (Connection connection = DBConnectionFactroy.getConnection()) {
             if (connection == null) {
                 System.err.println("Database Connection null");
                 return null;
             }

             PreparedStatement statement = connection.prepareStatement(query);
             statement.setString(1, Email);
             statement.setString(2, Password);

             ResultSet resultSet = statement.executeQuery();
             if (resultSet.next()) {
                 return new Customer(
                     resultSet.getInt("cusId"),
                     resultSet.getString("fullName"),
                     resultSet.getString("NicNumber"),
                     resultSet.getString("address"),
                     resultSet.getString("phoneNumber"),
                     resultSet.getString("Email"),
                     resultSet.getString("Password")
                 );
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return null;
         
     }
     public static Customer getcustomerById(int cusId ) {
    	 String query = "SELECT * FROM driver WHERE cusID=?";
    	 try (Connection connection = DBConnectionFactroy.getConnection();
    			 PreparedStatement statement = connection.prepareStatement(query)){
    		 
    		 ResultSet resultSet = statement.executeQuery();
             if (resultSet.next()) {
                 return new Customer(
                     resultSet.getInt("cusId"),
                     resultSet.getString("fullName"),
                     resultSet.getString("NicNumber"),
                     resultSet.getString("address"),
                     resultSet.getString("phoneNumber"),
                     resultSet.getString("Email"),
                     resultSet.getString("Password")
                 );
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return null;
         
}
     public static List<Customer> getAllCustomers() {
         List<Customer> customers = new ArrayList<>();
         try (Connection connection = DBConnectionFactroy.getConnection()) {
             String query = "SELECT * FROM customer";
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery();
             while (resultSet.next()) {
                 customers.add(new Customer(
                		 resultSet.getInt("cusId"),
                         resultSet.getString("fullName"),
                         resultSet.getString("NicNumber"),
                         resultSet.getString("address"),
                         resultSet.getString("phoneNumber"),
                         resultSet.getString("Email"),
                         resultSet.getString("Password")
                 ));
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return customers;
     }

     public static boolean deleteCustomer(int id) {
         try (Connection con = DBConnectionFactroy.getConnection()) {
             String query = "DELETE FROM customer WHERE cusId = ?";
             PreparedStatement ps = con.prepareStatement(query);
             ps.setInt(1, id);
             int rows = ps.executeUpdate();
             return rows > 0;
         } catch (Exception e) {
             e.printStackTrace();
         }
         return false;
     }

     public static boolean updateCustomer(Customer customer) {
         try (Connection connection= DBConnectionFactroy.getConnection()) {
             String query = "UPDATE customer SET fullName = ?, Email = ?, phoneNumber = ?, address = ? WHERE cusId = ?";
             PreparedStatement statement = connection.prepareStatement(query);
             statement.setInt(1, customer.getCusID());
             statement.setString(2, customer.getFullName());
             statement.setString(3, customer.getNicNumber());
             statement.setString(4, customer.getAddress());
             statement.setString(5, customer.getPhoneNumber());
             statement.setString(6, customer.getEmail());
             statement.setString(7, customer.getPassword());
           
           
             

             int rows = statement.executeUpdate();
             return rows > 0;
         } catch (Exception e) {
             e.printStackTrace();
         }
         return false;
     }
 }


