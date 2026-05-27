# User Management System API

A professional beginner-level Spring Boot REST API project built using layered architecture and clean backend development practices.

This project performs CRUD (Create, Read, Update, Delete) operations for managing users with proper validation, exception handling, database integration, and Swagger API documentation.

---

# Features

- Create User
- Get All Users
- Update Existing User
- Delete User
- MySQL Database Integration
- Spring Data JPA
- DTO Layer Architecture
- Request Validation
- Global Exception Handling
- Structured Validation Error Responses
- Swagger/OpenAPI Documentation
- RESTful API Design
- Layered Architecture
- Constructor Injection
- Professional API Documentation

---

# Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Swagger / OpenAPI
- REST API
- IntelliJ IDEA
- Postman

---

# Project Architecture

Controller Layer
↓
DTO Layer
↓
Validation Layer
↓
Service Layer
↓
Repository Layer
↓
MySQL Database

---

# Project Structure

src/main/java/com/dheeraj/usermanagement

├── config
│   └── SwaggerConfig.java
│
├── controller
│   └── UserController.java
│
├── dto
│   └── UserRequestDto.java
│
├── exception
│   └── GlobalExceptionHandler.java
│
├── model
│   └── User.java
│
├── repository
│   └── UserRepository.java
│
├── service
│   └── UserService.java
│
└── StartApplication.java

---

# API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /users | Create a new user |
| GET | /users | Get all users |
| PUT | /users/{id} | Update existing user |
| DELETE | /users/{id} | Delete user |

---

# Validation Rules

- Name cannot be empty
- City cannot be empty
- Age must be greater than 0

---

# Example Request

## POST /users

```json
{
  "name": "Dheeraj",
  "age": 22,
  "city": "Jaipur"
}
```

---

# Example Validation Error Response

```json
{
  "name": "Name cannot be empty",
  "age": "Age must be greater than 0",
  "city": "City cannot be empty"
}
```

---

# Swagger Documentation

After running the application, open:

http://localhost:8080/swagger-ui/index.html

Swagger provides:
- Interactive API Testing
- API Documentation
- Request/Response Examples
- Validation Details

---

# Database Configuration

Update your MySQL credentials inside:

src/main/resources/application.properties

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/usermanagement
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

# How to Run Project

1. Clone Repository

```bash
git clone https://github.com/dhiraj181818/springboot-user-management.git
```

2. Open Project in IntelliJ IDEA

3. Configure MySQL Database

4. Run StartApplication.java

5. Open Swagger UI

---

# Concepts Implemented

- REST APIs
- CRUD Operations
- DTO Architecture
- Validation
- Exception Handling
- MySQL Integration
- JPA Repository
- Swagger/OpenAPI
- Layered Architecture
- HTTP Status Codes

---

# Future Improvements

- JWT Authentication
- Role-Based Authorization
- Pagination
- Logging
- Unit Testing
- Docker Deployment
- Response DTOs
- Lombok Integration

---

# Author

Dheeraj Bhambhu