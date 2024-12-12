package com.example.jeeproj;

import jakarta.persistence.*;

@Entity
public class utilis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    private String role;

    // Getters et setters
}
