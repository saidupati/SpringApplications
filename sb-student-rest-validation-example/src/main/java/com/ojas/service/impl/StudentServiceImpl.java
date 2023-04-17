package com.ojas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ojas.exception.StudentNotFoundException;
import com.ojas.model.Student;
import com.ojas.repo.StudentRepository;
import com.ojas.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository stuRepo;
	
	@Override
	public String saveStudent(Student student) {
		// TODO Auto-generated method stub
		System.out.println(student.getJoingDate()+"\t"+student.getStuatus());
		Student savedEnt = stuRepo.save(student);
		String msg=null;
		if(savedEnt!=null)
			msg="Data Inserted SuccessFully";
		else
			msg="Data Not Inserted SuccessFully";
		return msg;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return stuRepo.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		Optional<Student> findById = stuRepo.findById(id);
		if(findById.isPresent())
		{
			return findById.get();
		}
		else
			throw new StudentNotFoundException("Record Not Found With Given Id"+id);
		
	
		
	}

	@Override
	public boolean deleteStudent(int sid) {
		// TODO Auto-generated method stub
		 Student student = stuRepo.findById(sid).get();
		 boolean flag=false;
if(student!=null)
{
		stuRepo.deleteById(sid);
flag=true;
}
		return flag;
	}

}
