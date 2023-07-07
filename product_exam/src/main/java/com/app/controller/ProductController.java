package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.entities.Category;
import com.app.entities.Product;
import com.app.repository.ProductRepository;
import com.app.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService prodService;
	
	public ProductController() {
	
		System.out.println("in ctor of "+getClass());
	}
	
	@PostMapping
	public ResponseEntity<?> addProductDetail(@RequestBody Product transientProd)
	{
		return new ResponseEntity<>(prodService.addProduct(transientProd),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Product> showProducts()
	{
		return prodService.getAllProducts();
	}
	
	@PutMapping
	public ResponseEntity<?> updateProduct(@RequestBody Product detachedProduct)
	{
		return new ResponseEntity<>( prodService.updateDetails(detachedProduct),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ApiResponse removeProduct(@PathVariable Long id)
	{
		
		return prodService.deleteProd(id);
	}
	
	@GetMapping("/{cath}")
	public List<Product> getByCategory(@PathVariable String cath)
	{
		Category cat=Category.valueOf(cath);
		return prodService.showByCategory(cat);
	}
}
