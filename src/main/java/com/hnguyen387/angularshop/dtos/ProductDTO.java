package com.hnguyen387.angularshop.dtos;

import java.util.List;

import org.hibernate.sql.Update;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hnguyen387.angularshop.groups.OnCreate;
import com.hnguyen387.angularshop.groups.OnUpdate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductDTO {
	@JsonProperty("id")
	@NotNull(message = "Id must be entered", groups = Update.class)
	private Integer proId;
	@NotBlank(message = "Name must be entered", groups = {OnCreate.class, OnUpdate.class})
	@Size(min = 3, max = 255, 
		message = "Name must be in length of 3-255",
		groups = {OnCreate.class, OnUpdate.class})
	private String name;
	@Min(value = 0, message = "Value must be greater than 0")
	private Float price;
	private String thumbnail;
	private String description;
	@JsonProperty("category_id")
	@NotNull(message = "Category Id must required")
	private Integer catId;
	private List<MultipartFile> files;
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getCatId() {
		return catId;
	}
	public void setCatId(Integer catId) {
		this.catId = catId;
	}
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	
	
}
