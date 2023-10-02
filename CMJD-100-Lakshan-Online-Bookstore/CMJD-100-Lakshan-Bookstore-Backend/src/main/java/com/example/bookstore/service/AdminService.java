package com.example.bookstore.service;

import java.util.List;

import com.example.bookstore.entity.Book;

public interface AdminService {
	

	boolean verifyBook(long bookId, String staus, String token);


	List<Book> getBooksByStatus(String status);


}
