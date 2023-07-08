package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "authors")
@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreType
@ToString
public class Author extends BaseEntity{
	
	@Column(name = "first_name", length = 20)
	private String firstName;
	@Column(name = "last_name", length = 20)
	private String lastName;
	@Column(length = 20,unique = true)
	private String email;
	@Column(length = 20,nullable = false)
	private String password;
	@Column(length = 40)
	private String address;
	private int age;
	
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Book> bookList = new ArrayList<Book>();

	public Author(String firstName, String lastName, String email, String address, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.age = age;
	}
	
	

}
