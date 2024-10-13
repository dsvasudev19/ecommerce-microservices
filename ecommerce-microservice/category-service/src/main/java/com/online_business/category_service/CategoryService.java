package com.online_business.category_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_business.category_service.models.Category;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepo;
	
	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}
	
	public Category getCategoryById(int id) {
		return categoryRepo.findById(id).get();
	}
	
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}

	public Category updateCategory(int id, Category category) {
		Category oldCategory=categoryRepo.findById(id).get();
		if(oldCategory!=null) {
			oldCategory.setName(category.getName());
			categoryRepo.save(category);
			return category;
		}
		return null;
	}
	public boolean deleteCategory(int id) {
		categoryRepo.deleteById(id);
		return true;
	}
}
