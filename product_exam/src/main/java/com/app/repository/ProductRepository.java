package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Product;
import com.app.entities.Category;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByCategory(Category category);

	
}
