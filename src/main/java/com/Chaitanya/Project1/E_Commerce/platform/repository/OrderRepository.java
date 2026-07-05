package com.Chaitanya.Project1.E_Commerce.platform.repository;

import com.Chaitanya.Project1.E_Commerce.platform.Entity.Order;
import com.Chaitanya.Project1.E_Commerce.platform.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}