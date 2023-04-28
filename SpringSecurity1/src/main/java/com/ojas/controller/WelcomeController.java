package com.ojas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/welcome/{name}")
	public String welcomeToOjas(@PathVariable String name) {
		return "Welocme to Ojas Ms :"+name;
		
	}
}
