package com.online_business.category_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online_business.category_service.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
