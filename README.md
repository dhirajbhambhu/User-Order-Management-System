![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-green)
![JWT](https://img.shields.io/badge/JWT-Authentication-blue)
![Railway](https://img.shields.io/badge/Deployed-Railway-purple)

# User Management System API

A production-ready Spring Boot REST API for User and Order Management featuring JWT Authentication, Role-Based Access Control (RBAC), Spring Security, MySQL, Swagger Documentation, and Railway Deployment.

---

## Highlights

- Developed and deployed a secure REST API using Spring Boot and Spring Security.
- Implemented JWT Authentication and Role-Based Access Control (ADMIN/USER).
- Designed One-to-Many User-Order relationships using JPA/Hibernate.
- Deployed production application on Railway.
- Documented APIs using Swagger/OpenAPI.

---

## 🚀 Live Demo

### Swagger UI

https://springboot-user-management-production-0066.up.railway.app/swagger-ui/index.html

### API Base URL

https://springboot-user-management-production-0066.up.railway.app

---

## 🚀 Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA (Hibernate)
* Spring Security
* JWT Authentication
* MySQL
* Maven
* Lombok
* Swagger / OpenAPI
* Railway Deployment

---

## 📌 Project Overview

This project provides REST APIs for managing users, orders, authentication, and authorization.

Key features include:

* JWT Authentication
* Role-Based Access Control (ADMIN / USER)
* BCrypt Password Encryption
* User Management
* Order Management
* Pagination
* Sorting
* Custom JPA Queries
* Swagger Documentation
* Global Exception Handling
* Railway Deployment

The application follows a layered architecture:

```text
Client
  |
  v
Controller
  |
  v
Service
  |
  v
Repository
  |
  v
MySQL
```

---

## 📂 Project Structure

```text
src/main/java/com/dheeraj/usermanagement

├── controller
├── service
├── repository
├── model
├── dto
├── response
├── exception
├── config
```

---

# 🔐 Authentication APIs

## Register User

```http
POST /auth/register
```

### Sample Request

```json
{
  "name": "Virat",
  "age": 35,
  "city": "Delhi",
  "email": "virat@gmail.com",
  "password": "password123"
}
```

---

## Login User

```http
POST /auth/login
```

### Sample Request

```json
{
  "email": "virat@gmail.com",
  "password": "password123"
}
```

### Sample Response

```json
{
  "success": true,
  "message": "Login Successful",
  "data": {
    "token": "JWT_TOKEN"
  }
}
```

---

# 🔒 Security Features

* JWT Authentication
* BCrypt Password Hashing
* Stateless Authentication
* Role-Based Access Control
* Protected APIs
* Authorization using Bearer Token

### Roles

```text
ADMIN
USER
```

### Access Rules

```text
ADMIN → Create, Update, Delete Users

USER → Read Operations Only
```

---

# 👤 User Management APIs

## Create User

```http
POST /users
```

🔒 ADMIN Only

---

## Get All Users

```http
GET /users
```

🔒 Authenticated Users

---

## Get User By ID

```http
GET /users/{id}
```

🔒 Authenticated Users

---

## Update User

```http
PUT /users/{id}
```

🔒 ADMIN Only

---

## Delete User

```http
DELETE /users/{id}
```

🔒 ADMIN Only

---

## Search User By Name

```http
GET /users/name/{name}
```

🔒 Authenticated Users

---

## Search User By Age

```http
GET /users/age/{age}
```

🔒 Authenticated Users

---

# 📄 Pagination

Fetch users page by page.

```http
GET /users/paginated?page=0&size=5
```

Example:

```http
GET /users/paginated?page=1&size=10
```

---

# 🔃 Sorting

Ascending:

```http
GET /users/paginated?page=0&size=5&sortBy=name&direction=asc
```

Descending:

```http
GET /users/paginated?page=0&size=5&sortBy=age&direction=desc
```

---

# 🛒 Order Management APIs

## Create Order

```http
POST /users/{userId}/orders
```

### Sample Request

```json
{
  "productName": "Laptop",
  "price": 50000
}
```

---

## Get All Orders Of User

```http
GET /users/{userId}/orders
```

---

## Get Order By ID

```http
GET /orders/{orderId}
```

---

## Update Order

```http
PUT /orders/{orderId}
```

---

## Delete Order

```http
DELETE /orders/{orderId}
```

---

## Search Orders By Product Name

```http
GET /orders/search?productName=laptop
```

Supports:

```text
lap
Laptop
LAPTOP
```

Case-insensitive partial matching.

---

# 🔍 Custom JPA Query

## Orders Above Price

```http
GET /orders/above-price/{price}
```

Example:

```http
GET /orders/above-price/50000
```

Returns all orders having price greater than the given value.

---

# 🔗 Entity Relationship

```text
User (1)
    |
    ├── Order 1
    ├── Order 2
    └── Order 3
```

### JPA Mapping

```java
@OneToMany
@ManyToOne
@JoinColumn
```

### Database Relationship

```text
users
   |
   | id
   |
orders
   |
   | user_id
```

---

# ⚠️ Exception Handling

### Custom Exceptions

```java
UserNotFoundException
```

### Global Exception Handler

```java
@RestControllerAdvice
```

Provides consistent error responses throughout the application.

---

# 📦 API Response Structure

```json
{
  "success": true,
  "message": "Operation Successful",
  "data": {}
}
```

---

# 🗄 Database Schema

## users

| Column     |
| ---------- |
| id         |
| name       |
| age        |
| city       |
| email      |
| password   |
| role       |
| created_at |
| updated_at |

---

## orders

| Column       |
| ------------ |
| id           |
| product_name |
| price        |
| user_id      |

---

# 🔑 JWT Authentication Flow

```text
1. Register User

2. Login User

3. Receive JWT Token

4. Click Authorize in Swagger

5. Enter:
Bearer <token>

6. Access Protected APIs
```

---

# 📖 Swagger Documentation

### Local

```text
http://localhost:8080/swagger-ui/index.html
```

### Production

```text
https://springboot-user-management-production-0066.up.railway.app/swagger-ui/index.html
```

---

# 💻 Run Project Locally

### Clone Repository

```bash
git clone https://github.com/dheeraj-bhambhu/springboot-user-management.git
```

### Move Into Project

```bash
cd springboot-user-management
```

### Configure Database

Update:

```properties
application.properties
```

with your MySQL credentials.

---

### Run Application

```bash
mvn spring-boot:run
```

or

```bash
./mvnw spring-boot:run
```

---

# 🎯 Concepts Learned

* Java Backend Development
* REST APIs
* Spring Boot
* Spring Security
* JWT Authentication
* Role-Based Access Control
* Dependency Injection
* DTO Pattern
* Layered Architecture
* JPA/Hibernate
* MySQL Integration
* Entity Relationships
* Pagination
* Sorting
* Custom Queries
* BCrypt Password Hashing
* Global Exception Handling
* Swagger Documentation
* Railway Deployment

---

# 🚀 Future Improvements

* Docker Containerization
* Unit Testing (JUnit + Mockito)

---

# 👨‍💻 Author

**Dheeraj Bhambhu**

Java Backend Developer

GitHub:
https://github.com/dheeraj-bhambhu

LinkedIn:
https://www.linkedin.com/in/dhiraj-bhambhu/

🚀 Building real-world Java Backend projects and preparing for Software Engineering roles.
