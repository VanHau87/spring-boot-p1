package com.hnguyen387.angularshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hnguyen387.angularshop.dtos.OnCreate;
import com.hnguyen387.angularshop.dtos.ProductDTO;

import jakarta.validation.Valid;
import jakarta.validation.groups.Default;

@RestController
@RequestMapping("api/v1/products")
@Validated
public class ProductController {
	
	@GetMapping
	public ResponseEntity<String> getListProducts(
			@RequestParam("page") int page,
			@RequestParam("limit") int limit) {
		return ResponseEntity.ok(String.format("List of products with page = %d and limit = %d", page, limit));
	}
	
	@GetMapping("{proId}")
	public ResponseEntity<String> getProductById(@PathVariable int proId) {
		return ResponseEntity.ok(String.format("Product id: %d", proId));
	}
	
	@PostMapping
	@Validated({OnCreate.class, Default.class})
	public ResponseEntity<String> createNewProduct(
			@Valid
			@RequestBody ProductDTO dto) {
		return ResponseEntity.ok(String.format("Product: %s was created successfully.", dto.getName()));
	}
	
	@PutMapping
	public ResponseEntity<String> updateProduct(@RequestBody ProductDTO dto) {
		return ResponseEntity.ok(String.format("Deleted product id: %d", dto.getProId()));
	}
}
