package com.viji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viji.model.User;
import com.viji.repository.UserRepository;
import com.viji.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public void deleteUser(String username) {
		userRepository.deleteById(username);
	}
	
	@Override
	public boolean isUserExist(String username)
	{
		return userRepository.existsById(username);
	}
	
	@Override
	public String login(String username,String password) {
		User user = userRepository.findByusername(username);
		String PW = user.getPassword();
		if(PW.equals(password)) {
			return user.toString();
		}
		else {
			return "Sorry, the password You entered '"+password+"' is wrong. Please Enter the correct password";
		}
	}
}
