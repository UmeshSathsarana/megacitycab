package com.example.service;




import java.sql.Driver;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import com.example.dao.DriverDAO;

import com.example.model.DriverModel;

public class DriverService {
	
	
	private static DriverService instance;
	private DriverDAO driverdao;
	
	public void init() throws ServletException {
    }
	
	
	public DriverService () {
		this.driverdao = new DriverDAO();
	}
	
	public static DriverService getInstance() {
		if (instance == null) {
			synchronized (DriverService.class) {
				if (instance == null) {
					instance = new DriverService();
				}
				
			}
		}
		return instance;
	}
	
	public static boolean regiDriver(DriverModel driver){
		boolean isRegistered = DriverDAO.addDriver(driver);
		if(!isRegistered) {
			System.err.println("Faild Register");
		}
		return isRegistered;
	}
	
	
	public DriverModel loginDdriver(String Email, String password) {
		return DriverDAO.loginDriver(Email, password);
	}
	public DriverModel getDriverDetails(int drvId) {
	    DriverModel driver = DriverDAO.getDriverById(drvId);
	    
	    if (driver == null) {
	        System.err.println("No driver found with ID: " + drvId);
	    }
	    
	    return driver;
	}


	
	  public static List<DriverModel> getAllDrivers() {  // Now it's non-static
	        return DriverDAO.getAllDrivers();
	    }
	 public static boolean updateDriver(DriverModel driver) {
	        return DriverDAO.updateDriver(driver);
	    }

	    // Delete driver
	    public static boolean deleteDriver(int drvId) {
	        return DriverDAO.deleteDriver(drvId);
	    }
	}

	
	
	

