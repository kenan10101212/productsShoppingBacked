package com.example.productsShopping.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is reguired")
    @Size(min = 1,max = 50)
    @Column(unique = true)
    private String name;

    @NotBlank(message = "Surname is reguired")
    @Size(min = 1,max = 50)
    @Column(unique = true)
    private String surname;


    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Username is reguired")
    @Size(min = 1,max = 50)
    @Column(unique = true)
    private String username;


    @NotBlank(message = "Password is reguired")
    @Size(min = 1)
    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();
}
