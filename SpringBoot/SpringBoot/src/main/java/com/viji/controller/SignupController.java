package com.viji.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.viji.exception.FactNotfoundException;
import com.viji.model.User;
import com.viji.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SignupController {
	@Autowired
	private UserService signupService;
 
	@PostMapping("/newuser")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		boolean isUsernameExist = signupService.isUserExist(user.getUsername());
		
		if(!isUsernameExist) {
			user = signupService.createUser(user);
			return new ResponseEntity<>("You have successfully created your profile with Username = " + user.getUsername(),
					HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>("Sorry, The username is already added",HttpStatus.CREATED);
		}
	}

	@PutMapping("/updateuser/{username}")
	public ResponseEntity<Object> updateUser(@PathVariable("username") String username, @RequestBody User user) {
		boolean isUserExist = signupService.isUserExist(username);
		if (isUserExist) {
			user.setUsername(username);
			signupService.updateUser(user);
			return new ResponseEntity<>("User has been updated successsfully", HttpStatus.OK);
		} 
		else {
			throw new FactNotfoundException();
		}

	}
	
	@DeleteMapping("/deleteuser/{username}")
	public ResponseEntity<Object> deleteUser(@PathVariable("uid") String username)
	{
		boolean isUserExist = signupService.isUserExist(username);
		if (isUserExist)
		{
			signupService.deleteUser(username);
			return new ResponseEntity<>("Your Account has been deleted successsfully", HttpStatus.OK);
		}
		else
		{
			throw new FactNotfoundException();
		}

	}

}
