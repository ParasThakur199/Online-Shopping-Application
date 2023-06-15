package com.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.model.User;
import com.shopping.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUserDetails(User user) {
//		List<User> allUser = userRepository.findAll();
//		for(User u : allUser) {
//			if(u.getEmailId().equals(user.getEmailId())) {
//				throw new RuntimeException("User Already Exist !! Please use different EmailId");
//			}
//		}
			if (userRepository.existsByEmailId(user.getEmailId())) {
		        throw new RuntimeException("User Already Exists! Please use a different EmailId.");
		    }
			return userRepository.save(user);
	}

	
	@Override
	public User getUserById(Integer userId) {
	    return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
	}
	
			
		
}
	
	
