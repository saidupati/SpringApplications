package com.ojas.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ojas.entity.StudentEntity;
import com.ojas.repository.StudentRepository;

@Service
public abstract class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;
	public String addStudent(StudentEntity student) {
		// TODO Auto-generated method stub
		StudentEntity s=new StudentEntity();
		BeanUtils.copyProperties(student, s);
		StudentEntity save = repo.save(s);
		if(save!=null) {
			return "added successfully";
		}
		else {
		return "Not added ";
	}
	}	
	@Override
	public StudentEntity verify(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
