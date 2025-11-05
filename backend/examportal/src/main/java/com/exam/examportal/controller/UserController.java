package com.exam.examportal.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examportal.entity.Role;
import com.exam.examportal.entity.User;
import com.exam.examportal.entity.UserRole;
import com.exam.examportal.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userservice;
	
	//creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception
	{
		user.setProfile("default.png");
		Set<UserRole>roles=new HashSet<>();
		
		Role role=new Role();
		role.setRoleid(45L);
		role.setRolename("Normal");
		
		UserRole userrole=new UserRole();
		userrole.setUser(user);
		userrole.setRole(role);
		
		roles.add(userrole);
		
		return this.userservice.createUser(user, roles);
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username")String username)
	{
		return this.userservice.getUser(username);
	}
	
	//delete user by id
	@DeleteMapping("/{userid}")
	public void deleteUser(@PathVariable("userid")Long userid)
	{
		this.userservice.deleteUser(userid);
	}
	
	//update user
	@PutMapping("/update")
	public User updateUser(@RequestBody User user)
	{
		return this.updateUser(user);
	}
	
	//find user by id
	/*@GetMapping("/{id}")
	public User getUserById(@PathVariable("id")Long id)
	{
		return this.userservice.getUserById(id);
	}*/
}
