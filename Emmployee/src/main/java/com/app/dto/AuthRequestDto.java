package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class AuthRequestDto {
	@NotBlank(message="Email can't be blank")
	@Email(message = "Inavalid email id")
	private String email;
	@NotBlank(message = "password can not be blank")
	private String password;

}
