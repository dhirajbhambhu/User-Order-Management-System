# User Management System API

A Spring Boot REST API project built to learn and practice Java Backend Development, Spring Boot, Spring Data JPA, MySQL, REST APIs, and Clean Architecture concepts.

---

## 🚀 Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA (Hibernate)
* MySQL
* Maven
* Lombok
* Swagger / OpenAPI

---

## 📌 Project Overview

This project provides REST APIs for managing users and their orders.

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
└── config
```

---

## 👤 User Management Features

### Create User

```http
POST /users
```

Creates a new user.

### Get All Users

```http
GET /users
```

Returns all users.

### Get User By ID

```http
GET /users/{id}
```

Returns a user by id.

### Update User

```http
PUT /users/{id}
```

Updates an existing user.

### Delete User

```http
DELETE /users/{id}
```

Deletes a user.

### Search User By Name

```http
GET /users/name/{name}
```

Searches user by name.

### Search User By Age

```http
GET /users/age/{age}
```

Searches users by age.

---

## 📄 Pagination

Fetch users page by page.

```http
GET /users/paginated?page=0&size=5
```

Example:

```http
GET /users/paginated?page=1&size=10
```

---

## 🔃 Sorting

Sort users dynamically using any field.

### Ascending Order

```http
GET /users/paginated?page=0&size=5&sortBy=name&direction=asc
```

### Descending Order

```http
GET /users/paginated?page=0&size=5&sortBy=age&direction=desc
```

Supported fields:

* id
* name
* age
* city
* createdAt
* updatedAt

---

## ⏰ Audit Fields

Each user contains:

```java
private LocalDateTime createdAt;
private LocalDateTime updatedAt;
```

### Purpose

* createdAt → Stores record creation time
* updatedAt → Stores latest update time

---

## 🛒 Order Management

### Create Order For User

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

Sample Response:

```json
{
  "success": true,
  "message": "Order Created Successfully",
  "data": {
    "id": 1,
    "productName": "Laptop",
    "price": 50000
  }
}
```

---

## 🔗 Entity Relationship

### User → Orders

One User can have multiple Orders.

```text
User (1)
   |
   |------> Order 1
   |------> Order 2
   |------> Order 3
```

Implemented using JPA:

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
  | user_id (Foreign Key)
```

---

## ⚠️ Exception Handling

Custom Exception:

```java
UserNotFoundException
```

Global Exception Handling:

```java
@RestControllerAdvice
```

Provides consistent error responses throughout the application.

---

## 📦 API Response Structure

All APIs return a common response format:

```json
{
  "success": true,
  "message": "Operation Successful",
  "data": {}
}
```

---

## 🗄 Database

Database: MySQL

Current Tables:

### users

| Column     |
| ---------- |
| id         |
| name       |
| age        |
| city       |
| created_at |
| updated_at |

### orders

| Column       |
| ------------ |
| id           |
| product_name |
| price        |
| user_id      |

---

## 📖 Swagger Documentation

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

Use Swagger to test APIs directly from the browser.

---

## 🎯 Concepts Learned

* REST APIs
* Spring Boot
* Dependency Injection
* Layered Architecture
* DTO Pattern
* Entity Mapping
* JPA/Hibernate
* MySQL Integration
* Pagination
* Sorting
* Exception Handling
* One-to-Many Relationships
* Many-to-One Relationships
* Foreign Keys
* Swagger Documentation

---

## 🚧 Upcoming Features

* Get All Orders Of A User
* Update Order
* Delete Order
* Validation (@Valid)
* Global Validation Handling
* Advanced JPA Queries
* PostgreSQL Support
* Unit Testing (JUnit + Mockito)
* Docker Deployment

---

## 👨‍💻 Author

Dheeraj Bhambhu

Java Backend Development Journey

Building backend systems with Spring Boot, JPA, MySQL, and Clean Architecture.
