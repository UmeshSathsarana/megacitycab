package com.example.dao;

import com.example.model.BookingModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    // ✅ Method to Add a Booking
    public static boolean addBooking(BookingModel booking) {
        String query = "INSERT INTO booking (customerId, pickupLocation, dropLocation, pickupLat, pickupLng, dropLat, dropLng, distance, vehicleId, drvId, price, status) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnectionFactroy.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, booking.getCustomerId());
            stmt.setString(2, booking.getPickupLocation());
            stmt.setString(3, booking.getDropLocation());
            stmt.setDouble(4, booking.getPickupLat());
            stmt.setDouble(5, booking.getPickupLng());
            stmt.setDouble(6, booking.getDropLat());
            stmt.setDouble(7, booking.getDropLng());
            stmt.setDouble(8, booking.getDistance());
            stmt.setInt(9, booking.getVehicleId());
            stmt.setInt(10, booking.getDrvId());
            stmt.setDouble(11, booking.getPrice());
            stmt.setString(12, booking.getStatus());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ✅ Method to Update Booking Status
    public static boolean updateBookingStatus(int bookingId, String status) {
        String sql = "UPDATE booking SET status = ? WHERE bookingId = ?";

        try (Connection conn = DBConnectionFactroy.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, bookingId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ✅ Retrieve Bookings for a Customer
    public static List<BookingModel> getCustomerBooking(int customerId) {
        List<BookingModel> bookings = new ArrayList<>();
        String query = "SELECT * FROM booking WHERE customerId = ?";

        try (Connection conn = DBConnectionFactroy.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                bookings.add(mapBooking(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    // ✅ Retrieve Bookings for a Driver
    public static List<BookingModel> getDriverBooking(int drvId) {
        List<BookingModel> bookings = new ArrayList<>();
        String query = "SELECT * FROM booking WHERE drvId = ? AND (status = 'Pending' OR status = 'Accepted')";

        try (Connection conn = DBConnectionFactroy.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, drvId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                bookings.add(mapBooking(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    // ✅ Retrieve Bookings by Driver ID
    public static List<BookingModel> getBookingsByDriver(int drvId) {
        List<BookingModel> bookings = new ArrayList<>();
        String sql = "SELECT * FROM booking WHERE drvId = ?";

        try (Connection conn = DBConnectionFactroy.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, drvId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                bookings.add(mapBooking(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    // ✅ Maps a ResultSet Row to a BookingModel Object
    private static BookingModel mapBooking(ResultSet rs) throws SQLException {
        return new BookingModel(
            rs.getInt("bookingId"),
            rs.getInt("customerId"),
            rs.getString("pickupLocation"),
            rs.getString("dropLocation"),
            rs.getDouble("pickupLat"),
            rs.getDouble("pickupLng"),
            rs.getDouble("dropLat"),
            rs.getDouble("dropLng"),
            rs.getInt("vehicleId"),
            rs.getInt("drvId"),
            rs.getDouble("distance"),
            rs.getDouble("price"),
            rs.getString("status")
        );
    }
}
