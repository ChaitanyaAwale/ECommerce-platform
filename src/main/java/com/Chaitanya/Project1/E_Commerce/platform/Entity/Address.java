package com.Chaitanya.Project1.E_Commerce.platform.Entity;

import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;

    private String State;
    private String Country;

    private String pincode;
    @ManyToOne
    @JoinColumn(name="User_id")
    private User user;


    }
