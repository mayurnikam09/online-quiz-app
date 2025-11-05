package com.exam.examportal.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examportal.entity.User;
import com.exam.examportal.entity.UserRole;
import com.exam.examportal.repo.RoleRepository;
import com.exam.examportal.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userReository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User local=this.userReository.findByusername(user.getUsername());
		if (local!=null) {
			System.out.println("User Is already there!");
			throw new Exception("User already Present!");
		}
		else {
			//user create
			for(UserRole ur:userRoles)
			{
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			local=this.userReository.save(user);
		}
		return local;
	}

	//getting user by username
	@Override
	public User getUser(String username) {
		return this.userReository.findByusername(username);
	}

	//delete user by id
	@Override
	public void deleteUser(Long userid) {
		this.userReository.deleteById(userid);
	}

	//update user
	@Override
	public User updateUser(User user) {
		return this.userReository.save(user);
	}

	//get data by id
	/*@Override
	public User getUserById(Long id) {
		return this.userReository.findByid(id);
	}*/

}
