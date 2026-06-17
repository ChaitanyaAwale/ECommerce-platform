package com.Chaitanya.Project1.E_Commerce.platform.repository;

import com.Chaitanya.Project1.E_Commerce.platform.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}