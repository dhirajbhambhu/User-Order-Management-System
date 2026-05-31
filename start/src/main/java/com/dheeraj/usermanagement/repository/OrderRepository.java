package com.dheeraj.usermanagement.repository;

import org.springframework.stereotype.Repository;
import com.dheeraj.usermanagement.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface OrderRepository extends  JpaRepository<Orders,Integer>{
    List<Orders> findByUserId(int userId);
    List<Orders> findByProductNameContainingIgnoreCase(String productName);
}
