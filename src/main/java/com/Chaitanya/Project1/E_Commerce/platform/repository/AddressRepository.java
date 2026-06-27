package com.Chaitanya.Project1.E_Commerce.platform.repository;

import com.Chaitanya.Project1.E_Commerce.platform.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByUser_Id(Long userId);
//    List<Address> findByUser_Id(Long userId);
}