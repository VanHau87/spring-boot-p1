package com.hnguyen387.angularshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hnguyen387.angularshop.dtos.OrderDTO;
import com.hnguyen387.angularshop.groups.OnDelete;
import com.hnguyen387.angularshop.groups.OnUpdate;

import jakarta.validation.Valid;
import jakarta.validation.groups.Default;

@RestController
@RequestMapping("${api.prefix.v1}/orders")
@Validated
public class OrderController {
	
	@PostMapping
	public ResponseEntity<String> createOrder(@Valid @RequestBody OrderDTO dto) {
		try {
			return ResponseEntity.ok(String.format("Order of phone number %s was created.", dto.getPhoneNumber()));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(String.format("Error when create order: %s", e.getMessage()));
		}
	}
	@PutMapping
	public ResponseEntity<String> updateOrder(
			@Validated({OnUpdate.class, Default.class})
			@RequestBody OrderDTO dto) {
		try {
			return ResponseEntity.ok(String.format("Order %s was updated.", dto.getPhoneNumber()));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(String.format("Order updated failed. %s", e.getMessage()));
		}
	}
	@DeleteMapping
	public ResponseEntity<String> deleteOrder(
			@Validated(OnDelete.class)
			@RequestBody OrderDTO dto) {
		return ResponseEntity.ok(String.format("Delete order %d successfully", dto.getId()));
	}
}
