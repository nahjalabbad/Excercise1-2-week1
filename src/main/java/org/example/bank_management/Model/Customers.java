package org.example.bank_management.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Customers {
    private String username;
    private int ID;
    private double balance;

}
