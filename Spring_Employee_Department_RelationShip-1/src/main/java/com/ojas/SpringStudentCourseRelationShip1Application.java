package com.ojas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ojas.model.Department;
import com.ojas.model.Employee;
import com.ojas.repo.EmployeeRepo;


@SpringBootApplication
public class SpringStudentCourseRelationShip1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringStudentCourseRelationShip1Application.class, args);
	
	  EmployeeRepo bean = run.getBean( EmployeeRepo.class);
	  Department d=new Department();
	  d.setDId(1);
	  d.setDName("hr");
	  d.setDLoc("hyd");
	  
	  List<Employee> emp=new ArrayList<>();
	
	  Employee e=new Employee();
	  e.setEid(101);
	  e.setEname("prasanna");
	  e.setEadd("wgl");
	  e.setEsal("1000");
	  e.setDepartment(d);
	  
	  Employee e1=new Employee();
	  e1.setEid(102);
	  e1.setEname("shivasai");
	  e1.setEadd("wgl");
	  e1.setEsal("1500");
	  e.setDepartment(d);
	  
	  Employee e2=new Employee();
	  e2.setEid(103);
	  e2.setEname("sai");
	  e2.setEadd("hyd");
	  e2.setEsal("1700");
	  e.setDepartment(d);
	  
	  emp.add(e);
	  emp.add(e1);
	  emp.add(e2);
	  
	 
	 
	bean.save(e);
	bean.save(e1);
	bean.save(e2);
	 
	}

}
