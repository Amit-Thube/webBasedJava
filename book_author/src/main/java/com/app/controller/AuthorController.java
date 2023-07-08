package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Author;
import com.app.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authSer;
	
	@PostMapping
	public ResponseEntity<?> addAuthor(@RequestBody Author newAuthor)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(authSer.addAuthor(newAuthor));
		
	}
	
	@GetMapping
	public List<Author> getAllAuthors()
	{
		return authSer.getAuthors();
	}

	@GetMapping("/{name}")
	public Author getAuthor(@PathVariable String name)
	{
		return authSer.getAuth(name);
	}
	

}
