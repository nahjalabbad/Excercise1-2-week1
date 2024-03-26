package org.example.exercise_repository.Repository;

import org.example.exercise_repository.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserById(Integer id);

    User findUserByEmail(String email);

    @Query("select user from User user where user.username=?1 and user.password=?2")
    User logIn(String username, String password);
    List<User> findUserByRole(String role);

    @Query("select user from User user where user.age>=?1")
    List<User> userByAge(Integer age);
}
