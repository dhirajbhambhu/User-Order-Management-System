# User-Order Management System

A production-ready REST API for managing users and orders, built with Spring Boot. Features JWT-based authentication, role-based access control, layered architecture, and full Swagger UI documentation.

---

## 🛠 Tech Stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

---

## ✨ Features

- JWT authentication with secure token generation and validation
- Role-based access control (Admin / User)
- Full CRUD for users and orders
- Pagination and sorting on list endpoints
- DTO pattern for clean request/response separation
- Global exception handling with meaningful error responses
- Swagger UI for interactive API documentation
- Layered architecture — Controller → Service → Repository

---

## 📁 Project Structure

src/main/java/com/dheeraj/usermanagement/

├── config/

│   ├── JwtAuthenticationFilter.java

│   ├── OpenApiConfig.java

│   ├── SecurityConfig.java

│   └── SwaggerConfig.java

├── controller/

│   ├── AuthController.java

│   ├── HomeController.java

│   ├── OrderController.java

│   └── UserController.java

├── dto/

│   ├── LoginRequestDto.java

│   ├── LoginResponseDto.java

│   ├── OrderRequestDto.java

│   ├── OrderResponseDto.java

│   ├── RegisterRequestDto.java

│   ├── RegisterResponseDto.java

│   ├── UserRequestDto.java

│   └── UserResponseDto.java

├── exception/

│   ├── GlobalExceptionHandler.java

│   ├── InvalidCredentialsException.java

│   └── UserNotFoundException.java

├── model/

│   ├── Orders.java

│   └── User.java

├── repository/

│   ├── OrderRepository.java

│   └── UserRepository.java

├── response/

│   └── ApiResponse.java

├── service/

│   ├── AuthService.java

│   ├── JwtService.java

│   ├── OrderService.java

│   └── UserService.java

└── StartApplication.java

---

## 📋 API Endpoints

### Auth
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/auth/register` | Register a new user | No |
| POST | `/auth/login` | Login and get JWT token | No |

### Users
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | '/users | Get all users (paginated) | Yes |
| GET | `/users/{id}` | Get user by ID | Yes |
| PUT | `/users/{id}` | Update user | Yes |
| DELETE | `/users/{id}` | Delete user | Yes |

### Orders
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/users/orders` | Create a new order | Yes |
| GET | `/users/orders` | Get all orders (paginated) | Yes |
| GET | `/users/orders/{id}` | Get order by ID | Yes |
| PUT | `/users/orders/{id}` | Update order | Yes |
| DELETE | `/users/orders/{id}` | Delete order | Yes |

---

## ⚙️ How to Run Locally

### Prerequisites
- Java 17+
- MySQL running locally
- Maven

### Steps

1. **Clone the repo**
```bash
git clone https://github.com/dhirajbhambhu/User-Order-Management-System.git
cd User-Order-Management-System
```

2. **Create the database**
```sql
CREATE DATABASE usermanagement;
```

3. **Configure `application.properties`**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/usermanagement
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update

app.jwt.secret=your_jwt_secret_key
app.jwt.expiration=86400000
```

4. **Run the application**
```bash
mvn spring-boot:run
```

5. **Open Swagger UI**

http://localhost:8080/swagger-ui.html

---

## 🔐 Authentication Flow

1. Register via `POST /api/auth/register`
2. Login via `POST /api/auth/login` → receive JWT token
3. Add token to all protected requests:
Authorization: Bearer <your_token>
---

## 📬 Contact

**Dhiraj Bhambhu**
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=flat&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/dhiraj-bhambhu/)
[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=flat&logo=gmail&logoColor=white)](mailto:dhirajbhambhu18@gmail.com)

