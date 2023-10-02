package com.example.bookstore.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String name;
	private String email;
	private String password;
	
	private Long mobileNumber;

	private String role;

	@OneToMany(cascade = CascadeType.ALL,targetEntity = Address.class)
	@JoinColumn(name = "userId")
	private List<Address> address;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = CartItem.class)
	@JoinColumn(name = "userId")
	private List<CartItem> cartBooks;

	private List<Order> orderBookDetails;

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", mobileNumber=" + mobileNumber +
				", role=" + role + ", address=" + address + ", cartBooks=" + cartBooks + "]";
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<CartItem> getCartBooks() {
		return cartBooks;
	}

	public void setCartBooks(List<CartItem> cartBooks) {
		this.cartBooks = cartBooks;
	}

	public List<Order> getOrderBookDetails() {
		return orderBookDetails;
	}

	public void setOrderBookDetails(List<Order> orderBookDetails) {
		this.orderBookDetails = orderBookDetails;
	}

	public void setProfileImage(String filename) {
	}
}
