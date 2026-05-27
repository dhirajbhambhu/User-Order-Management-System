package com.dheeraj.usermanagement.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

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

    public UserRequestDto() {
    }

    public UserRequestDto(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
