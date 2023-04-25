package com.Ojas.UserManagementSys.model;

import org.springframework.http.HttpStatus;

public class Errorvo {
	
	private HttpStatus status;
	private String message;
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Errorvo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
