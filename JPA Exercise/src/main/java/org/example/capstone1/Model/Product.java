package org.example.capstone1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(25) not null")
    private String name;

    @Column(columnDefinition = "double not null check(price>0)")
    private Double price;

    @Column(columnDefinition = "int not null")
    private Integer categoryID;

    public boolean hasSameName(String otherProductName) {
        // Compare the product name with another product name
        return this.name.equalsIgnoreCase(otherProductName);
    }
}
