package com.example.apirest.models;

import java.util.ArrayList;

public class ErrorResponse {
	
    private String message;
    private ArrayList<String> errors;
    
    public ErrorResponse(String message) {
    	this(message, new ArrayList<>());
	}
	public ErrorResponse(String message, ArrayList<String> errors) {
		this.message = message;
		this.errors = errors;
	}
	
	public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
    public ArrayList<String> getErrors() {
        return errors;
    }
    public void setErrors(ArrayList<String> errors) {
        this.errors = errors;
    }

}
