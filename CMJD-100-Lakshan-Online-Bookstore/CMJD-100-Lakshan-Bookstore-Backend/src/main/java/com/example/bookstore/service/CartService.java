package com.example.bookstore.service;

import java.util.List;

import com.example.bookstore.dto.CartDto;
import com.example.bookstore.entity.CartItem;

public interface CartService {
 List<CartItem> addBooktoCart(String token,long bookId);
 
 List<CartItem> getBooksfromCart(String token);
 
 boolean removeBooksFromCart(String token, Long bookId);
 
 int getCountOfBooks(String token);
 
 CartItem IncreaseBooksQuantityInCart(String token, Long bookId, CartDto bookQuantityDetails);
 
 CartItem descreaseBooksQuantityInCart(String token, Long bookId, CartDto bookQuantityDetails);

 
}

