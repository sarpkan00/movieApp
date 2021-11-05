package com.sarpkansavaskan.movieApp.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarpkansavaskan.movieApp.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);
}
