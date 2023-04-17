package com.ojas.service;

import com.ojas.entity.User;

public interface UserService {

	public String addUser(User user);
	public boolean verifyUser(String uname,String password);
}
