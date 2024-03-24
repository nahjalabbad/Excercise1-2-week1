package org.example.capstone1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Username Cannot be empty")
    @Column(columnDefinition = "varchar(25) not null")
    private String username;

    @NotEmpty(message = "Password Cannot be empty")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20}$")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @Email
    @NotEmpty(message = "Email Cannot be empty")
    @Column(columnDefinition = "varchar(100) not null")
    private String email;

    @NotEmpty(message = "Role Cannot be empty")
    @Pattern(regexp = "^(Admin|Customer)$")
    @Column(columnDefinition = "varchar(8) not null check(role='Admin' or role='Customer')")
    private String role;

    @NotNull(message = "Balance cannot be empty")
    @Column(columnDefinition = "double not null")
    private Double balance;

    @Column(columnDefinition = "int")
    private Integer points;

    @Transient
    private List<PurchaseHistory> purchaseHistoryList;

}
