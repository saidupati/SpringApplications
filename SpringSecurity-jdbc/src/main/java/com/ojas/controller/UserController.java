package com.ojas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.model.User;
import com.ojas.repo.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository users;
	@Autowired
	private PasswordEncoder pass;
	@PostMapping("/add")
	public String addUser(@RequestBody User user) {
		String password=user.getUpassword();
		String encode = pass.encode(password);
		user.setUpassword(encode);
		User save = users.save(user);
		if(save!=null) {
			return "user added";
		}
		else {
			return "not added";
		}
		
		
	}
}
