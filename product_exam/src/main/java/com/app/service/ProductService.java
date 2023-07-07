package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.dto.ApiResponse;
import com.app.entities.Category;
import com.app.entities.Product;

public interface ProductService {

	List<Product> getAllProducts();

	//add
	ApiResponse addProduct(Product transientProd);

	//update
	ApiResponse updateDetails(Product detachedProduct);

	ApiResponse deleteProd(Long id);


	List<Product> showByCategory(Category cat);
}
