package com.ojas.exception;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

//Customize the Exception Message
@Data
@NoArgsConstructor
public class ExceptionResponse {

	String message;
	String detail;
	Date timestamp;
	public ExceptionResponse(String message, String detail, Date timestamp) {
		super();
		this.message = message;
		this.detail = detail;
		this.timestamp = timestamp;
	}
	
	
}
