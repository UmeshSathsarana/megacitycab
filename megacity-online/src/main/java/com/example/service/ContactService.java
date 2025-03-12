package com.example.service;

import com.example.dao.contactDAO;
import com.example.dao.customerDAO;
import com.example.model.Contact;

public class ContactService {
	
	private static ContactService instance;
	private static contactDAO contactdao;
	
	public ContactService () {
		this.contactdao = new contactDAO();
	}
	
	public static ContactService getInstance () {
		if(instance == null) {
			synchronized (ContactService.class) {
				if (instance == null) {
					instance = new ContactService();
				}
				
			}
		}
		return instance;
	}
	
	public static boolean regicontact(Contact contact) {
		boolean isRegistered = contactdao.addContact(contact);
		if(!isRegistered) {
			System.err.println("faild submont");
		}
		return isRegistered;
	}

}
