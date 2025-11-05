package com.exam.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examportal.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
