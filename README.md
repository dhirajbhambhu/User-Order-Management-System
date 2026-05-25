# Spring Boot User Management API

A beginner-friendly REST API built using Spring Boot following clean architecture principles.  
This project performs CRUD (Create, Read, Update, Delete) operations for managing users with MySQL database integration using Spring Data JPA and Hibernate.

The project also includes:
- Validation
- Global Exception Handling
- DTO Layer
- Structured Error Responses
- Layered Architecture

---

## Features

- Create User
- Get All Users
- Update Existing User
- Delete User
- MySQL Database Integration
- Spring Data JPA
- Hibernate ORM
- DTO Layer
- Validation using `@Valid`
- Global Exception Handling
- Structured Validation Errors
- RESTful API Design
- Layered Architecture
- Constructor Injection
- Automatic Table Creation

---

## Tech Stack

- Java
- Spring Boot
- Maven
- REST API
- MySQL
- Spring Data JPA
- Hibernate
- Postman
- IntelliJ IDEA

---

## Project Structure

src/main/java/com/dheeraj/usermanagement

├── controller  
│   └── UserController.java

├── service  
│   └── UserService.java

├── repository  
│   └── UserRepository.java

├── model  
│   └── User.java

├── dto  
│   └── UserRequestDto.java

├── exception  
│   └── GlobalExceptionHandler.java

└── StartApplication.java

---

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /users | Create a new user |
| GET | /users | Get all users |
| PUT | /users/{id} | Update user |
| DELETE | /users/{id} | Delete user |

---

## Sample POST Request

```json
{
  "Id" : 1,
  "name": "Dheeraj",
  "age": 22,
  "city": "Jaipur"
}