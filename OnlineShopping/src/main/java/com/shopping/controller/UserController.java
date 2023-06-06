package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.User;
import com.shopping.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/data")
	public ResponseEntity<String> getdata(){
		return ResponseEntity.ok("Testing purpose");
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> saveUserHandler(@RequestBody User user){
		User res = userService.saveUserDetails(user);
		return new ResponseEntity<>(res,HttpStatus.CREATED);
	}
}
