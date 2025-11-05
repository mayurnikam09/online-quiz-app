package com.exam.examportal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.examportal.entity.Role;
import com.exam.examportal.entity.User;
import com.exam.examportal.entity.UserRole;
import com.exam.examportal.service.UserService;

@SpringBootApplication
public class ExamportalApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamportalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code");
		
		/*User user=new User();
		user.setFirstname("Jayesh");
		user.setLastname("Patil");
		user.setUsername("JPatil");
		user.setPassword("patil@12");
		user.setEmail("jayeshpatil@gmail.com");
		user.setProfile("default.png");
		
		Role role=new Role();
		role.setRoleid(11L);
		role.setRolename("ADMIN");
		
		Set<UserRole> userRoleset=new HashSet<>();
		UserRole userRole=new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoleset.add(userRole);
		
		User user1=this.userService.createUser(user, userRoleset);
		System.out.println(user1.getUsername());*/
	}
}
