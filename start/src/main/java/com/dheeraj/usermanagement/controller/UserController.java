package com.dheeraj.usermanagement.controller;
import com.dheeraj.usermanagement.dto.UserRequestDto;
import com.dheeraj.usermanagement.model.User;
import com.dheeraj.usermanagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;
import com.dheeraj.usermanagement.response.ApiResponse;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import com.dheeraj.usermanagement.dto.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;
@Tag(name = "User management API",
description = "APIs for managing user")
@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;}

    // CREATE USER
    @Operation(summary = "create a new user")
    @PostMapping("/users")
    public ResponseEntity<ApiResponse<UserResponseDto>> addUser(
            @Valid @RequestBody UserRequestDto userRequestDto) {

        UserResponseDto savedUser = userService.addUser(userRequestDto);
        ApiResponse<UserResponseDto> response = new ApiResponse<>(
                true,
                "User Created Successfully",
                savedUser
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
    // GET ALL USERS
    @Operation(summary = "Get all User")
    @GetMapping("/users")
    public ResponseEntity<ApiResponse<List<UserResponseDto>>> getUser() {

        List<UserResponseDto> users = userService.getUsers();
        ApiResponse<List<UserResponseDto>> response = new ApiResponse<>(
                true,
                "Users fetched successfully",
                users
        );
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Get User by ID")
    @GetMapping("users/{id}")
public ResponseEntity<ApiResponse<UserResponseDto>> getUserById(
        @PathVariable int id){
        UserResponseDto user = userService.getUserById(id);
        ApiResponse<UserResponseDto> response =
                new ApiResponse<>(
                        true,
                        "User Found",
                        user
                );
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Get user by name")
    @GetMapping("/users/name/{name}")
    public ResponseEntity<ApiResponse<UserResponseDto>> getUserByName(
            @PathVariable String name) {

        UserResponseDto user = userService.getUserByName(name);

        ApiResponse<UserResponseDto> response =
                new ApiResponse<>(
                        true,
                        "User found",
                        user
                );

        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Get users by city")
    @GetMapping("/users/city/{city}")
    public ResponseEntity<ApiResponse<List<UserResponseDto>>> getUsersByCity(
            @PathVariable String city) {

        List<UserResponseDto> users = userService.getUsersByCity(city);

        ApiResponse<List<UserResponseDto>> response =
                new ApiResponse<>(
                        true,
                        "Users found",
                        users
                );

        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Get users older than given age")
    @GetMapping("/users/age/{age}")
    public ResponseEntity<ApiResponse<List<UserResponseDto>>> getUsersOlderThan(
            @PathVariable int age) {

        List<UserResponseDto> users = userService.getUsersOlderThan(age);

        ApiResponse<List<UserResponseDto>> response =
                new ApiResponse<>(
                        true,
                        "Users found",
                        users
                );

        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Get users with pagination")
    @GetMapping("/users/paginated")
    public ResponseEntity<ApiResponse<Page<UserResponseDto>>> getUsersPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(
                page,
                size,
                sort);
        Page<UserResponseDto> users = userService.getUsers(pageable);
        ApiResponse<Page<UserResponseDto>> response =
                new ApiResponse<>(
                        true,
                        "Users fetched successfully",
                        users
                );

        return ResponseEntity.ok(response);
    }


    // UPDATE USER
    @Operation(summary = "Update existing User")
    @PutMapping("/users/{id}")
    public ResponseEntity<ApiResponse<String>> updateUser(@PathVariable int id,
                                            @Valid @RequestBody UserRequestDto updatedUser) {

        String result = userService.updateUser(id, updatedUser);

        if (result.equals("User not found")) {
            ApiResponse<String> response = new ApiResponse<>(
                    false,
                    result,
                    null
            );

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(response);
        }
        ApiResponse<String> response = new ApiResponse<>(
                true,
                result,
                null
        );

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete user by ID")
    @DeleteMapping("/users/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(
            @PathVariable int id) {

        String result = userService.deleteUser(id);

        if(result.equals("User not found")) {
            ApiResponse<String> response = new ApiResponse<>(
                    false,
                    result,
                    null
            );
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(response);
        }
        ApiResponse<String> response = new ApiResponse<>(
                true,
                result,
                null
        );
        return ResponseEntity.ok(response);
    }
}
