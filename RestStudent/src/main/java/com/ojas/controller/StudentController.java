package com.ojas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.entity.Student;

@RestController
public class StudentController {

	@GetMapping(value="/student/{sid}")
	/*public Student getStudent(@PathVariable("sid") int sid) {*/
	public Student getStudent(@PathVariable int sid) {
		Student s=new Student();
		if(sid==1)
		{
		s.setSid(1);
		s.setSname("prasanna");
		s.setSadd("hyd");
		}
		else if(sid==2) {
			s.setSid(2);
			s.setSname("sai");
			s.setSadd("warangal");
		}
		return s;
		
	}
}