package com.Ojas.UserManagementSys.service;

import java.util.List;

import com.Ojas.UserManagementSys.model.Errorvo;
import com.Ojas.UserManagementSys.model.User;
import com.Ojas.UserManagementSys.model.UserDto;

public interface UserService {
	Errorvo save(UserDto user);
    List<User> findAll();
    User findOne(String username);
    List<User> findAllReportingUsers(long userId);
    List<User> findAllUsers(String role);
    List<User> findAllMngrs(String role);
}
