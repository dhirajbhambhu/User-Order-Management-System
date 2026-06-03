package com.dheeraj.usermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private int id;

    private String name;

    private int age;

    private String city;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String email;
}
