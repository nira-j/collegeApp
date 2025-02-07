package com.college.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptioHandler {
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex, WebRequest request){
		ErrorResponse errorResponse=new ErrorResponse(
				    LocalDateTime.now(), 
				    ex.getMessage(),
				    request.getDescription(false)
				);
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	} 
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
		ErrorResponse errorResponse=new ErrorResponse(
				    LocalDateTime.now(), 
				    ex.getMessage(),
				    request.getDescription(false)
				);
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
}
