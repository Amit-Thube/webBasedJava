package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custome_exception.ResourceNotFoundException;
import com.app.dto.ApiRespDTO;
import com.app.dto.BookReqDTO;
import com.app.entities.Author;
import com.app.entities.Book;
import com.app.repository.AuthorRepository;
import com.app.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private AuthorRepository authRepo;

	@Override
	public ApiRespDTO addBook(BookReqDTO newbook) {
		
		System.out.println(newbook.getFirstName());
		Author author = authRepo.findByFirstName(newbook.getFirstName()).orElseThrow(()->new ResourceNotFoundException("Invalid Author Name!!!"));
		System.out.println(author);
		Book book = new Book(newbook.getBookName(),newbook.getBookType(), newbook.getQuantity(), newbook.getPrice(), author);
		Book addbook = bookRepo.save(book);
		
		String msg = "Book is not added!!";
		if(addbook!=null)
			msg = "Book added Successfully!!";
		return new ApiRespDTO(msg);
	}

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}

}
