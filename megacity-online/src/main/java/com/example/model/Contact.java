package com.example.model;

public class Contact {
	private int messageId;
    private String name;
    private String email;
    private String subject;
    private String message;
    
    public Contact(int messageId, String name, String email, String subject, String message) {
    	this.messageId =messageId;
    	this.name=name;
    	this.email=email;
    	this.subject=subject;
    	this.message=message;
    	
    	
    	
    	
    	
    	
    }

	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

	
	
}
