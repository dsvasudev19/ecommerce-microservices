package com.online_business.category_service.models;

import java.time.LocalDateTime;



public class ProductDto {
	
	private int id;

	private int categoryId;

	private String name;

	private String slug;

	private int price;

	private String path;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
	
	

	public ProductDto() {
		super();
	}



	public ProductDto(int id, int categoryId, String name, String slug, int price, String path, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.slug = slug;
		this.price = price;
		this.path = path;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSlug() {
		return slug;
	}



	public void setSlug(String slug) {
		this.slug = slug;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public LocalDateTime getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}



	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}



	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", slug=" + slug + ", price="
				+ price + ", path=" + path + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	

}
