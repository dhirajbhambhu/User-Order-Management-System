package com.dheeraj.usermanagement.repository;

import com.dheeraj.usermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    Optional<User> findByName(String name);
    List<User> findByCity(String city);
    List<User> findByAgeGreaterThan(int age);
}