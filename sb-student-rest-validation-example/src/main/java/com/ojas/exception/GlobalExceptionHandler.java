package com.ojas.exception;
//defining exception handling for all the exceptions

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex,WebRequest req)
	{
	//Creating Exception Response Structure
		
		ExceptionResponse exRes=new ExceptionResponse(ex.getMessage(),req.getDescription(false),new Date());
	
	return new ResponseEntity(exRes,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<Object> handleResourceNotFoundException(Exception ex,WebRequest req)
	{
	//Creating Exception Response Structure
		
		ExceptionResponse exRes=new ExceptionResponse(ex.getMessage(),req.getDescription(false),new Date());
	
	return new ResponseEntity(exRes,HttpStatus.NOT_FOUND);
	}
	
}
