package com.example.bookstore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.example.bookstore.entity.Users;
import com.example.bookstore.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepository.findByUsername(username).orElse(null);
        //Load User Roles

        if(user == null) {
            throw new UsernameNotFoundException("User not found with the given username");
        }

        return org.springframework.security.core.userdetails.User.builder()
            .username(user.getName())
            .password(user.getPassword())
            .build();
    }
    
}
