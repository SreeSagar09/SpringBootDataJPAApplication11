package com.app.service;

import java.util.List;

import com.app.model.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();
	
	public void saveProduct(Product product);
	
	public Integer updateProduct(Product product);
	
	public Integer deleteProduct(Integer productId);
	
	public Integer deleteAllProducts();
}
