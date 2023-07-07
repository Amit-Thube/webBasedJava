package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.entities.Category;
import com.app.entities.Product;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository prodrepo;
	
	@Override
	public ApiResponse addProduct(Product transientProd) {
		String msg="Product not added!";
		Product newProd= prodrepo.save(transientProd);
		System.out.println(newProd);
		if(newProd != null)
		{
			msg="Product added Successfully";
		}
		return new ApiResponse(msg);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return prodrepo.findAll();
	}

	@Override
	public ApiResponse updateDetails(Product detachedProduct) {
		String msg=" Failed to Update ";
		
		Product newProd=prodrepo.save(detachedProduct);
		if(newProd != null)
		{
			msg="updated Successfully!";
		}
		return new ApiResponse(msg);
	}

	@Override
	public ApiResponse deleteProd(Long id) {

		String msg="product not found!";
		if(	prodrepo.existsById(id))
		{
			prodrepo.deleteById(id);
			msg="deleted successfully!";
		}
		
		return new ApiResponse(msg);
	}

	@Override
	public List<Product> showByCategory(Category cat) {
		// TODO Auto-generated method stub
		return prodrepo.findByCategory(cat);
	}

	

	/*
	 * 	@Override
	public List<Product> showByCategory(String cat) {
		
		return prodrepo.findByCategory(cat);
	}


		*/

}
