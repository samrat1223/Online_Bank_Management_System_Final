package com.samrat.obms.service;

import com.samrat.obms.model.User;

//User interface for methods
public interface UserService {
	
	//Method to save a user
	public void saveUser(User user);
	
	//Method to find if a user is present or not
	public boolean isUserAlreadyPresent(User user);

}
