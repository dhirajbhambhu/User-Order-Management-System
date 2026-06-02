package com.dheeraj.usermanagement.repository;

import org.springframework.stereotype.Repository;
import com.dheeraj.usermanagement.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.repository.query.Param;

@Repository
public interface OrderRepository extends  JpaRepository<Orders,Integer>{
    List<Orders> findByUserId(int userId);
    List<Orders> findByProductNameContainingIgnoreCase(String productName);
   @Query("SELECT o FROM Orders o WHERE o.price > :price")
   List<Orders> findOrdersAbovePrice(double price);
    @Query("""
       SELECT o
       FROM Orders o
       WHERE o.price BETWEEN :minPrice AND :maxPrice
       """)
    List<Orders> findOrdersBetweenPrices(
            @Param("minPrice") double minPrice,
            @Param("maxPrice") double maxPrice
    );
}
