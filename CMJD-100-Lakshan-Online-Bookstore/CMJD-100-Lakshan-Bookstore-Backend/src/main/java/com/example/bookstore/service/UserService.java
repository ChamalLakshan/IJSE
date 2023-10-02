package com.example.bookstore.service;

import java.util.List;

import com.example.bookstore.dto.UserDto;
import com.example.bookstore.entity.Users;
import com.example.bookstore.payloads.request.LoginInformation;
import com.example.bookstore.payloads.request.PasswordUpdate;

public interface UserService {

	Users login(LoginInformation information);
	boolean register(UserDto ionformation);
	boolean verify(String token) throws Exception;
	boolean isUserExist(String email);
	boolean update(PasswordUpdate information, String token);
	List<Users> getUsers();
	Users getSingleUser(String token);
}