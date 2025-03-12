package com.example.model;

public class BookingModel {
    private int bookingId;
    private int customerId;
    private String pickupLocation;
    private String dropLocation;
    private double pickupLat;
    private double pickupLng;
    private double dropLat;
    private double dropLng;
    private int vehicleId;
    private int drvId;
    private double distance;
    private double price;
    private String status;
    
    // Constructor for creating new booking (without ID & bookingTime)
    public BookingModel(int customerId, String pickupLocation, String dropLocation,
                        double pickupLat, double pickupLng, double dropLat, double dropLng,
                        int vehicleId, int drvId, double distance, double price, String status) {
        this.customerId = customerId;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.pickupLat = pickupLat;
        this.pickupLng = pickupLng;
        this.dropLat = dropLat;
        this.dropLng = dropLng;
        this.vehicleId = vehicleId;
        this.drvId = drvId;
        this.distance = distance;
        this.price = price;
        this.status = status;
    }

    // Constructor for fetching from DB (with ID & bookingTime)
    public BookingModel(int bookingId, int customerId, String pickupLocation, String dropLocation,
                        double pickupLat, double pickupLng, double dropLat, double dropLng,
                        int vehicleId, int drvId, double distance, double price, String status) {
        this(customerId, pickupLocation, dropLocation, pickupLat, pickupLng, dropLat, dropLng,
             vehicleId, drvId, distance, price, status);
        this.bookingId = bookingId;
       
    }

	public BookingModel() {
		// TODO Auto-generated constructor stub
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public String getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}

	public double getPickupLat() {
		return pickupLat;
	}

	public void setPickupLat(double pickupLat) {
		this.pickupLat = pickupLat;
	}

	public double getPickupLng() {
		return pickupLng;
	}

	public void setPickupLng(double pickupLng) {
		this.pickupLng = pickupLng;
	}

	public double getDropLat() {
		return dropLat;
	}

	public void setDropLat(double dropLat) {
		this.dropLat = dropLat;
	}

	public double getDropLng() {
		return dropLng;
	}

	public void setDropLng(double dropLng) {
		this.dropLng = dropLng;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getDrvId() {
		return drvId;
	}

	public void setDrvId(int drvId) {
		this.drvId = drvId;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


   
}
