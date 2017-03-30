package com.noteservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noteservice.pojo.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);

}
