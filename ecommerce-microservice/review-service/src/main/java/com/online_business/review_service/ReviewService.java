package com.online_business.review_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_business.review_service.models.Review;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepo;

	public List<Review> getAllReviews() {
		return reviewRepo.findAll();
	}

	public Review getReviewById(int id) {
		Review review = reviewRepo.findById(id).get();
		return review;
	}

	public Review postNewReview(int productId, Review review) {
		review.setProductId(productId);
		return reviewRepo.save(review);
	}

	public boolean deleteReview(int id) {
		reviewRepo.deleteById(id);
		return true;
	}

	public List<Review> getAllReviewsOfProduct(int productId) {
		List<Review> reviews = reviewRepo.findByProductId(productId);
		return reviews;
	}
}
