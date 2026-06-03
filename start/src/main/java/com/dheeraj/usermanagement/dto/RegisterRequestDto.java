package com.dheeraj.usermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class RegisterRequestDto {

        private String name;
        private int age;
        private String city;
        private String email;
        private String password;
    }

