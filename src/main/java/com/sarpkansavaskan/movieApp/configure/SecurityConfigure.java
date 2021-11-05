package com.sarpkansavaskan.movieApp.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sarpkansavaskan.movieApp.business.abstracts.UserService;


@Configuration
@EnableWebSecurity
public class SecurityConfigure extends WebSecurityConfigurerAdapter {
	

	private final UserService userService;
	
	private final BCryptPasswordEncoder encoder;
	
	
	public SecurityConfigure(UserService userService,BCryptPasswordEncoder encoder) {
		super();
		this.userService = userService;
		this.encoder = encoder;
		
	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login.html");
			

	}

//	@Override
//	protected void configure(final HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.antMatchers(
//						"/", 
//						"/login", 
//						"/register", 
//						"/js/**", 
//						"/css/**", 
//						"/img/**", 
//						"/webjars/**").permitAll()
//				.antMatchers("/movies/delete/**, /movies/update/**")
//				.hasAuthority("ROLE_ADMIN")
//				.anyRequest().authenticated().and()
//				.formLogin().loginPage("/login")
//				.defaultSuccessUrl("/movies").permitAll().
//				and()
//				.logout().permitAll()
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//				.logoutSuccessUrl("/login?logout").and()
//				.exceptionHandling();
//
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	


	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(encoder);
		return auth;
	}

}
