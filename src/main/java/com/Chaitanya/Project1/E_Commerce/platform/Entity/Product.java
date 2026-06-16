package com.Chaitanya.Project1.E_Commerce.platform.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

//@Id
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;


    @Column(nullable=false)
    private String name;

    @Column(length=2000)
    private String description;

    private BigDecimal price;

    private Integer stockQuantity;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
}
