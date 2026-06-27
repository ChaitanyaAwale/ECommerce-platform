package com.Chaitanya.Project1.E_Commerce.platform.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.net.ssl.SSLSession;
@Setter
@Getter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;

    private String state;
    private String country;

    private String pincode;
    @ManyToOne
    @JoinColumn(name="User_id")
    private User user;





}
