package com.exam.examportal.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userroleid;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	@ManyToOne
	private Role role;

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRole(long userroleid, User user, Role role) {
		super();
		this.userroleid = userroleid;
		this.user = user;
		this.role = role;
	}

	public long getUserroleid() {
		return userroleid;
	}

	public void setUserroleid(long userroleid) {
		this.userroleid = userroleid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [userroleid=" + userroleid + ", user=" + user + ", role=" + role + "]";
	}
	
	
}
