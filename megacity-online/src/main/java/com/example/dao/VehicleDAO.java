package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.VehicleModel;

public class VehicleDAO {
    
    public static boolean addVehicle(VehicleModel vehicle) {
        String query = "INSERT INTO vehicle(drvId, vehiclenumber, model, type, seatingcapacity, vtype,pricePerKm) VALUES (?, ?, ?, ?, ?, ?,?)";

        try (Connection connection = DBConnectionFactroy.getConnection()) {
            if (connection == null) {
                System.err.println("Database Connection null");
                return false;
            }

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, vehicle.getDrvId());
            statement.setString(2, vehicle.getVehiclenumber());
            statement.setString(3, vehicle.getModel());
            statement.setString(4, vehicle.getType());
            statement.setString(5, vehicle.getSeatingcapacity());
            statement.setString(6, vehicle.getVtype());
            statement.setDouble(7, vehicle.getPricePerKm());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static VehicleModel getVehicleByDriverId(int drvId) {
        String query = "SELECT * FROM vehicle WHERE drvId = ?";
        try (Connection connection = DBConnectionFactroy.getConnection()) {
            if (connection == null) {
                System.err.println("Database Connection null");
                return null;
            }

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, drvId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new VehicleModel(
                		resultSet.getInt("VehicleId"),
                		resultSet.getInt("drvId"),
                		resultSet.getString("vehiclenumber"),
                		resultSet.getString("model"),
                		resultSet.getString("type"),
                		resultSet.getString("seatingcapacity"),
                		resultSet.getString("vtype"),
                		 resultSet.getDouble("pricePerKm")
                		
                		);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<VehicleModel> getAllVehicles() {
        List<VehicleModel> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicle";
        try (Connection connection = DBConnectionFactroy.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                vehicles.add(new VehicleModel(
                    resultSet.getInt("VehicleId"),
                    resultSet.getInt("drvId"),
                    resultSet.getString("vehiclenumber"),
                    resultSet.getString("model"),
                    resultSet.getString("type"),
                    resultSet.getString("seatingcapacity"),
                    resultSet.getString("vtype"),
                    resultSet.getDouble("pricePerKm")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
    
    public static VehicleModel getVehicleById(int vehicleId) {
        String query = "SELECT * FROM vehicle WHERE vehicleId = ?";
        try (Connection connection = DBConnectionFactroy.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, vehicleId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new VehicleModel(
                    resultSet.getInt("vehicleId"),
                    resultSet.getInt("drvId"),
                    resultSet.getString("vehiclenumber"),
                    resultSet.getString("model"),
                    resultSet.getString("type"),
                    resultSet.getString("seatingcapacity"),
                    resultSet.getString("vtype"),
                    resultSet.getDouble("pricePerKm")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

