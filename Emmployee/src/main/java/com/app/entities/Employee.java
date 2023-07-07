package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="emp")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password")
public class Employee extends BaseEntity {

	@Column(name="first_name",length=20)
	private String firstName;
	@Column(name="last_name",length=20)
	private String lastName;
	@Column(length=30,unique = true)
	private String email;
	@Column(length=30,nullable = false)
	private String password;
	private LocalDate joindate;
	private double salary;
	@Column(name="dept",length=20)
	private String department;
}
