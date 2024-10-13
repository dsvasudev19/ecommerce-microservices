package com.online_business.review_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online_business.review_service.models.Review;

@RestController
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;

	@GetMapping
	public ResponseEntity<?> getAllReviews() {
		List<Review> reviews = reviewService.getAllReviews();
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getReviewById(@PathVariable int id) {
		Review review = reviewService.getReviewById(id);
		if (review != null) {
			return new ResponseEntity<>(review, HttpStatus.OK);
		}
		return null;
	}

	@PostMapping("/{productId}")
	public ResponseEntity<?> postNewReviewForProduct(@PathVariable int productId, @RequestBody Review review) {
		return new ResponseEntity<>(reviewService.postNewReview(productId, review), HttpStatus.OK);

	}
    
	@GetMapping("/product/{productId}")
	public ResponseEntity<?> getReviewsOfProduct(@PathVariable int productId) {
		List<Review> reviewsOfProduct = reviewService.getAllReviewsOfProduct(productId);
		return new ResponseEntity<>(reviewsOfProduct, HttpStatus.OK);
	}
    @DeleteMapping("/{reviewId}")
	public ResponseEntity<?> deleteReviewById(@PathVariable int reviewId) {
		boolean deleted = reviewService.deleteReview(reviewId);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
}
