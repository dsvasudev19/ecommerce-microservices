package com.online_business.product_service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.online_business.product_service.models.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	private static final String UPLOAD_DIR = "uploads/";

	@GetMapping
	public ResponseEntity<?> getAllProduct() {
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable int id) {
		Product product = productService.getProductById(id);
		if (product == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(product);
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<?> getProductsOfCategory(@PathVariable int id){
		List<Product> productsFound=productService.getAllProductsByCategoryId(id);
		return new ResponseEntity<>(productsFound,HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<?> addNewProduct(@RequestParam("name") String name, @RequestParam("price") int price, @RequestParam("categoryId") int categoryId,
			@RequestParam("file") MultipartFile file) {
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		String currentDir = System.getProperty("user.dir");
		if (file != null && !file.isEmpty()) {
			try {
				File uploadDirectory = new File(UPLOAD_DIR);
				if (!uploadDirectory.exists()) {
					uploadDirectory.mkdirs();
				}
				String fileName =UPLOAD_DIR+System.currentTimeMillis() + "-" + file.getOriginalFilename();

                String filePath = Paths.get(currentDir, fileName).toString();
				file.transferTo(new File(filePath));
				product.setPath(filePath);

			} catch (IOException e) {
				e.printStackTrace();
				return ResponseEntity.badRequest().body("File upload failed: " + e.getMessage());
			}
		} else {
			return ResponseEntity.badRequest().body("No file uploaded");
		}

		Product newProduct = productService.addProduct(product);

		if (newProduct == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(product);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateProductById(@PathVariable int id, @RequestBody Product product) {
		Product updatedProduct = productService.updateProductById(id, product);
		if (updatedProduct == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(product);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable int id) {
		boolean deleted = productService.deleteProductById(id);
		if (deleted) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
	}
}
