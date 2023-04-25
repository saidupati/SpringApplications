package com.Ojas.UserManagementSys.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Ojas.UserManagementSys.dao.UserDao;
import com.Ojas.UserManagementSys.model.Constants;
import com.Ojas.UserManagementSys.model.Errorvo;
import com.Ojas.UserManagementSys.model.Role;
import com.Ojas.UserManagementSys.model.User;
import com.Ojas.UserManagementSys.model.UserDto;
import com.Ojas.UserManagementSys.service.RoleService;
import com.Ojas.UserManagementSys.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	logger.info("Inside LoadUserByUsername Method");
        User user = userDao.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
    	logger.info("Inside GetAuthority Method");

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    public List<User> findAll() {
    	logger.info("Inside FindAll Method");
        List<User> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findOne(String username) {
    	logger.info("Inside FindUser By Name Method");
        return userDao.findByUsername(username);
    }

       @Override
    public Errorvo save(UserDto user) {
    	   
       	logger.info("Inside SaveUser Method");

    	   Errorvo errorVo = new Errorvo();
        User nUser = user.getUserFromDto();
        if(nUser != null && nUser.getUsername() != null) {
     	   User userD = findOne(user.getUsername());
     	   if(userD == null) {
        nUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        
        if(user.getBusinessTitle() != null && !user.getBusinessTitle().isEmpty()
        		&& !user.getBusinessTitle().equalsIgnoreCase(Constants.Admin)) {
        Role role = roleService.findByName(user.getBusinessTitle());
        if(role != null) {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        nUser.setRoles(roleSet);
        }
        }
        User userDetails = userDao.save(nUser);
        if(userDetails != null) {
        	errorVo.setStatus(HttpStatus.OK);
        	errorVo.setMessage("User Registered Successfully");
        }
        else {
        	errorVo.setStatus(HttpStatus.BAD_REQUEST);
        	errorVo.setMessage("Failed to register the User.");
        }
     	}else {
     		errorVo.setStatus(HttpStatus.BAD_REQUEST);
        	errorVo.setMessage("User Already Existing.");
     	}
        }else {
        	errorVo.setStatus(HttpStatus.BAD_REQUEST);
        	errorVo.setMessage("Failed to register the User.");
        }
		return errorVo;
    }

	@Override
	public List<User> findAllReportingUsers(long userId) {
    	logger.info("Inside FindAllReportingUsers Method");

		return userDao.findByMngrId(userId);
	}

	@Override
	public List<User> findAllUsers(String role) {
    	logger.info("Inside FindAllUsers Method");

		return userDao.findByBusinessTitle(role);
	}

	@Override
	public List<User> findAllMngrs(String role) {
    	logger.info("Inside FindAllMngrs Method");

		return userDao.findByBusinessTitle(role);
	}
}