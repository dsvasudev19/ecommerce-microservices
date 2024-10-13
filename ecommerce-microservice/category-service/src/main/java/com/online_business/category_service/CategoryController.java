package com.online_business.category_service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
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

import com.online_business.category_service.feign.ProductClient;
import com.online_business.category_service.models.Category;
import com.online_business.category_service.models.CategoryDto;
import com.online_business.category_service.models.ProductDto;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductClient productClient;

	@GetMapping
	public ResponseEntity<?> getAllCategories() {
		final List<Category> categories = categoryService.getAllCategories();
		return new ResponseEntity<>(categories, HttpStatus.valueOf(200));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable final int id) {
		final Category category = categoryService.getCategoryById(id);
		if (category != null) {
			final List<Integer> productIds = category.getProducts();
			final List<ProductDto> allProducts = new ArrayList<>();
			productIds.stream().forEach((productId) -> {
				final ProductDto productFound = new ProductDto();
				BeanUtils.copyProperties(productClient.getProductById(productId), productFound);
				allProducts.add(productFound);
			});
			final CategoryDto cat = new CategoryDto();
			BeanUtils.copyProperties(category, cat);
			cat.setProducts(allProducts);
			System.out.println(cat);

			return ResponseEntity.ok().body(cat);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> createCategory(@RequestBody final Category category) {
		final Category newCategory = categoryService.createCategory(category);
		if (newCategory != null) {
			return ResponseEntity.ok().body(category);
		}
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable final int id, @RequestBody final Category category) {
		final Category updatedCategory = categoryService.updateCategory(id, category);
		if (updatedCategory != null) {
			return ResponseEntity.ok().body(category);
		}
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable final int id) {
		final boolean deleted = categoryService.deleteCategory(id);
		if (deleted) {
			return ResponseEntity.ok().body(deleted);
		}
		return ResponseEntity.badRequest().build();
	}
}
