package org.example.capstone1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "merchantstock")
public class MerchantStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Product ID Cannot be empty")
    @Column(columnDefinition = "int not null")
    private Integer productID;

    @NotNull(message = "Merchant ID Cannot be empty")
    @Column(columnDefinition = "int not null")
    private Integer merchantID;

    @NotNull(message = "Stock Cannot be empty")
    @Column(columnDefinition = "int not null check(stock>=10)")
    private Integer stock;


    public void deductStock(Integer amount) {
        this.stock -= amount;
    }

    
}
