package com.hnguyen387.angularshop.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class OrderDetailDTO {
	private Long id;
	@JsonProperty("order_id")
	@NotNull(message = "Order id is required")
	private Integer orderId;
	@JsonProperty("product_id")
	private Integer productId;
	private Float price;
	@JsonProperty("number_of_products")
	@Min(value = 1, message = "Number of products must be greater than 0")
	private int numberOfProducts;
	@JsonProperty("total_money")
	private Float totalMoney;
	private String color;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public int getNumberOfProducts() {
		return numberOfProducts;
	}
	public void setNumberOfProducts(int numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}
	public Float getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Float totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
