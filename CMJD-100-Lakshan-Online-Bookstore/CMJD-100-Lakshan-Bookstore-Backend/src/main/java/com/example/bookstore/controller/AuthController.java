package com.example.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.dto.UserLoginDTO;
import com.example.bookstore.entity.Users;
import com.example.bookstore.payloads.request.LoginInformation;
import com.example.bookstore.payloads.response.JwtResponse;
import com.example.bookstore.payloads.response.MessageResponse;
import com.example.bookstore.repository.UserRepository;
import com.example.bookstore.security.jwt.JwtUtils;

@CrossOrigin(origins = "*")
@RestController
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/auth/register")
    public ResponseEntity<?> registerUser(@RequestBody com.example.bookstore.entity.Users user) {
        
        if(userRepository.existsByUsername(user.getName())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Username is already taken"));
        }

        if(userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Email already in use"));
        }
        
        Users newUser = new Users();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        
        userRepository.save(newUser);

        return ResponseEntity.ok(new MessageResponse("User created successfully."));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO request) {

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        Users user = userRepository.findByUsername(request.getUsername()).orElse(null);

        return ResponseEntity.ok(new JwtResponse(jwt,user.getUserId(),user.getName(),user.getEmail()));
    }
    
}
