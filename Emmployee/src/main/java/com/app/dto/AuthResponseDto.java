package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseDto {
	
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate joindate;
	private double salary;
	private String department;

}
