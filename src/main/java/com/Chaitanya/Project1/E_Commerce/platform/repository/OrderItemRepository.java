package com.Chaitanya.Project1.E_Commerce.platform.repository;

import com.Chaitanya.Project1.E_Commerce.platform.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}