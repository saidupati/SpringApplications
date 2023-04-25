package com.ojas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ojas.model.Course;
import com.ojas.model.Student;
import com.ojas.repo.CourseRepo;

@SpringBootApplication
public class SpringStudentCourseRelationShipApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringStudentCourseRelationShipApplication.class, args);
	
		CourseRepo bean = run.getBean(CourseRepo.class);
		List<Student> stu=new ArrayList<>();
		Student s=new Student();
		s.setSid(1);
		s.setSname("sai");
		s.setSadd("hyd");
		Student s1=new Student();
		s1.setSid(2);
		s1.setSname("shiva");
		s1.setSadd("wgl");
		stu.add(s);
		stu.add(s1);
		Course c=new Course();
		c.setCid(101);
		c.setCname("java");
		c.setCadd("hyd");
		c.setCfee(1000);
		c.setStudents(stu);
		bean.save(c);
	}

}
