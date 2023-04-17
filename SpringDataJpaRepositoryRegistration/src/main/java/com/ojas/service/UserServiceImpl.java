package com.ojas.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.entity.User;
import com.ojas.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo repo;
	public String addUser(User user) {
		// TODO Auto-generated method stub
		User u=new User();
		BeanUtils.copyProperties(user, u);
		User save = repo.save(u);
		if(save!=null) {
			return "success";
		}
		else {
			return "not success";
		}
		
		
	}

	public boolean verifyUser(String uname, String password) {
	
		return false;
	}

}
