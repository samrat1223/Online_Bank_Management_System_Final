package com.samrat.obms.service;

import com.samrat.obms.model.User;

public interface UserService {
	public void saveUser(User user);
	public boolean isUserAlreadyPresent(User user);

}
