package com.example.service;

import com.example.dao.adminDAO;
import com.example.model.Admin;

public class AdminService {
	
	 public Admin loginAdmin(String email, String password) {
	        return adminDAO.loginAdmin(email, password);
	    }

}
