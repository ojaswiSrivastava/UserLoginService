package com.jkt.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jkt.main.model.LoginDto;
import com.jkt.main.service.UserService;

@RestController
public class LoginController {
	
	@Autowired
	private UserService userService; 
	
	@PostMapping(value = "/login")
	public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
		
		return userService.login(loginDto);
	}

}
