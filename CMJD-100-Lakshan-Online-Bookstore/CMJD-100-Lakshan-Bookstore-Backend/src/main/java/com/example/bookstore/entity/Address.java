package com.example.bookstore.entity;

import java.io.Serializable;

import com.example.bookstore.dto.AddressDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Address")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private long addressId;


	@Column(name = "customer_address")
	private String address;

	@Column(name = "customer_city")
	private String city;

	@Column
	private String phoneNumber;

	@Column
	private String name;

	public Address(Address address2) {
		this.name = address2.getName();
		this.phoneNumber = address2.getPhoneNumber();

		this.address = address2.getAddress();
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	 

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
