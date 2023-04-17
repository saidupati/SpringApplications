package com.ojas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/msg")
	public ResponseEntity<String> sayHello(@RequestParam("sname") HttpStatus name){
		
		HttpStatus msg=name;
		return new ResponseEntity(msg);
		
	}

}
