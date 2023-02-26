package com.viji.repository;

import org.springframework.data.repository.CrudRepository;

import com.viji.model.User;

public interface UserRepository extends CrudRepository<User, String>{
	User findByusername(String username);
}
