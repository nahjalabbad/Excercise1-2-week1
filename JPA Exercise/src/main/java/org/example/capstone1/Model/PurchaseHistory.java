package org.example.capstone1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "purchasehistory")
public class PurchaseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer productId;

    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @NotEmpty
    @Column(columnDefinition = "varchar(25) not null")
    private String productName;

    @NotNull
    @Column(columnDefinition = "double not null")
    private Double price;

    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer quantity;

    @NotNull
    @Column(columnDefinition = "DATE")
    private LocalDate purchaseDate;


    public PurchaseHistory(Integer productId, Integer userId, String productName, Double price, Integer quantity, LocalDate purchaseDate) {
        this.productId = productId;
        this.userId = userId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
    }
}