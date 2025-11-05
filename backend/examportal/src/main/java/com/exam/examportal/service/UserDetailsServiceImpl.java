package com.exam.examportal.service;

import com.exam.examportal.entity.User;
import com.exam.examportal.repo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository UserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user=this.UserRepository.findByusername(username);
		if(user==null)
		{
			System.out.println("User Not Found");
			throw new UsernameNotFoundException("No user found!!");
		}
		
		return user;
	}
	
}
