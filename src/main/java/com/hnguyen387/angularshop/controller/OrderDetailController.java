package com.hnguyen387.angularshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hnguyen387.angularshop.dtos.OrderDetailDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("${api.prefix.v1}/order_details")
public class OrderDetailController {
	
	@PostMapping
	public ResponseEntity<String> createOrderDetail(@Valid @RequestBody OrderDetailDTO dto) {
		try {
			return ResponseEntity.ok(String.format("Create order details with total money %d.", dto.getTotalMoney()));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Create order detail failed");
		}
	}
}
