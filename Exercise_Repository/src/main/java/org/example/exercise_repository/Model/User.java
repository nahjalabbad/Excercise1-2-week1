package org.example.exercise_repository.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name cannot be empty")
    @Size(min = 4)
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotEmpty(message = "username cannot be empty")
    @Size(min = 4)
    @Column(columnDefinition = "varchar(15) not null unique")
    private String username;

    @NotEmpty(message = "password cannot be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @NotEmpty(message = "email cannot be empty")
    @Email
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;

    @NotEmpty(message = "role cannot be empty")
    @Pattern(regexp = "^(user|admin)$")
    @Column(columnDefinition = "varchar(5) not null")
    private String role;

    @NotNull(message = "age cannot be empty")
    @Column(columnDefinition = "int not null")
    private Integer age;
}

