package com.dheeraj.usermanagement.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "User Management System API",
                version = "1.0",
                description = "Spring Boot REST API for managing users"
        )
)
public class SwaggerConfig {
}
