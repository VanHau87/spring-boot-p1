package com.hnguyen387.angularshop.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult()
						.getFieldErrors()
						.stream()
						.map(FieldError::getDefaultMessage)
						.toList();
		return ResponseEntity.badRequest().body(errors);
	}
}
