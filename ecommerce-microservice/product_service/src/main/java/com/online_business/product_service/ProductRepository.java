package com.online_business.product_service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online_business.product_service.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	List<Product> findByCategoryId(int id);
	
}
