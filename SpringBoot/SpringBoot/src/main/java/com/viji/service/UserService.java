package com.viji.service;

import com.viji.model.User;

public interface UserService {
	public abstract User createUser(User user);
	
	public abstract User updateUser(User user);
	
	public abstract void deleteUser(String username);
	
	public abstract boolean isUserExist(String username);
	
	public abstract String login(String Username,String password);
}
