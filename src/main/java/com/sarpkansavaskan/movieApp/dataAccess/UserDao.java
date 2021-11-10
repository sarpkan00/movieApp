package com.sarpkansavaskan.movieApp.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarpkansavaskan.movieApp.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);
}
