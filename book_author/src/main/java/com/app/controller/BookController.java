package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookReqDTO;
import com.app.entities.Book;
import com.app.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookSer;
	

	@PostMapping
	public ResponseEntity<?> addBook(@RequestBody BookReqDTO newBook)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(bookSer.addBook(newBook));
	}
	
	@GetMapping
	public List<Book> getAllBooks()
	{
		return bookSer.getBooks();
	}
}
