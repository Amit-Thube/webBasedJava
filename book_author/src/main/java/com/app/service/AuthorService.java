package com.app.service;

import java.util.List;

import com.app.dto.ApiRespDTO;
import com.app.entities.Author;

public interface AuthorService {
	
	ApiRespDTO addAuthor(Author author);

	List<Author> getAuthors();

	Author getAuth(String name);

}
