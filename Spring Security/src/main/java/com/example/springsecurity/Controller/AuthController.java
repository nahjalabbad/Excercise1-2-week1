package com.example.springsecurity.Controller;

import com.example.springsecurity.API.ApiResponse;
import com.example.springsecurity.Model.User;
import com.example.springsecurity.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @GetMapping("/get")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok(authService.getAllUsers());
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid User user){
        authService.register(user);
        return ResponseEntity.ok(new ApiResponse("User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity login(){
        authService.login();
        return ResponseEntity.ok(new ApiResponse("Welcome back."));
    }
    @PostMapping("/logout")
    public ResponseEntity logout(){
        authService.logout();
        return ResponseEntity.ok(new ApiResponse("See you soon."));
    }

    @PutMapping("/update/{username}")
    public ResponseEntity updateUser(@PathVariable String username,@RequestBody @Valid User user){
        authService.updateUser(username,user);
        return ResponseEntity.ok(new ApiResponse("user information updated successfully"));
    }

    @DeleteMapping("/delete/{username}/{username1}")
    public ResponseEntity deleteUser(@PathVariable String username,@PathVariable String username1 ){
        authService.deleteUser(username,username1);
        return ResponseEntity.ok(new ApiResponse("user information deleted successfully"));
    }



}
