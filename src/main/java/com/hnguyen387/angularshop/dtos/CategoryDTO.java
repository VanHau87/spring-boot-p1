package com.hnguyen387.angularshop.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CategoryDTO {
	@NotNull(message = "Category ID is required", groups = {OnUpdate.class, OnDelete.class})
	private Integer catId;
	@NotBlank(message = "Category name is required", groups = {OnUpdate.class, OnCreate.class})
	private String catName;
	
	public CategoryDTO() {}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	
}
