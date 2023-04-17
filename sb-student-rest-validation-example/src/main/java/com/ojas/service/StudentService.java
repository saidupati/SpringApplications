package com.ojas.service;

import java.util.List;

import com.ojas.model.Student;

public interface StudentService {

	String saveStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentById(int id);
	boolean deleteStudent(int sid);
}
