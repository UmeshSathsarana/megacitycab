package com.example.service;

import java.util.List;

import com.example.dao.VehicleDAO;
import com.example.model.VehicleModel;

public class VehicleService {
    public static boolean registerVehicle(VehicleModel vehicle) {
        return VehicleDAO.addVehicle(vehicle);
    }

    public static VehicleModel getVehicleByDriverId(int drvId) {
        return VehicleDAO.getVehicleByDriverId(drvId);
    }
    
    public static List<VehicleModel> getAllVehicles() {
        return VehicleDAO.getAllVehicles();
    }

    
}
