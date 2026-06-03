# User Management System API

A Spring Boot REST API project built to learn and practice Java Backend Development, Spring Boot, Spring Data JPA, Spring Security, MySQL, REST APIs, and Clean Architecture concepts.

---

## 🚀 Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA (Hibernate)
- Spring Security
- MySQL
- Maven
- Lombok
- Swagger / OpenAPI

---

## 📌 Project Overview

This project provides REST APIs for managing users, orders, and authentication.

The application follows a layered architecture:

```text
Controller → Service → Repository → Database
```

The goal of this project is to gain hands-on experience with backend development concepts commonly used in real-world applications.

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
└── security
```

---

# 👤 User Management APIs

## Create User

```http
POST /users
```

## Get All Users

```http
GET /users
```

## Get User By ID

```http
GET /users/{id}
```

## Update User

```http
PUT /users/{id}
```

## Delete User

```http
DELETE /users/{id}
```

## Search User By Name

```http
GET /users/name/{name}
```

## Search User By Age

```http
GET /users/age/{age}
```

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

Sort users dynamically.

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

Sample Request:

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

Supports partial matching and ignores upper/lower case.

Examples:

```text
lap
Laptop
LAPTOP
```

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

# 🔐 Authentication APIs

## Register User

```http
POST /auth/register
```

Sample Request:

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

Sample Request:

```json
{
  "email": "virat@gmail.com",
  "password": "password123"
}
```

Sample Response:

```json
{
  "success": true,
  "message": "Login Successful",
  "data": {
    "id": 1,
    "name": "Virat",
    "email": "virat@gmail.com"
  }
}
```

---

# 🔒 Password Security

Passwords are encrypted using BCrypt before storing in the database.

Example:

```text
$2a$10$tkNSQFc6eHFd/Lu/0A6vmOMqNdObubuoafaTYdPDP2XBI3JnYQlJq
```

Passwords are never stored in plain text.

---

# 🔗 Entity Relationship

```text
User (1)
    |
    |------> Order 1
    |------> Order 2
    |------> Order 3
```

JPA Mapping:

```java
@OneToMany
@ManyToOne
@JoinColumn
```

Database Relationship:

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

Custom Exceptions:

```java
UserNotFoundException
```

Global Handler:

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

# 🗄 Database

## users

| Column |
|----------|
| id |
| name |
| age |
| city |
| email |
| password |
| created_at |
| updated_at |

## orders

| Column |
|----------|
| id |
| product_name |
| price |
| user_id |

---

# 📖 Swagger Documentation

```text
http://localhost:8080/swagger-ui/index.html
```

Use Swagger to test APIs directly from the browser.

---

# 💻 Run Project

Clone Repository:

```bash
git clone https://github.com/dheeraj-bhambhu/springboot-user-management.git
```

Move Into Project:

```bash
cd springboot-user-management
```

Run Application:

```bash
mvn spring-boot:run
```

Or:

```bash
./mvnw spring-boot:run
```

---

# 🎯 Concepts Learned

- REST APIs
- Spring Boot
- Dependency Injection
- Layered Architecture
- DTO Pattern
- Entity Mapping
- JPA/Hibernate
- MySQL Integration
- Pagination
- Sorting
- One-To-Many Mapping
- Many-To-One Mapping
- Foreign Keys
- Custom Queries (@Query)
- Spring Security
- Authentication
- BCrypt Password Encryption
- Password Hashing
- Swagger Documentation

---

# 🚧 Upcoming Features

- JWT Generation
- JWT Validation
- Protected APIs
- Role Based Access Control
- Unit Testing
- Docker
- Deployment

---

# 👨‍💻 Author

Dheeraj Bhambhu

Java Backend Development Journey 🚀
