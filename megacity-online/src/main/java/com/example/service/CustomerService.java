package com.example.service;



import java.util.List;

import com.example.dao.customerDAO;

import com.example.model.Customer;

public class CustomerService {
	
	
	private static CustomerService instance;
	private customerDAO customerdao;
	
	
	public CustomerService() {
		this.customerdao = new customerDAO();
	}
	
	public static CustomerService getInstance() {
		if (instance == null) {
			synchronized (CustomerService.class) {
				if (instance == null) {
					instance = new CustomerService();
				}
			}
		}
		return instance;
		
	}
	
public boolean regiCustomer(Customer customer){
	boolean isRegistered = customerDAO.addCustomer(customer);
	if(!isRegistered) {
		System.err.println("Faild Register");
	}
	return isRegistered;
	
}

public Customer loginCustomer(String Email, String Password) {
    return customerDAO.loginCustomer(Email, Password); 
}

  public Customer getcustomerById(int cusId) {
	  return customerDAO.getcustomerById(cusId);
  }
  public List<Customer> getAllCustomers() {
      return customerDAO.getAllCustomers();
  }

  public boolean deleteCustomer(int id) {
      return customerDAO.deleteCustomer(id);
  }

  public boolean updateCustomer(Customer customer) {
      return customerDAO.updateCustomer(customer);
  }

}
