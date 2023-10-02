package com.example.bookstore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan({ "com.example.bookstore" })
@SpringBootApplication
public class bookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(bookstoreApplication.class, args);
	}

}
