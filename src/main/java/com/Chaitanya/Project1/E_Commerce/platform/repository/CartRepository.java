package com.Chaitanya.Project1.E_Commerce.platform.repository;

import com.Chaitanya.Project1.E_Commerce.platform.Entity.Cart;
import com.Chaitanya.Project1.E_Commerce.platform.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import java.lang.ScopedValue;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByuser(User user);

    Optional<Cart> findByUser_Id(Long userId);
//    Optional<Cart> findByuser(Long userId);
}