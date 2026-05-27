package com.dheeraj.usermanagement.controller;
import com.dheeraj.usermanagement.dto.UserRequestDto;
import com.dheeraj.usermanagement.model.User;
import com.dheeraj.usermanagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
@Tag(name = "User management API",
description = "APIs for managing user")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    // CREATE USER
    @Operation(summary = "create a new user")
      @PostMapping("/users")
      public ResponseEntity<User> addUser(
              @Valid @RequestBody UserRequestDto userRequestDto) {

          User savedUser = userService.addUser(userRequestDto);

          return ResponseEntity
                  .status(HttpStatus.CREATED)
                  .body(savedUser);
      }

    // GET ALL USERS
    @Operation(summary = "Get all User")
    @GetMapping("/users")
    public ResponseEntity<List<User>>getUser(){
        return ResponseEntity.ok(userService.getUsers());
    }


    // UPDATE USER
    @Operation(summary = "Update existing User")
    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id,
                                            @Valid @RequestBody UserRequestDto updatedUser) {

        String response = userService.updateUser(id, updatedUser);

        if (response.equals("User not found")) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(response);
        }

        return ResponseEntity.ok(response);
    }

    // DELETE USER
    @Operation(summary = "Delete the user by ID")
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {

        String response = userService.deleteUser(id);

        if (response.equals("User not found")) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(response);
        }

        return ResponseEntity.ok(response);
    }
}
