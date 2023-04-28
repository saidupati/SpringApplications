package com.ojas.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {
	
	@GetMapping("/hello")
	public String getHello() {
		return "home";
	}
	
	@GetMapping("/logout")
	public String getLogout() {
		
		return "hello";
	}
	
	@GetMapping("/message")
	
	public String getMessage() {
		
		return "login";
	}
	

}
