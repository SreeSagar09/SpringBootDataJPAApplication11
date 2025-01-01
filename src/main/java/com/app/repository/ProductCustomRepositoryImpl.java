package com.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Product;

@Repository
public class ProductCustomRepositoryImpl implements ProductCustomRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Product> getAllProducts() {
		try {
			String queryString = "from Product p";
			
			Query query = entityManager.createQuery(queryString);
			List<Product> productList = query.getResultList();
			
			return productList;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Transactional
	@Override
	public void saveProduct(Product product) {
		try {
			entityManager.persist(product);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Transactional
	@Override
	public Integer updateProduct(Product product) {
		try {
			String queryString = "update Product p set p.productCode =?0, p.productName =?1, p.quantity =?2, p.price =?3 where p.productId =?4";
			
			Query query = entityManager.createQuery(queryString);
			query.setParameter(0, product.getProductCode());
			query.setParameter(1, product.getProductName());
			query.setParameter(2, product.getQuantity());
			query.setParameter(3, product.getPrice());
			query.setParameter(4, product.getProductId());
			
			int count = query.executeUpdate();
			
			return count;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Transactional
	@Override
	public Integer deleteProduct(Integer productId) {
		try {
			String queryString = "delete from Product p where p.productId =?0";
			
			Query query = entityManager.createQuery(queryString);
			query.setParameter(0, productId);
			
			int count = query.executeUpdate();
			
			return count;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Transactional
	@Override
	public Integer deleteAllProducts() {
		try {
			String queryString = "delete from Product p";
			
			Query query = entityManager.createQuery(queryString);
			
			int count = query.executeUpdate();
			
			return count;
		} catch (Exception e) {
			throw e;
		}
	}

}
