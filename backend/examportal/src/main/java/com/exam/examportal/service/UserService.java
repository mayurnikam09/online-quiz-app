package com.exam.examportal.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.examportal.entity.User;
import com.exam.examportal.entity.UserRole;

@Service
public interface UserService {

	//creating user
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
	//get user by username
	public User getUser(String username);
	
	//delete user by id
	public void deleteUser(Long userid);
	
	//update user
	public User updateUser(User user);
	
	//find user by id
	//public User getUserById(Long id);
}
