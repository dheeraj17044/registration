package com.eldorado.userservice.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eldorado.userservice.config.LoggingConfig;
import com.eldorado.userservice.entities.User;
import com.eldorado.userservice.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class RegistrationController {
	
	@Autowired
	UserRepository userRepo;
	
	Logger log = LoggingConfig.getLog();
	
	// Add a new Head Member
	@PostMapping("/register")
	public User addUser(@RequestBody User user) {
		user.setAccountNonExpired(1);
		user.setCredentialsNonExpired(1);
		user.setAccountNonExpired(1);
		user.setAccountNonExpired(1);
		user.setAccountNonExpired(1);
		user.setAccountNonExpired(1);
		user.setAccountNonExpired(1);
		return userRepo.save(user);
	}
}
