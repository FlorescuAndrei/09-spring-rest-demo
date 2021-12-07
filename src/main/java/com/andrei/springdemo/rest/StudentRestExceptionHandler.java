package com.andrei.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	//this exception handler method can be put in StudentRestController class 
	//but for global use we put them in a separate @ControlerAdvice annotatedclass
	
		//exception for invalid id number
		//Add an exception handler to bind StudentNotFindException with StudentErrorResponse
		//Response type(Student error response); Exception type to handle/what we are going to catch(StudentNotFoudException)
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
			
			StudentErrorResponse error = new StudentErrorResponse();
			
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(e.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
		
		//Add another excetpion handler to catch any exception
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception e){
			
			StudentErrorResponse error = new StudentErrorResponse();
			
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage(e.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
		

}
