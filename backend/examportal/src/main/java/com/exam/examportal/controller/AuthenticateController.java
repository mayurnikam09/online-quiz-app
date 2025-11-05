package com.exam.examportal.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examportal.config.JwtUtils;
import com.exam.examportal.entity.JwtRequest;
import com.exam.examportal.entity.JwtResponse;
import com.exam.examportal.entity.User;
import com.exam.examportal.service.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	//generate token
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		try
		{
			authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
			
		} catch (UsernameNotFoundException e) 
		{
			e.printStackTrace();
			throw new Exception("User not found");
		}
		
		///authenticate
		
		UserDetails userDetais=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token=this.jwtUtils.generateToken(userDetais);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
	private void authenticate(String username, String password) throws Exception {
	    if (username == null || username.trim().isEmpty()) {
	        throw new Exception("Username cannot be empty");
	    }
	    
	    if (password == null || password.trim().isEmpty()) {
	        throw new Exception("Password cannot be empty");
	    }

	    try {
	        authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(username, password)
	        );
	    } catch (DisabledException e) {
	        throw new Exception("User is disabled: " + e.getMessage());
	    } catch (BadCredentialsException e) {
	        throw new Exception("Invalid username or password");
	    }
	}

	
	//return the details of current user
	
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal)
	{
		return ((User) this.userDetailsService.loadUserByUsername(principal.getName()));
	}
	
}
