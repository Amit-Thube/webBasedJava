package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Author;
import java.lang.String;
import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	
	Optional<Author> findByFirstName(String firstname);

}
