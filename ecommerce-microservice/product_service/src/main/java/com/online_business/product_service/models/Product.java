package com.online_business.product_service.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data


@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int categoryId;

	private String name;

	private String slug;

	private int price;

	private String path;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", slug=" + slug + ", price=" + price + ", path=" + path
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	@PrePersist
	public void updateSlugAndTime() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
		this.slug = this.name.toLowerCase().replaceAll(" ", "-");
	}

	@PreUpdate
	public void updateDateAndTime() {
		this.updatedAt = LocalDateTime.now();
	}

}
