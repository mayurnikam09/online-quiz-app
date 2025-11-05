package com.exam.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examportal.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByusername(String username);

}
