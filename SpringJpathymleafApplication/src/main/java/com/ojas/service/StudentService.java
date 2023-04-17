package com.ojas.service;

import java.util.List;

import com.ojas.entity.StudentEntity;

public interface StudentService {

	public String addStudent(StudentEntity student);
	public StudentEntity verify(String name,String password); 
		
		
		
		
	
}
