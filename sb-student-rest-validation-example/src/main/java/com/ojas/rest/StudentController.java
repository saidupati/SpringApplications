package com.ojas.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.model.Student;
import com.ojas.service.impl.StudentServiceImpl;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceImpl stuService;
	
	@PostMapping("/stdents")
	public ResponseEntity<String> createStudent(@Valid  @RequestBody   Student student)
	{
		System.out.println("hiiiiiiiii");
		System.out.println(student.getStuatus()+"\t"+student.getJoingDate());
		String saveStudent = stuService.saveStudent(student);
		
		
		return ResponseEntity.ok().body(saveStudent);
	}
	
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>>getAllStudents()
	{
		return ResponseEntity.ok().body(stuService.getAllStudents());
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentId(@PathVariable  int id)
	{
		
		return ResponseEntity.ok().body(stuService.getStudentById(id));
	}
	
@GetMapping("/student")
public ResponseEntity<String> deleteStudent(@RequestParam int sid)
{
	boolean deleteStudent = stuService.deleteStudent(sid);
	String msg=null;
	if(deleteStudent)
	{
		msg="Deleted SuccessFully";
	}
	else
	{
		msg="Record is not Exisit";
	}
	return ResponseEntity.ok().body(msg);
}

}
