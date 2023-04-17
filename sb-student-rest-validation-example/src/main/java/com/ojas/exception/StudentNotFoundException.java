package com.ojas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class StudentNotFoundException extends RuntimeException {

	 public StudentNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public StudentNotFoundException(String message)
	{
		super(message);
	}
}
