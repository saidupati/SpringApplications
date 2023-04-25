package com.ojas.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.entity.Course;
import com.ojas.repo.CourseRepo;

@RestController
public class CourseController {
@Autowired
	private CourseRepo daoImp;
@PostMapping("/addCourse")
	public ResponseEntity<String> addCourse(@RequestBody  Course course)
	{
		Course saveEnt = daoImp.save(course);
		String msg="";
		if(saveEnt!=null)
			msg="Add Course SuccessFully";
		else
			msg="Course Not Added plz Check";
		
		return ResponseEntity.ok().body(msg);
	}
}
