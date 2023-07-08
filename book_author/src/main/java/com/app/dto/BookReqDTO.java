package com.app.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.app.entities.Author;
import com.app.entities.BookType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class BookReqDTO {
	
	private String bookName;
	private BookType bookType;
	private int quantity;
	private double price;
	private String firstName;

}
