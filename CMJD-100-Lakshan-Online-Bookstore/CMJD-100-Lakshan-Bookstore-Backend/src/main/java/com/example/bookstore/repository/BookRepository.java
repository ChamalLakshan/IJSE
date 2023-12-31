package com.example.bookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.bookstore.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	
	List<Book> findByStatus(String status);
	
	Book findByBookId(Long bookId);

}
