package com.app.service;

import java.util.List;

import com.app.dto.ApiRespDTO;
import com.app.dto.BookReqDTO;
import com.app.entities.Book;

public interface BookService {
	
	ApiRespDTO addBook(BookReqDTO newbook);

	List<Book> getBooks();

}
