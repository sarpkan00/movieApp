package com.sarpkansavaskan.movieApp.business.abstracts;



import org.springframework.security.core.userdetails.UserDetailsService;


import com.sarpkansavaskan.movieApp.entities.User;
import com.sarpkansavaskan.movieApp.entities.dtos.UserDto;

public interface UserService extends UserDetailsService {
	
	User FindByUserName(String username);
	User save(UserDto userDto);

}
