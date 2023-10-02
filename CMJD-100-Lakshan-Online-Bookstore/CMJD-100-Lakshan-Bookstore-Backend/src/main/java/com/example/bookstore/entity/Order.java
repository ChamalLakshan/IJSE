package com.example.bookstore.entity;

import java.io.Serializable;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_details")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Long orderId;

	private Double totalPrice;

	private Long addressId;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Quantity.class)
	@JoinColumn(name = "orderId")
	private List<Quantity> QuantityOfBooks;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Book> BooksList;

	public Order() {

	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public List<Quantity> getQuantityOfBooks() {
		return QuantityOfBooks;
	}

	public void setQuantityOfBooks(List<Quantity> quantityOfBooks) {
		QuantityOfBooks = quantityOfBooks;
	}

	public List<Book> getBooksList() {
		return BooksList;
	}

	public void setBooksList(List<Book> booksList) {
		BooksList = booksList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
