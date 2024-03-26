package org.example.exercise_repository.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.exercise_repository.Model.User;
import org.example.exercise_repository.Service.UserService;
import org.example.jpa.API.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUsers(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }

        userService.addUsers(user);
        return ResponseEntity.ok().body(new ApiResponse("User Added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        userService.updateUser(id,user);
        return ResponseEntity.ok().body(new ApiResponse("User updated"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.ok().body(new ApiResponse("User deleted"));

    }

    @GetMapping("/login/{username}/{password}")
    public ResponseEntity logIn(@PathVariable String username,@PathVariable String password ){
        User user=userService.logIn(username,password);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/search-email/{email}")
    public ResponseEntity getByEmail(@PathVariable String email){
        User user=userService.getByEmail(email);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/search-role/{role}")
    public ResponseEntity getByRole(@PathVariable String role){
        List<User> byRole=userService.getByRole(role);
        return ResponseEntity.ok().body(byRole);
    }

    @GetMapping("/search-age/{age}")
    public ResponseEntity getByAge(@PathVariable Integer age){
        List<User> byAge=userService.getByAge(age);
        return ResponseEntity.ok().body(byAge);
    }
}
