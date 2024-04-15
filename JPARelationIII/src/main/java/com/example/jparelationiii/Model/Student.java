package com.example.jparelationiii.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name cannot be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotNull(message = "age cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "major cannot be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;

}
