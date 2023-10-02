package com.example.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    //custom queries
    
}
