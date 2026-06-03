package com.dheeraj.usermanagement.dto;

import lombok.Data;

@Data
public class LoginRequestDto {

    private String email;
    private String password;
}