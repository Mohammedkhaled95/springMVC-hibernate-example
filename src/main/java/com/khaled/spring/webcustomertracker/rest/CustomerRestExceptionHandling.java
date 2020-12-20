package com.khaled.spring.webcustomertracker.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandling {

	@ExceptionHandler
	public ResponseEntity<CustomerErrorRespose> handleException(CustomerNotFoundException ex){
		
		CustomerErrorRespose errorRespose =new CustomerErrorRespose(HttpStatus.NOT_FOUND.value(),
																	ex.getMessage(), 
																	System.currentTimeMillis());
		
		
		return new ResponseEntity<>(errorRespose, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorRespose> handleException(Exception ex){
		
		CustomerErrorRespose errorRespose =new CustomerErrorRespose(HttpStatus.BAD_REQUEST.value(),
																	ex.getMessage(), 
																	System.currentTimeMillis());
		
		
		return new ResponseEntity<>(errorRespose, HttpStatus.BAD_REQUEST);
		
	}
}
