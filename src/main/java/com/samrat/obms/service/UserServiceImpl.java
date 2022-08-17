package com.samrat.obms.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.samrat.obms.model.Role;
import com.samrat.obms.model.User;
import com.samrat.obms.repository.RoleRepository;
import com.samrat.obms.repository.UserRepository;

//This will help to autowire in controllers
@Service
public class UserServiceImpl implements UserService {
	
	final Logger logger=Logger.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	/*
	 * 1. Encode the password 2. Set user as VERIFIED 3. Add Role to the user
	 */
	public void saveUser(User user) {
	user.setPassword(encoder.encode(user.getPassword()));
	user.setStatus("VERIFIED");
	Role userRole= roleRepository.findByRole("SITE_USER");
	user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
	userRepository.save(user);
	}

	@Override
	public boolean isUserAlreadyPresent(User user) {
		//try to implement this method, as assignment.
		return false;
	}

}
