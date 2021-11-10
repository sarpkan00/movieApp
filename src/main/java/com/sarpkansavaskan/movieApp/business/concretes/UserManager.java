package com.sarpkansavaskan.movieApp.business.concretes;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sarpkansavaskan.movieApp.business.abstracts.UserService;
import com.sarpkansavaskan.movieApp.dataAccess.UserDao;
import com.sarpkansavaskan.movieApp.entities.Role;
import com.sarpkansavaskan.movieApp.entities.User;
import com.sarpkansavaskan.movieApp.entities.dtos.UserDto;

@Service
public class UserManager implements UserService {

	private final UserDao userDao;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserManager(UserDao userDao,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDao = userDao;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Kullanıcı adı ve ya parola hatalı!!");
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthorities(user.getRoles()));
	}

	@Override // gereksiz
	public User FindByUserName(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User save(UserDto userDto) {
		User user = new User();
		user.setFullName(userDto.getFullName());
		user.setUsername(userDto.getUsername());
		user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		user.setRoles(Arrays.asList(new Role("ROLE_USER")));

		return userDao.save(user);
	}
	
	//Control
	private Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
