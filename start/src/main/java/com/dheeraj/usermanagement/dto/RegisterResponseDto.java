package com.dheeraj.usermanagement.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponseDto {

    private Integer id;
    private String name;
    private String email;
    private String role;
}
