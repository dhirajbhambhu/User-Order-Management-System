package com.dheeraj.usermanagement.controller;

import com.dheeraj.usermanagement.model.User;
import com.dheeraj.usermanagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE USER
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User createdUser= userService.addUser(user);
        if(createdUser == null){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdUser);
    }

    // GET ALL USERS
    @GetMapping("/users")
    public ResponseEntity<List<User>>getUser(){
        return ResponseEntity.ok(userService.getUsers());
    }

    // UPDATE USER
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,
                             @RequestBody User updateduser) {

        User user = userService.updateUser(id, updateduser);
        if(user == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
        return ResponseEntity.ok(user);
    }

    // DELETE USER
    @DeleteMapping("/users/{id}")
    public ResponseEntity <String> deleteUser(@PathVariable int id) {

        String response =  userService.deleteUser(id);
        if(response.equals("User deleted successfully")){
            return ResponseEntity.ok(response);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}
