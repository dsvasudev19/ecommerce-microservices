package com.online_business.category_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name =  "product-service",url = "http://localhost:8082/product/")
public interface ProductClient {
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable int id);

	@GetMapping("/category/{id}")
	public ResponseEntity<?> getProductsOfCategory(@PathVariable int id);

}
