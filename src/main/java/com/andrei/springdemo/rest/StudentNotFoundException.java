package com.andrei.springdemo.rest;

public class StudentNotFoundException extends RuntimeException {
	
	//generate constructors from super class
	
	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}
