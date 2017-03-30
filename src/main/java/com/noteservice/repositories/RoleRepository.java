package com.noteservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noteservice.pojo.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
//	Role findByRole(String role);
}