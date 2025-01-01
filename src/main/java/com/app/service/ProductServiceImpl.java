package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Product;
import com.app.repository.ProductCustomRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductCustomRepository productCustomRepository;
	
	@Override
	public List<Product> getAllProducts() {
		try {
			List<Product> productList = productCustomRepository.getAllProducts();
			
			return productList;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void saveProduct(Product product) {
		try {
			productCustomRepository.saveProduct(product);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Integer updateProduct(Product product) {
		try {
			Integer count = productCustomRepository.updateProduct(product);
			
			return count;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public Integer deleteProduct(Integer productId) {
		try {
			Integer count = productCustomRepository.deleteProduct(productId);
			
			return count;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Integer deleteAllProducts() {
		try {
			Integer count = productCustomRepository.deleteAllProducts();
			
			return count;
		} catch (Exception e) {
			throw e;
		}
	}

}
