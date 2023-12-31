package com.example.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.dto.UserDto;
import com.example.bookstore.entity.Users;
import com.example.bookstore.exception.UserException;
import com.example.bookstore.payloads.request.LoginInformation;
import com.example.bookstore.payloads.request.PasswordReset;
import com.example.bookstore.payloads.request.PasswordUpdate;
import com.example.bookstore.payloads.response.Response;
import com.example.bookstore.payloads.response.UserDetailRes;
import com.example.bookstore.service.UserService;
import com.example.bookstore.security.jwt.JwtUtils;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService service;
	

	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping("/registration")
	@ResponseBody
	public ResponseEntity<Response> registration(@RequestBody UserDto information) {
		System.out.println("user info" + information.toString());
		boolean result = service.register(information);
		if (result) {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new Response("registration successfull", 200, information));
		} else {
			return ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
					.body(new Response("User Already Exist", 400, information));
		}
	}
	
	
	@PostMapping("/user/login")
	public ResponseEntity<UserDetailRes> login(@RequestBody LoginInformation information) {
		
		Users users = service.login(information);
		if (users!=null) {
			String token= generate.jwtToken(users.getUserId());
			return ResponseEntity.status(HttpStatus.ACCEPTED).header("login successfull", information.getEmail())
					.body(new UserDetailRes(token, 200, users));
		}
		else {
			throw new UserException(" Invalide credentials");
		}
	}
	
	
	@GetMapping("/user/verify/{token}")
	public ResponseEntity<Response> userVerification(@PathVariable("token") String token) throws Exception {
		System.out.println("token for verification" + token);
		boolean update = service.verify(token);
		if (update)
		{
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("verified", 200));
		} 
		else 
		{	
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("not verified", 400));
		}
	}
	
	
	@PostMapping("user/forgotpassword")
	public ResponseEntity<Response> forgogPassword(@RequestBody PasswordReset passwordReset) {
	
		boolean result = service.isUserExist(passwordReset.getEmail());
		if (result) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("Check your email: Email sent", 200));
		} else {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("user does not exist with given email id", 400));
		}
	}
	
	@PutMapping("user/update/{token}")
	public ResponseEntity<Response> update(@PathVariable("token") String token, @RequestBody PasswordUpdate update) {
		System.out.println("inside controller  " +token);
		boolean result = service.updateUser(update, token);
		if (result) {
			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(new Response("password updated successfully", 200));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response("password doesn't match", 401));
		}

	}
	
	@GetMapping("user/getOneUser")
	public ResponseEntity<Response> getOneUsers(@RequestHeader("token") String token){
	Users user=service.getSingleUser(token);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(new Response("user is", 200, user));
	}
	
}
