package com.example.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.bookstore.dto.AddressDto;
import com.example.bookstore.dto.UpdateAddressDto;
import com.example.bookstore.entity.Address;
import com.example.bookstore.entity.Users;

@Repository
public interface AdressService {

	Address addAddress(AddressDto address, String token);

	Users deleteAddress(String token, Long addressId);

	Address updateAddress(UpdateAddressDto address, String token);

	List<Address> getAllAddress();

	Address getAddress(Long id);

	List<Address> getAddressByUserId(String token);

	Address getAddress(String type, String token);

}
