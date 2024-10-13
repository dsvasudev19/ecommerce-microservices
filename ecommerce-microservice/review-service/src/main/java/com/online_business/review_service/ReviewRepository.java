package com.online_business.review_service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online_business.review_service.models.Review;



@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	List<Review> findByProductId(int id);

}
