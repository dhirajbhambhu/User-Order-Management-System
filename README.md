# Spring Boot User Management API

A beginner-friendly REST API built using Spring Boot following clean architecture principles.  
This project performs CRUD (Create, Read, Update, Delete) operations for managing users and integrates MySQL database using Spring Data JPA and Hibernate.

---

## Features

- Create User
- Get All Users
- Update Existing User
- Delete User
- Proper HTTP Status Codes
- Layered Architecture
- RESTful API Design
- Constructor Injection
- Clean Package Structure
- MySQL Database Integration
- Spring Data JPA
- Hibernate ORM
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

├── model  
│   └── User.java

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
  "name": "Dheeraj",
  "age": 22,
  "city": "Jaipur"
}