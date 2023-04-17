package com.ojas.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/welcome")
	public String welcomeOjas() {
		return "Welcome to Ojas";
		
		
	}
	@GetMapping("/to")
	public String welcomeToOjas(@RequestParam String name) {
		return "Welcome To Ojas : "+name;
		
	}
	@GetMapping("/from")
	public String sayHi(HttpServletRequest req) {
		String name=req.getParameter("sname");
		return "Say Hi To Ojas From : "+name;
	}
	@GetMapping("/aaa/{sname}")
	public String sayHello(@PathVariable("sname") String name) {
		return "Hii everyOne from : "+name;
		
	}
} 
