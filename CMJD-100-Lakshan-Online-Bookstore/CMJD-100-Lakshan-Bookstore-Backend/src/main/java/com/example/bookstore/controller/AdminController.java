package com.example.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.payloads.response.BookResponse;
import com.example.bookstore.service.AdminService;

@RestController
@CrossOrigin("*")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	BookRepository bookRepo;

	@PutMapping("admin/update/{bookId}")
	public ResponseEntity<BookResponse> updateBookStatus(@PathVariable long bookId, @RequestParam String status ,@RequestHeader String token) {
		if (adminService.verifyBook(bookId,status,token)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new BookResponse("Seller book status updated by the admin", HttpStatus.ACCEPTED));
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new BookResponse(406,"Bad Response"));
	}
	
	
	
	@GetMapping("admin/books")
	public ResponseEntity<BookResponse> getAllBooksByStatus(@RequestParam String status) {
		List<Book> books = adminService.getBooksByStatus(status);
		
			return ResponseEntity.status(HttpStatus.OK).body(new BookResponse(status+" Books ", books));
		

	}
	
}