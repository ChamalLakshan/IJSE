package com.example.bookstore.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.bookstore.dto.UserDto;
import com.example.bookstore.dto.UserProfileDTO;
import com.example.bookstore.entity.Users;
import com.example.bookstore.payloads.request.LoginInformation;
import com.example.bookstore.payloads.request.PasswordUpdate;
import com.example.bookstore.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Value("${upload.directory}")
    private String uploadDirectory;

    @Override
    public Users updateUser(Long userid, UserProfileDTO userProfileDTO) {
        Users existingUser = userRepository.findById(userid).orElse(null);

        if (existingUser != null) {

            MultipartFile file = userProfileDTO.getProfileImage();
            String filename = file.getOriginalFilename();
            String filePath = uploadDirectory + File.separator + filename;

            try {
                file.transferTo(new File(filePath));
            } catch (IllegalStateException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }

            existingUser.setProfileImage(filename);
            return userRepository.save(existingUser);
        }

        return null;
    }

    @Override
    public Users getUserById(Long userid) {
        return userRepository.findById(userid).orElse(null);
    }

    @Override
    public Users login(LoginInformation information) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    public boolean register(UserDto ionformation) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    @Override
    public boolean verify(String token) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verify'");
    }

    @Override
    public boolean isUserExist(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isUserExist'");
    }

    @Override
    public boolean updateUser(PasswordUpdate information, String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Users> getUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsers'");
    }

    @Override
    public Users getSingleUser(String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSingleUser'");
    }
}
