package com.example.LogIn.DTO;

public class LoginResponse {
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	String message;
    Boolean status;
	public LoginResponse(String message, Boolean status) {
		super();
		this.message = message;
		this.status = status;
	}
	public LoginResponse() {
		super();
	}
    
}
