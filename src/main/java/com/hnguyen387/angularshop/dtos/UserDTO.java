package com.hnguyen387.angularshop.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hnguyen387.angularshop.groups.OnCreate;
import com.hnguyen387.angularshop.groups.OnDelete;
import com.hnguyen387.angularshop.groups.OnLogin;
import com.hnguyen387.angularshop.groups.OnUpdate;
import com.hnguyen387.angularshop.validations.FieldMatch;
import com.hnguyen387.angularshop.validations.IsExist;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@FieldMatch.List({
    @FieldMatch(first = "password", second = "confirmPassword", 
    		message = "The password and confirm_password fields must match",
    		groups = OnCreate.class)
})
@IsExist.List({
	@IsExist(field = "phoneNumber", message = "Phone exist", groups = OnCreate.class)
})
public class UserDTO {
	@NotNull(message = "Id must be entered", groups = {OnUpdate.class, OnDelete.class})
	private Integer id;
	@JsonProperty("fullname")
	@NotBlank(message = "Name must be entered")
	private String fullName;
	@JsonProperty("phone_number")
	@NotBlank(message = "Phone must be entered", groups = {OnCreate.class, OnLogin.class})
	private String phoneNumber;
	private String address;
	@NotBlank(message = "Password must be required", groups = {OnCreate.class, OnLogin.class})
	@Size(min = 5, max = 20, 
		message = "Password must be between 5-20 characters",
		groups = OnCreate.class)
	private String password;
	@JsonProperty("confirm_password")
	@NotBlank(message = "Please retype password", groups = OnCreate.class)
	private String confirmPassword;
	private Date dob;
	@JsonProperty("role_id")
	private Integer roleId;
	
	public UserDTO() {}
	
	public UserDTO(Integer id, String phoneNumber) {
		this.id = id;
		this.phoneNumber = phoneNumber;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	
}
