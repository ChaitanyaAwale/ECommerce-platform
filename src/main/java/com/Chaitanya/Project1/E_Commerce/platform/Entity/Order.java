package com.Chaitanya.Project1.E_Commerce.platform.Entity;

//import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;

    private LocalDateTime orderDate;

    private BigDecimal totalAmount;
    private String status;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "order",
    cascade=CascadeType.ALL,
            orphanRemoval = true)
    private List<OrderItem> orderItemList;
}
