package com.sarpkansavaskan.movieApp.entities.dtos;


import javax.validation.constraints.NotEmpty;

import com.sarpkansavaskan.movieApp.utils.validator.FieldMatchUp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@FieldMatchUp(first = "password", second = "confirmPassword", message = "Alanlar Eşleşmelidir!!")
public class UserDto {
	
	@NotEmpty
	private String fullName;
    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    
}
