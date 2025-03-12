package com.example.model;

public class VehicleModel {
	private int vehicleId;
    private int drvId;
    private String  vehiclenumber;
    private String model;
    private String   type;
    private String seatingcapacity;
    private String vtype;
    private double pricePerKm;

    public VehicleModel(int vehicleId, int drvId, String  vehiclenumber, String model, String type, String seatingcapacity, String vtype, double pricePerKm) {
        this.vehicleId = vehicleId;
        this.drvId = drvId;
        this. vehiclenumber = vehiclenumber;
        this.model = model;
        this.type = type;
        this.seatingcapacity = seatingcapacity;
        this.vtype= vtype;
        this.pricePerKm=pricePerKm;
    }

	public String getVtype() {
		return vtype;
	}

	public double getPricePerKm() {
		return pricePerKm;
	}

	public void setPricePerKm(double pricePerKm) {
		this.pricePerKm = pricePerKm;
	}

	public void setVtype(String vtype) {
		this.vtype = vtype;
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

	public String getVehiclenumber() {
		return vehiclenumber;
	}

	public void setVehiclenumber(String vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSeatingcapacity() {
		return seatingcapacity;
	}

	public void setSeatingcapacity(String seatingcapacity) {
		this.seatingcapacity = seatingcapacity;
	}

	
    
    
}