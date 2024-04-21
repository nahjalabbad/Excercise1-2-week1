package com.example.springsecurity.Service;

import com.example.springsecurity.API.ApiException;
import com.example.springsecurity.Model.User;
import com.example.springsecurity.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;


    public void login(){

    }

    public void logout(){

    }

    public List<User> getAllUsers(){

        return authRepository.findAll();
    }

    public void register(User user){
        user.setRole("CUSTOMER");
        String hashPassword=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashPassword);

        authRepository.save(user);
    }

    public void updateUser(String username,User user){
        User user1=authRepository.findUserByUsername(username);
        if (user1==null){
            throw new ApiException("");

        }
        user1.setUsername(user.getUsername());
        String hashPassword=new BCryptPasswordEncoder().encode(user.getPassword());
        user1.setPassword(hashPassword);
        authRepository.save(user1);

    }

    public void deleteUser(String username, String username1){
        User user=authRepository.findUserByUsername(username);
        if (!user.getRole().equalsIgnoreCase("admin")){
            throw new ApiException("Unauthorized entry");
        }
        User user1=authRepository.findUserByUsername(username1);
        authRepository.delete(user1);
    }






}
