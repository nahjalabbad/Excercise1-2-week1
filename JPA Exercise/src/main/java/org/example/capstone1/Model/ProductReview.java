package org.example.capstone1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "productreview")
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Product ID Cannot be empty")
    @Column(columnDefinition = "int not null")
    private Integer productId;

    @NotNull(message = "User ID Cannot be empty")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @Column(columnDefinition = "double not null check(rating>=1 and rating<=5)")
    private Double rating;

    @NotEmpty(message = "Please write a comment")
    @Column(columnDefinition = "varchar(255) not null")
    private String reviewComment;

    @NotEmpty(message = "Product name cannot be empty")
    @Column(columnDefinition = "varchar(25) not null")
    private String productName;
}
