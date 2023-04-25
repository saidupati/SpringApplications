package com.Ojas.UserManagementSys.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Ojas.UserManagementSys.config.TokenProvider;
import com.Ojas.UserManagementSys.model.AuthToken;
import com.Ojas.UserManagementSys.model.Constants;
import com.Ojas.UserManagementSys.model.Errorvo;
import com.Ojas.UserManagementSys.model.LoginUser;
import com.Ojas.UserManagementSys.model.User;
import com.Ojas.UserManagementSys.model.UserDto;
import com.Ojas.UserManagementSys.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
	
	protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {
    	
    	logger.info("Inside the Login Method:");
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        logger.info("Token Generation completed. \n Token --> "+token);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public Errorvo saveUser(@RequestBody UserDto user){
    	logger.info("Inside the Register Method:");
        return userService.save(user);
    }

    @PreAuthorize("hasRole('"+Constants.User+"')")
    @RequestMapping(value="/getUser", method = RequestMethod.GET)
    public User getUserById(){
    	logger.info("Inside the GetUser Method:");
    	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
    	String username = userDetails.getUsername();
    	logger.info("User:"+username);
    	return userService.findOne(username);        
    }
    
    @PreAuthorize("hasRole('"+Constants.Admin+"')")
    @RequestMapping(value="/getALLUser", method = RequestMethod.GET)
    public List<User> getAllUsers(){
    	logger.info("Inside the GetAllUsers Method:");
    	return userService.findAllUsers(Constants.User);        
    }
    
    @PreAuthorize("hasRole('"+Constants.Admin+"')")
    @RequestMapping(value="/getALLMngr", method = RequestMethod.GET)
    public List<User> getAllMngrs(){
    	logger.info("Inside the GetAllManagers Method:");
    	return userService.findAllMngrs(Constants.Manager);        
    }
    
    @PreAuthorize("hasRole('"+Constants.Manager+"')")
    @RequestMapping(value="/getALLReportingUser", method = RequestMethod.GET)
    public List<User> getAllReportingUsers(){
    	logger.info("Inside the GetAllReportingUsers Method:");
    	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
    	User user = userService.findOne(userDetails.getUsername());
    	logger.info("User:"+user.getUsername());
    	return userService.findAllReportingUsers(user.getId());
    	
    }

}
