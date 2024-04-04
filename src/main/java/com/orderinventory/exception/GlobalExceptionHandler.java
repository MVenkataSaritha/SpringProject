package com.orderinventory.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomersNotFoundException.class)
	public ResponseEntity<ExceptionResponse> CustomerNotFound(CustomersNotFoundException e){
		ExceptionResponse response=new ExceptionResponse();
		response.setErrorCode("400 BAD REQUEST");
		response.setErrorMessage(e.getMessage());
		response.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntyity=new ResponseEntity<ExceptionResponse>(response,HttpStatus.CONFLICT);
		return responseEntyity;
	}
	
	@ExceptionHandler(DuplicateCustomerIDException.class)
	public ResponseEntity<ExceptionResponse> handleDuplicateIDException(DuplicateCustomerIDException e){
		ExceptionResponse response=new ExceptionResponse();
		response.setErrorCode("400 BAD REQUEST");
		response.setErrorMessage(e.getMessage());
		response.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntyity=new ResponseEntity<ExceptionResponse>(response,HttpStatus.CONFLICT);
		return responseEntyity;
	}
	
	@ExceptionHandler(InvalidCustomerIDException.class)
	public ResponseEntity<ExceptionResponse> InvalidCustomer(InvalidCustomerIDException e){
		ExceptionResponse response=new ExceptionResponse();
		response.setErrorCode("CONFLICT");
		response.setErrorMessage(e.getMessage());
		response.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntyity=new ResponseEntity<ExceptionResponse>(response,HttpStatus.CONFLICT);
		return responseEntyity;
	}

}
