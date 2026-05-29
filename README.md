# User Management System API

A RESTful User Management System built using Spring Boot, Spring Data JPA, and MySQL. This project demonstrates backend development concepts including CRUD operations, DTOs, validation, exception handling, pagination, sorting, and API documentation with Swagger.

---

## Features

* Create User
* Get All Users
* Get User By ID
* Get User By Name
* Get Users By City
* Get Users Older Than a Given Age
* Update User
* Delete User
* Request Validation
* Custom API Responses
* Global Exception Handling
* Custom Exceptions
* DTO Pattern
* Swagger/OpenAPI Documentation
* Pagination
* Sorting (Ascending and Descending)

---

## Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Lombok
* Swagger / OpenAPI

---

## Project Structure

```text
src/main/java/com/dheeraj/usermanagement

├── controller
├── dto
├── exception
├── model
├── repository
├── response
├── service
├── config
└── StartApplication.java
```

---

## API Endpoints

### Create User

```http
POST /users
```

Request Body:

```json
{
  "name": "Dheeraj",
  "age": 22,
  "city": "Jaipur"
}
```

---

### Get All Users

```http
GET /users
```

---

### Get User By ID

```http
GET /users/{id}
```

Example:

```http
GET /users/1
```

---

### Get User By Name

```http
GET /users/name/{name}
```

Example:

```http
GET /users/name/Dheeraj
```

---

### Get Users By City

```http
GET /users/city/{city}
```

Example:

```http
GET /users/city/Jaipur
```

---

### Get Users Older Than Age

```http
GET /users/age/{age}
```

Example:

```http
GET /users/age/20
```

---

### Update User

```http
PUT /users/{id}
```

Example:

```http
PUT /users/1
```

Request Body:

```json
{
  "name": "Dheeraj",
  "age": 23,
  "city": "Delhi"
}
```

---

### Delete User

```http
DELETE /users/{id}
```

Example:

```http
DELETE /users/1
```

---

## Pagination and Sorting

### Get Paginated Users

```http
GET /users/paginated?page=0&size=5
```

---

### Pagination with Sorting

```http
GET /users/paginated?page=0&size=5&sortBy=id&direction=asc
```

Example:

```http
GET /users/paginated?page=0&size=5&sortBy=age&direction=desc
```

Parameters:

| Parameter | Description                      |
| --------- | -------------------------------- |
| page      | Page number (starts from 0)      |
| size      | Number of records per page       |
| sortBy    | Field name (id, name, age, city) |
| direction | asc or desc                      |

---

## Validation Rules

### Name

* Cannot be blank

### Age

* Must be greater than 0

### City

* Cannot be blank

---

## Exception Handling

The project handles:

* Validation Errors (400)
* User Not Found Errors (404)
* Global Exceptions

Example Response:

```json
{
  "success": false,
  "message": "User not found",
  "data": null
}
```

---

## Swagger Documentation

After running the application:

```text
http://localhost:8080/swagger-ui/index.html
```

---

## Concepts Implemented

* REST APIs
* CRUD Operations
* Layered Architecture
* DTO Pattern
* Validation
* Spring Data JPA
* Repository Pattern
* Global Exception Handling
* Custom Exceptions
* API Documentation
* Pagination
* Sorting
* Stream API
* Response Standardization

---

## Future Improvements

* Service Interface + Implementation
* Authentication & Authorization
* JWT Security
* Password Encryption
* Role Based Access Control
* Deployment
* Unit Testing
* Docker

---

## Author

Dheeraj Bhambhu

Backend Development Learning Project built with Spring Boot.
