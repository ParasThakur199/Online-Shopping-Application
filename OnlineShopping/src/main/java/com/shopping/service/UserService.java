package com.shopping.service;

import com.shopping.model.User;

public interface UserService {
	
	public User saveUserDetails(User user);

	public User getUserById(Integer userId);
	
	
}
