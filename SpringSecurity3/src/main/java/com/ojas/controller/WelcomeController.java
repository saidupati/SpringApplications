package com.ojas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/home")
	public String welcomeTo() {
		String msg="Wlcome to Ojas";
		return msg;
	}@GetMapping("/balance")
	public String getBalance() {
		String msg="Current Balance is : "+4500;
		return msg;
	}
	@GetMapping("/loan")
	public String getLoan() {
		String msg="your loan amount is : "+150000;
		return msg;
	}
	@GetMapping("/statement")
	public String getStatement() {
		String msg="Your statement sent to ur mail id";
		return msg;
	}
	@GetMapping("/contact")
	public String getContact() {
		String msg="contact Details : "+987543756;
		return msg;
	}
}
