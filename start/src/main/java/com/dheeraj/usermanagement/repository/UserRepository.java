package com.dheeraj.usermanagement.repository;

import com.dheeraj.usermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}