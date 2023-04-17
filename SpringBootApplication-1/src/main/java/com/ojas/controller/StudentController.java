package com.ojas.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class StudentController {
	
    
	@RequestMapping("/view")
	public String studentCon(@RequestParam int id,@RequestParam String sname,@RequestParam String sadd, Model m) {
		
		m.addAttribute("id",id);
		m.addAttribute("sname",sname);
		m.addAttribute("sadd",sadd);
		return "student.jsp";
	}
	
}
