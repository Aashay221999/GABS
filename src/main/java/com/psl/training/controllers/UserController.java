package com.psl.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.psl.training.entity.User;
import com.psl.training.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService serviceU;
	
	
	@GetMapping("/user/{userID}")
	public User getUserDetails(@PathVariable("userID") long userID)
	{
		return serviceU.findByUserID(userID);
	}
	
	@PutMapping("/user/{userID}")
	public String updateUser(@RequestBody User user)
	{
		serviceU.updateUser(user);
		return "User Updated Succesfully";
	}
}
