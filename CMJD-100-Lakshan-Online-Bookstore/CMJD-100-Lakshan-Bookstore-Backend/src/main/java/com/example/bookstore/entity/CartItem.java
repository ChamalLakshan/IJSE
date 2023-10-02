package com.example.bookstore.entity;

import java.io.Serializable;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


@Entity
public class CartItem implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Book> booksList;
	
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Quantity.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "cartId")
	private List<Quantity> quantityOfBook;

	



	public Long getCartId() {
		return cartId;
	}


	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}


	public List<Book> getBooksList() {
		return booksList;
	}


	public void setBooksList(List<Book> booksList) {
		this.booksList = booksList;
	}


	public List<Quantity> getQuantityOfBook() {
		return quantityOfBook;
	}


	public void setQuantityOfBook(List<Quantity> quantityOfBook) {
		this.quantityOfBook = quantityOfBook;
	}


	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
