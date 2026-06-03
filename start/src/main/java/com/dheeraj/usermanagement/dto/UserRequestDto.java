package com.dheeraj.usermanagement.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    @Schema(description = "User full name",
            example = "Dhiraj")
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @Schema(description = "User Age",
            example = "22")
    @Min(value = 1, message = "Age must be greater than 0")
    private int age;
    @Schema(description = "User City",
            example = "Jaipur")
    @NotBlank(message = "City cannot be empty")
    private String city;
    private String email;

    private String password;
}

