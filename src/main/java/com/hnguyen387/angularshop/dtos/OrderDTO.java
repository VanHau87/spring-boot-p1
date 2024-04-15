package com.hnguyen387.angularshop.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hnguyen387.angularshop.groups.OnDelete;
import com.hnguyen387.angularshop.groups.OnUpdate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrderDTO {
	@NotNull(message = "Id must not be null", groups = {OnUpdate.class, OnDelete.class})
	private Integer id;
	@NotNull(message = "User id must not be null")
	@JsonProperty("user_id")
	private Integer userId;
	private String fullName;
	private String email;
	@NotBlank(message = "User id must not be null")
	@JsonProperty("phone_number")
	private String phoneNumber;
	@NotBlank(message = "User id must not be null")
	private String address;
	private String note;
	@NotNull(message = "User id must not be null")
	@Min(value = 0, message = "Total must be greater than 0")
	@JsonProperty("total_money")
	private Float totalMoney;
	@NotBlank(message = "Shipping method must not be null")
	@JsonProperty("shipping_method")
	private String shippingMethod;
	@NotBlank(message = "Shipping address must not be null")
	@JsonProperty("shipping_address")
	private String shippingAddress;
	@NotBlank(message = "Payment method must not be null")
	@JsonProperty("payment_method")
	private String paymentMethod;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Float getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Float totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
}
