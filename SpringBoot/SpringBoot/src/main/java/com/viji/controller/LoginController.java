package com.viji.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viji.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController {
	@Autowired
	private UserService loginService;
	
	@GetMapping("/login")
	public String login(@RequestParam String username,@RequestParam String password){
		boolean isUserExist = loginService.isUserExist(username);
		
		if(isUserExist) {
			return loginService.login(username, password);
		}
		else {
			return "The Username you requested is not found in our server. Please, Double check your Username";
		}
	}
}
