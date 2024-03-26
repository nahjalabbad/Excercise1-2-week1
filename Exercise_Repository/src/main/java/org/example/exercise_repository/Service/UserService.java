package org.example.exercise_repository.Service;

import lombok.RequiredArgsConstructor;
import org.example.exercise_repository.Model.User;
import org.example.exercise_repository.Repository.UserRepository;
import org.example.jpa.API.ApiException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository users;

    public List<User> getUsers() {
        return users.findAll();
    }

    public void addUsers(User user) {
        users.save(user);
    }

    public void updateUser(Integer id, User user) {
        User user1 = users.findUserById(id);
        if (user1 == null) {
            throw new ApiException("Wrong ID");
        }
        user1.setName(user.getName());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        user1.setRole(user.getRole());
        user1.setAge(user.getAge());
        users.save(user1);
    }

    public void deleteUser(Integer id) {
        User user1 = users.findUserById(id);
        if (user1 == null) {
            throw new ApiException("Wrong ID");
        }
        users.delete(user1);
    }

    public User logIn(String username, String password){
        User user=users.logIn(username,password);
        if (user == null) {
            throw new ApiException("username or password are wrong ");
        }
        return user;
    }

    public User getByEmail(String email){
        User user=users.findUserByEmail(email);
        if (user == null) {
            throw new ApiException("Email incorrect");
        }
        return user;
    }

    public List<User> getByRole(String role){
        List<User> users1=users.findUserByRole(role);
        if (users1.isEmpty()) {
            throw new ApiException("Email incorrect");
        }
        return users1;
    }

    public List<User> getByAge(Integer age){
        List<User> users1=users.userByAge(age);
        if (users1.isEmpty()) {
            throw new ApiException("No users in this range of age were found");
        }
        return users1;
    }

}
