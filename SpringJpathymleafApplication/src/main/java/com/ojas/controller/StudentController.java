package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ojas.entity.StudentEntity;
import com.ojas.service.StudentServiceImpl;

@Controller
public class StudentController {

	@Autowired
	private StudentServiceImpl impl;
	
	@RequestMapping("/")
	public String addStudent(Model m) {
	
		StudentEntity s=new StudentEntity();
		m.addAttribute("student", s);
		return "index";
		
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String handleSave(@ModelAttribute("student") StudentEntity student,Model m) {
		String addStudent = impl.addStudent(student);
		String msg="";
		if(addStudent!=null) {
			msg="added";
		}
		else {
			msg= "not added";
		}
		return "index";
		
		
	}
	@RequestMapping("/login")
     public String login(Model m) {
		StudentEntity s=new StudentEntity();
		m.addAttribute("login",s);
		return "login";
    	 
     }
}