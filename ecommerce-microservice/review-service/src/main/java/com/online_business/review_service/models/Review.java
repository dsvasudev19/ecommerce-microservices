package com.online_business.review_service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int productId;
	private int rating;
	private String content;
	public Review() {
		
	}
	public Review(int id, int productId, int rating, String content) {
		this.id = id;
		this.productId = productId;
		this.rating = rating;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", productId=" + productId + ", rating=" + rating + ", content=" + content + "]";
	}
	
	

}
