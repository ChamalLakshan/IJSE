package com.example.bookstore.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table
public class Quantity implements Serializable
{
   
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long quantity_id;
    @Column

	private Long quantityOfBook;
	@Column
	private Double totalprice;
	public long getQuantity_id() {
		return quantity_id;
	}
	public void setQuantity_id(long quantity_id) {
		this.quantity_id = quantity_id;
	}
	public Long getQuantityOfBook() {
		return quantityOfBook;
	}
	public void setQuantityOfBook(Long quantityOfBook) {
		this.quantityOfBook = quantityOfBook;
	}
	public Double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

