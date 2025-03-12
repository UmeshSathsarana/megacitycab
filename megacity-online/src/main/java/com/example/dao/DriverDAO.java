package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.DriverModel;

public class DriverDAO {

    // ✅ Add a New Driver
    public static boolean addDriver(DriverModel driver) {
        String query = "INSERT INTO driver (fullName, address, phoneNumber, email, nicNumber, licNumber, image, password, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnectionFactroy.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, driver.getFullName());
            statement.setString(2, driver.getAddress());
            statement.setString(3, driver.getPhoneNumber());
            statement.setString(4, driver.getEmail());
            statement.setString(5, driver.getNicNumber());
            statement.setString(6, driver.getLicNumber());
            statement.setString(7, driver.getImage());
            statement.setString(8, driver.getPassword());
            statement.setString(9, driver.getStatus()); // Added status field

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ✅ Driver Login
    public static DriverModel loginDriver(String email, String password) {
        String query = "SELECT * FROM driver WHERE email = ? AND password = ?";

        try (Connection connection = DBConnectionFactroy.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new DriverModel(
                    resultSet.getInt("drvId"),
                    resultSet.getString("fullName"),
                    resultSet.getString("address"),
                    resultSet.getString("phoneNumber"),
                    resultSet.getString("email"),
                    resultSet.getString("nicNumber"),
                    resultSet.getString("licNumber"), // Fixed typo
                    resultSet.getString("image"),
                    resultSet.getString("password"),
                    resultSet.getString("status")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // ✅ Retrieve Driver by ID
    public static DriverModel getDriverById(int drvId) {
        String query = "SELECT * FROM driver WHERE drvId = ?";
        
        try (Connection connection = DBConnectionFactroy.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, drvId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new DriverModel(
                    resultSet.getInt("drvId"),
                    resultSet.getString("fullName"),
                    resultSet.getString("address"),
                    resultSet.getString("phoneNumber"),
                    resultSet.getString("email"),
                    resultSet.getString("nicNumber"),
                    resultSet.getString("licNumber"),
                    resultSet.getString("image"),
                    resultSet.getString("password"),
                    resultSet.getString("status")
                );
            } else {
                System.err.println("Driver not found in database for ID: " + drvId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // ✅ Retrieve All Drivers
    public static List<DriverModel> getAllDrivers() {
        List<DriverModel> drivers = new ArrayList<>();
        String query = "SELECT * FROM driver";

        try (Connection connection = DBConnectionFactroy.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                drivers.add(new DriverModel(
                    resultSet.getInt("drvId"),
                    resultSet.getString("fullName"),
                    resultSet.getString("address"),
                    resultSet.getString("phoneNumber"),
                    resultSet.getString("email"), // Fixed incorrect case
                    resultSet.getString("nicNumber"),
                    resultSet.getString("licNumber"),
                    resultSet.getString("image"),
                    resultSet.getString("password"),
                    resultSet.getString("status")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drivers;
    }

    // ✅ Update Driver Details
    public static boolean updateDriver(DriverModel driver) {
        String query = "UPDATE driver SET fullName = ?, address = ?, phoneNumber = ?, email = ?, nicNumber = ?, licNumber = ?, image = ?, password = ?, status = ? WHERE drvId = ?";

        try (Connection connection = DBConnectionFactroy.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, driver.getFullName());
            statement.setString(2, driver.getAddress());
            statement.setString(3, driver.getPhoneNumber());
            statement.setString(4, driver.getEmail());
            statement.setString(5, driver.getNicNumber());
            statement.setString(6, driver.getLicNumber());
            statement.setString(7, driver.getImage());
            statement.setString(8, driver.getPassword());
            statement.setString(9, driver.getStatus());
            statement.setInt(10, driver.getDrvId()); // Moved to last position

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // ✅ Delete Driver
    public static boolean deleteDriver(int drvId) {
        String query = "DELETE FROM driver WHERE drvId = ?";

        try (Connection connection = DBConnectionFactroy.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, drvId);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
