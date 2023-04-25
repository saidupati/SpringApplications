package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.model.Dept;
import com.example.model.Employee;
import com.example.repo.EmployeeRepo;

@SpringBootApplication
public class SbDeptEmpApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SbDeptEmpApplication.class, args);
		
		EmployeeRepo depImpl= 		ctx.getBean(EmployeeRepo.class);

		Dept d=new Dept();
		d.setDname("IT");
		d.setLoc("HYD");
		
		Employee emp=new Employee();
		emp.setEno(1);
		emp.setName("shiva");
		emp.setSalary(2500);
		emp.setDepartment(d);
		
		Employee emp1=new Employee();
		emp1.setName("rani");
		emp1.setSalary(2500);
		emp1.setDepartment(d);
		
		
		
		
	
		
		
		depImpl.save(emp);
		depImpl.save(emp1);
	}

}
