package com.dheeraj.usermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDto {

    private Integer id;
    private String name;
    private String email;
    private String token;
    private String role;
}