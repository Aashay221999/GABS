package com.psl.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.psl.training.entity.User;
import com.psl.training.service.UserService;

@RestController
public class RegistrationController {

	@Autowired
	UserService serviceU;
	
	@PostMapping("/reg")
	public String insertUser(@RequestBody User user)
	{
		serviceU.insertUser(user);
		return "User Inserted";
	}
}

