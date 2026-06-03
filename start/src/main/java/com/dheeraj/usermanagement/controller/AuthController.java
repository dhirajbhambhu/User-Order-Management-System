package com.dheeraj.usermanagement.controller;
import com.dheeraj.usermanagement.dto.LoginRequestDto;
import com.dheeraj.usermanagement.dto.LoginResponseDto;
import com.dheeraj.usermanagement.dto.RegisterRequestDto;
import com.dheeraj.usermanagement.dto.RegisterResponseDto;
import com.dheeraj.usermanagement.response.ApiResponse;
import com.dheeraj.usermanagement.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<RegisterResponseDto>> register(
            @RequestBody RegisterRequestDto requestDto) {

        RegisterResponseDto responseDto =
                authService.register(requestDto);

        ApiResponse<RegisterResponseDto> response =
                new ApiResponse<>(
                        true,
                        "User Registered Successfully",
                        responseDto
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDto>> login(
            @RequestBody LoginRequestDto requestDto) {

        LoginResponseDto responseDto =
                authService.login(requestDto);

        ApiResponse<LoginResponseDto> response =
                new ApiResponse<>(
                        true,
                        "Login Successful",
                        responseDto
                );

        return ResponseEntity.ok(response);
    }
}
