package com.ojas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ojas.entity.User;
import com.ojas.service.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl impl;
	
	@RequestMapping("/registeruser")
	public String adduserDetails(Model m) {
		User u=new User();
		
		m.addAttribute("user", u);
		return "register";
		
	}
//	@RequestMapping(value="/registeruser",method = RequestMethod.POST )
//	public String saveUserDetails(@ModelAttribute("user") User user,Model m) {
//		
//		
//		String addUser = impl.addUser(user);
//		String msg="";
//		if(addUser!=null) {
//			msg="success";
//		}
//		else {
//			msg="not success";
//		}
//		m.addAttribute("msg", msg);
//		return "register";
//	}
}
