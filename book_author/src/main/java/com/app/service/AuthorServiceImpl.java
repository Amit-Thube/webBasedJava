package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custome_exception.ResourceNotFoundException;
import com.app.dto.ApiRespDTO;
import com.app.entities.Author;
import com.app.repository.AuthorRepository;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	private AuthorRepository authRepo;
	

	@Override
	public ApiRespDTO addAuthor(Author author) {
		String msg = "Author not added !!!!!";
		Author author1 = authRepo.save(author);
		if(author1!=null)
			msg = "Author added successfully!!";
		
		return new ApiRespDTO(msg);
	}


	@Override
	public List<Author> getAuthors() {
		// TODO Auto-generated method stub
		return authRepo.findAll();
	}


	@Override
	public Author getAuth(String name) {
		// TODO Auto-generated method stub
		return authRepo.findByFirstName(name).orElseThrow(()->new ResourceNotFoundException("Author Not found"));
	}

}
