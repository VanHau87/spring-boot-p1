package com.hnguyen387.angularshop.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hnguyen387.angularshop.dtos.OnCreate;
import com.hnguyen387.angularshop.dtos.ProductDTO;

import jakarta.validation.Valid;
import jakarta.validation.groups.Default;

@RestController
@RequestMapping("api/v1/products")
@Validated
public class ProductController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	private final long MAX_SIZE = 10 * 1024 * 1024L; //10MB
	
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
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> createNewProduct(
			@Validated({OnCreate.class, Default.class})
			@ModelAttribute ProductDTO dto) {
		MultipartFile file = dto.getFile();
		if (file != null) {
			if (file.getSize() > MAX_SIZE ) {
			return ResponseEntity
					.status(HttpStatus.PAYLOAD_TOO_LARGE)
					.body(String.format("Maximum size is: %d", MAX_SIZE));
			}
			String type = file.getContentType();
			if (type == null || !type.startsWith("image/")) {
				return ResponseEntity
						.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
						.body("File must be an image");
			}
		}
		//store file and update thumbnail in DTO
		try {
			storeFile(file);
		} catch (IOException e) {
			LOGGER.error(String.format("Failed to upload image: %s", e.getMessage()));
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(String.format("Failed to upload image: %s", e.getMessage()));
		}
		return ResponseEntity.ok(String.format("Product: %s was created successfully.", dto.getName()));
	}
	
	@PutMapping
	public ResponseEntity<String> updateProduct(@RequestBody ProductDTO dto) {
		return ResponseEntity.ok(String.format("Deleted product id: %d", dto.getProId()));
	}
	
	private String storeFile(MultipartFile file) throws IOException {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		String uniqueName = String.join("_", UUID.randomUUID().toString(), filename);
		Path uploadDir = Paths.get("upload");
		if (!Files.exists(uploadDir)) {
			Files.createDirectories(uploadDir);
		}
		Path destination = Paths.get(uploadDir.toString(), uniqueName);
		Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
		return uniqueName;
	}
}
