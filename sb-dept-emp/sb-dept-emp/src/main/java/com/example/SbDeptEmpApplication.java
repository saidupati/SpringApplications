package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.model.Dept;
import com.example.model.Employee;
import com.example.repo.DeptReo;

@SpringBootApplication
public class SbDeptEmpApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SbDeptEmpApplication.class, args);
		
		DeptReo depImpl= 		ctx.getBean(DeptReo.class);

		
		Employee emp=new Employee();
		emp.setEno(1);
		emp.setName("shiva");
		emp.setSalary(2500);
		
		Employee emp1=new Employee();
		emp1.setName("rani");
		emp1.setSalary(2500);
		List<Employee>addEmp=new ArrayList<>();
		addEmp.add(emp);
		addEmp.add(emp1);
		
		
		
		Dept d=new Dept();
		d.setDno(1);
		d.setDname("IT");
		d.setLoc("HYD");
		d.setEmployees(addEmp);
		depImpl.save(d);
	}

}
