package com.example.service;

import com.example.dao.BookingDAO;
import com.example.dao.VehicleDAO;
import com.example.model.BookingModel;
import com.example.model.VehicleModel;

import java.util.List;

public class BookingService {
    private static BookingService instance;

    public static BookingService getInstance() {
        if (instance == null) {
            instance = new BookingService();
        }
        return instance;
    }

    public boolean addBooking(int customerId, String pickupLocation, String dropLocation,
            double pickupLat, double pickupLng, double dropLat, double dropLng,
            int vehicleId, double distance, double price, String status) {

VehicleModel vehicle = VehicleDAO.getVehicleById(vehicleId);
if (vehicle == null) return false;

int drvId = vehicle.getDrvId();  // ✅ Correct driver from vehicle

BookingModel booking = new BookingModel(
customerId, pickupLocation, dropLocation,
pickupLat, pickupLng, dropLat, dropLng,
vehicleId, drvId, distance, price, "Pending"
);

return BookingDAO.addBooking(booking);
}

    public boolean updateBookingStatus(int bookingId, String status) {
        return BookingDAO.updateBookingStatus(bookingId, status);
    }

    public List<BookingModel> getCustomerBookings(int customerId) {
        return BookingDAO.getCustomerBooking(customerId);
    }

    public List<BookingModel> getDriverBookings(int drvId) {
        return BookingDAO.getDriverBooking(drvId);
    }
    
    public List<BookingModel> getBookingsByDriverId(int  drvId) {
        return BookingDAO.getBookingsByDriver( drvId);
    }
}
