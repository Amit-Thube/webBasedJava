package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreType
public class Book extends BaseEntity{
	@Column(name = "book_name", length = 20,unique = true)
	private String bookName;
	@Enumerated(EnumType.STRING)
	@Column(name = "book_type", length = 20)
	private BookType bookType;
	private int quantity;
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
	

}
