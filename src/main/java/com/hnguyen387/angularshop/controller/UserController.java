package com.hnguyen387.angularshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hnguyen387.angularshop.dtos.UserDTO;
import com.hnguyen387.angularshop.groups.OnCreate;
import com.hnguyen387.angularshop.groups.OnLogin;

@RestController
@RequestMapping("${api.prefix.v1}/users")
@Validated
public class UserController {
	
	@PostMapping("register")
	public ResponseEntity<String> createUser(
			@Validated(OnCreate.class)
			@RequestBody UserDTO dto) {
		try {
			return ResponseEntity.ok(String.format("User %s registered successfully.", dto.getPhoneNumber()));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(String.format("Register failed: %s", e.getMessage()));
		}
	}
	@PostMapping("login")
	public ResponseEntity<String> login(
			@Validated(OnLogin.class)
			@RequestBody UserDTO dto) {
		try {
			return ResponseEntity.ok(String.format("User %s login successfully.", dto.getPhoneNumber()));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(String.format("Login failed: %s", e.getMessage()));
		}
	}
}
