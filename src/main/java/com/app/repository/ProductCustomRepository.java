package com.app.repository;

import java.util.List;

import com.app.model.Product;

public interface ProductCustomRepository {
	
	public List<Product> getAllProducts();
	
	public void saveProduct(Product product);
	
	public Integer updateProduct(Product product);
	
	public Integer deleteProduct(Integer productId);
	
	public Integer deleteAllProducts();
}
