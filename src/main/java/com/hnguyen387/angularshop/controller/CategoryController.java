package com.hnguyen387.angularshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hnguyen387.angularshop.dtos.CategoryDTO;
import com.hnguyen387.angularshop.dtos.OnCreate;
import com.hnguyen387.angularshop.dtos.OnDelete;
import com.hnguyen387.angularshop.dtos.OnUpdate;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/categories")
@Validated
public class CategoryController {
	
	@GetMapping
	public ResponseEntity<String> getListCategories(
				@RequestParam("page") int page,
				@RequestParam("limit") int limit
			) {
		return ResponseEntity.ok(String.format("Category page = %d, limit = %d ", page, limit));
	}
	@GetMapping("{catId}")
	public ResponseEntity<String> getCat(@PathVariable Long catId) {
		return ResponseEntity.ok("Query category id: " + catId);
	}
	@PostMapping
	public ResponseEntity<?> createNewCat(
			@Validated(OnCreate.class)
			@RequestBody CategoryDTO dto) {
		return ResponseEntity.ok(String.format("create new category name: %s", dto.getCatName()));
	}
	@PutMapping
	public ResponseEntity<?> updateCat(
			@Validated({OnUpdate.class, OnCreate.class})
			@RequestBody CategoryDTO dto) {
		return ResponseEntity.ok(String.format("Updated category id: %d", dto.getCatId()));
	}
	@DeleteMapping
	@Validated(OnDelete.class)
	public ResponseEntity<String> deleteCat(@Valid @RequestBody CategoryDTO dto) {
		return ResponseEntity.ok(String.format("Deleted category id: %d", dto.getCatId()));
	}
	
}
