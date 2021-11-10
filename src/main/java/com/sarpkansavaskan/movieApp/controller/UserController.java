package com.sarpkansavaskan.movieApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sarpkansavaskan.movieApp.business.abstracts.UserService;
import com.sarpkansavaskan.movieApp.business.concretes.UserManager;
import com.sarpkansavaskan.movieApp.entities.Actor;
import com.sarpkansavaskan.movieApp.entities.User;
import com.sarpkansavaskan.movieApp.entities.dtos.UserDto;

@Controller
public class UserController {

	private final UserManager userManager;

	@Autowired
	public UserController(UserManager userManager) {
		super();
		this.userManager = userManager;
	}

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String loginCheck(BindingResult bindingResult) {
		return "user/login";
	}
	
	@PostMapping("/save")
	 public String save(UserDto userDto) {
		userManager.save(userDto);
	        return "redirect:/login";
	    }
	 
		@GetMapping("/register")
		public String addUser(Model model) {
			model.addAttribute("User", new UserDto());
			return "user/register";
		}
	
	@PostMapping("/register")
	public String loginUserAccount(@ModelAttribute("user") @Valid UserDto userDto,
									BindingResult bindingResult,Model model) {
		User user1 = userManager.FindByUserName(userDto.getUsername());
		
		if(user1 != null) {
			bindingResult.reject("username", null, "Bu kullanıcı adı mevcut!!" );
		}
		
		if(bindingResult.hasErrors()) {
			return "user/login";
		}
		
		userManager.save(userDto);
		
		return "redirect:/login?success";
		
	}
	
	@ModelAttribute("user")
	public UserDto userDto() {
		return new UserDto();
	}

}
