# Spring Boot User Management API

A structured backend project built using Spring Boot following layered architecture and REST API best practices.

This project performs CRUD (Create, Read, Update, Delete) operations with:

* MySQL database integration
* DTO architecture
* Validation
* Global exception handling
* Swagger documentation
* Standardized API responses

---

# Features

* Create User
* Get All Users
* Update Existing User
* Delete User
* MySQL Database Integration
* JPA & Hibernate
* DTO Layer
* Request Validation
* Global Exception Handling
* Custom Exception Handling
* Swagger/OpenAPI Documentation
* Standardized API Responses
* Lombok Integration
* Stream API Mapping
* Clean Layered Architecture

---

# Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok
* Swagger / OpenAPI
* REST API
* IntelliJ IDEA
* Postman

---

# Project Architecture

Controller
↓
DTO Layer
↓
Validation
↓
Service Layer
↓
Repository Layer
↓
MySQL Database

---

# Project Structure

src/main/java/com/dheeraj/usermanagement

├── controller
│   └── UserController.java

├── service
│   └── UserService.java

├── repository
│   └── UserRepository.java

├── dto
│   ├── UserRequestDto.java
│   └── UserResponseDto.java

├── exception
│   ├── GlobalExceptionHandler.java
│   └── UserNotFoundException.java

├── response
│   └── ApiResponse.java

├── config
│   └── SwaggerConfig.java

├── model
│   └── User.java

└── StartApplication.java

---

# API Endpoints

| Method | Endpoint    | Description     |
| ------ | ----------- | --------------- |
| POST   | /users      | Create new user |
| GET    | /users      | Get all users   |
| PUT    | /users/{id} | Update user     |
| DELETE | /users/{id} | Delete user     |

---

# Validation Features

* Name cannot be empty
* City cannot be empty
* Age must be greater than 0

---

# Standard API Response Format

## Success Response

```json
{
  "success": true,
  "message": "User created successfully",
  "data": {
    "id": 1,
    "name": "Dheeraj",
    "age": 22,
    "city": "Jaipur"
  }
}
```

## Validation Error Response

```json
{
  "success": false,
  "message": "Validation failed",
  "data": {
    "name": "Name cannot be empty",
    "age": "Age must be greater than 0"
  }
}
```

---

# Swagger Documentation

Swagger UI available at:

http://localhost:8080/swagger-ui/index.html

---

# Database Configuration

Update application.properties:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/usermanagement
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

# Key Concepts Implemented

* REST API Development
* Layered Architecture
* DTO Pattern
* Entity Mapping
* Request Validation
* Exception Handling
* API Documentation
* Repository Pattern
* Response Standardization
* Java Streams
* Lombok
* JPA & Hibernate

---

# Future Improvements

* JWT Authentication
* Role-Based Authorization
* Pagination
* Search & Sorting
* Unit Testing
* Docker Deployment
* Logging
* CI/CD Integration

---

# Author

Dheeraj Bhambhu
