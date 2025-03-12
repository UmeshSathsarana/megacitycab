package com.example.model;

public class Customer {

	private int cusID;
	private String fullName;
	private String nicNumber;
	private String address;
	private String phoneNumber;
	private String Email;
	private String password;
	
	public Customer(int cusID,  String fullName, String nicNumber, String address, String phoneNumber, String Email, String password) {
		this.cusID = cusID;
		this.fullName = fullName;
		this.nicNumber = nicNumber;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.Email = Email;
		this.password = password;
		
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public int getCusID() {
		return cusID;
	}

	public void setCusID(int cusID) {
		this.cusID = cusID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNicNumber() {
		return nicNumber;
	}

	public void setNicNumber(String nicNumber) {
		this.nicNumber = nicNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	
	
}
