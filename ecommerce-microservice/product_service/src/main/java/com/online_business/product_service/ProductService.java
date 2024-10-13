package com.online_business.product_service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_business.product_service.models.Product;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	public Product getProductById(int id) {
		Optional<Product> product = productRepo.findById(id);
		if (product.isPresent()) {
			return product.get();
		} else {
			return null;
		}
	}

	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

	public Product updateProductById(int id, Product updatedProduct) {
		Product product = productRepo.findById(id).get();
		if (product != null) {
			updatedProduct.setId(id);
			productRepo.save(updatedProduct);
			return updatedProduct;
		}
		return null;
	}

	public List<Product> getAllProductsByCategoryId(int id){
		List<Product> productsOfCategory=productRepo.findByCategoryId(id);
		
		return productsOfCategory;
	}

	public boolean deleteProductById(int id) {
		productRepo.deleteById(id);
		return true;

	}

}
