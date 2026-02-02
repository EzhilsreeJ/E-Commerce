# 🛒 E-Commerce Management System (Spring Boot)

This is a backend **E-Commerce Management System** built using **Spring Boot**, **Spring Data JPA**, and **MySQL**.  
It provides REST APIs to manage users, categories, products, cart, orders, reviews, and order tracking.

---

## 🚀 Features

- User Management  
- Category Management (with parent-child categories)  
- Product Management  
- Cart Management  
- Order Management  
- Review Management  
- Order Tracking  
- CRUD Operations (Create, Read, Update, Delete)  
- RESTful APIs  
- MySQL Database Integration  

---

## 🏗️ Tech Stack

- Java  
- Spring Boot  
- Spring Data JPA (Hibernate)  
- MySQL  
- Maven  
- Lombok  
- Git & GitHub  

---

## 📂 Project Structure

```
com.example
 ├── Controller
 ├── Model
 ├── Repository
 └── Service
```

---

## 🗂️ ER Diagram

> 📌 **Place your ER Diagram image here** (e.g., `er-diagram.png`)

Example:

<img width="625" height="878" alt="image" src="https://github.com/user-attachments/assets/27e740e1-424d-4703-a821-35e0cea9dfcf" />

---

## ⚙️ Database Schema

Database Name: `ecommerncedb`

Tables:
- users  
- category  
- product  
- cart  
- orders  
- review  
- order_tracking  

Relationships:
- Product → Category  
- Cart → Users, Product  
- Orders → Users, Product  
- Review → Users, Product, Orders  
- Category → Category (self reference)

---

## 🗄️ SQL Script

```sql
CREATE DATABASE ecommerncedb;
USE ecommerncedb;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    parent_id BIGINT,
    FOREIGN KEY (parent_id) REFERENCES category(id)
);

CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    price DECIMAL(10,2) NOT NULL,
    stock_quantity INT NOT NULL,
    brand VARCHAR(100),
    sku VARCHAR(100) UNIQUE,
    rating_avg DOUBLE DEFAULT 0,
    rating_count INT DEFAULT 0,
    is_active BOOLEAN DEFAULT TRUE,
    category_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE cart (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    price_at_added DECIMAL(10,2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    UNIQUE (user_id, product_id)
);

CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_group_id VARCHAR(50) NOT NULL,
    user_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    order_status VARCHAR(50) DEFAULT 'PLACED',
    is_reviewed BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE order_tracking (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_group_id VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    description VARCHAR(255),
    location VARCHAR(100),
    updated_by VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE review (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    order_id BIGINT NOT NULL,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comment TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (order_id) REFERENCES orders(id),
    UNIQUE (user_id, order_id)
);
```

---

## ⚙️ Configuration

Update your `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerncedb
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

---

# ⚠️ Exception Handling

This project uses **custom exceptions** and a **Global Exception Handler** to provide meaningful error responses in JSON format.

All exceptions are handled centrally using `@RestControllerAdvice`.

---

## 📁 Exception Structure

```
com.example.demo
 ├── Exception
 │     └── GlobalExceptionHandler.java
 └── Handler
       ├── ResourceNotFoundException.java
       ├── BadRequestException.java
       ├── DuplicateResourceException.java
       └── ErrorResponse.java
```

---

## 🧩 Custom Exceptions

### 1. ResourceNotFoundException  
Thrown when a requested resource is not found in the database.

```java
throw new ResourceNotFoundException("Product not found with id: " + id);
```

Used for:
- User not found  
- Product not found  
- Category not found  
- Order not found  
- Cart item not found  
- Review not found  
- Order tracking not found  

---

### 2. BadRequestException  
Thrown when the request data is invalid or violates business rules.

```java
throw new BadRequestException("Quantity must be greater than 0");
```

Used for:
- Quantity ≤ 0  
- Invalid order operation  
- Invalid rating value  
- Invalid status  
- Wrong input data  

---

### 3. DuplicateResourceException  
Thrown when duplicate data is inserted that violates uniqueness.

```java
throw new DuplicateResourceException("Email already exists");
```

Used for:
- Duplicate email  
- Duplicate SKU  
- Duplicate cart item  
- Duplicate review  

---

## 📦 ErrorResponse Model

All exceptions return a standard JSON structure:

```json
{
  "timestamp": "2026-02-02T12:30:20",
  "status": 404,
  "error": "NOT FOUND",
  "message": "Product not found with id: 10",
  "path": "/api/products/10"
}
```

Fields:
- `timestamp` – Time of error  
- `status` – HTTP status code  
- `error` – Error type  
- `message` – Detailed message  
- `path` – API endpoint  

---

## 🌐 GlobalExceptionHandler

The `GlobalExceptionHandler` handles all exceptions using `@RestControllerAdvice`.

Handled exceptions:

| Exception Type | HTTP Status | Meaning |
|----------------|-------------|---------|
| ResourceNotFoundException | 404 | Resource not found |
| BadRequestException | 400 | Invalid request |
| DuplicateResourceException | 409 | Duplicate data |
| MethodArgumentNotValidException | 400 | Validation error |
| DataIntegrityViolationException | 400 | Database constraint error |
| Exception (generic) | 500 | Server error |

---

## 🧠 Where Exceptions Are Thrown

Exceptions are thrown in the **Service layer**.

Example (CartService):

```java
if (cart.getQuantity() <= 0) {
    throw new BadRequestException("Quantity must be greater than 0");
}
```

Example (ProductService):

```java
productRepository.findById(id)
    .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
```

---

## ✅ Benefits

- Clean API responses  
- Centralized error handling  
- Easy debugging  
- Better client-side handling  
- Production-ready design  
---

## ▶️ How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/EzhilsreeJ/E-Commerce.git
   ```

2. Open the project in IDE (IntelliJ / Eclipse / VS Code)

3. Create database:
   ```sql
   CREATE DATABASE ecommerncedb;
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
   OR run `EcommerceApplication.java`

---

## 📡 API Endpoints (Sample)

### Users
- `POST /api/users/add`  
- `GET /api/users`  
- `GET /api/users/{id}`  
- `PUT /api/users/{id}`  
- `DELETE /api/users/{id}`  

### Categories
- `POST /api/categories/add`  
- `GET /api/categories`  
- `GET /api/categories/{id}`  
- `PUT /api/categories/{id}`  
- `DELETE /api/categories/{id}`  

### Products
- `POST /api/products/add`  
- `GET /api/products`  
- `GET /api/products/{id}`  
- `PUT /api/products/{id}`  
- `DELETE /api/products/{id}`  

### Cart
- `POST /api/cart/add`  
- `GET /api/cart`  
- `GET /api/cart/{id}`  
- `PUT /api/cart/{id}`  
- `DELETE /api/cart/{id}`  

### Orders
- `POST /api/orders/addorder`  
- `GET /api/orders`  
- `GET /api/orders/{id}`  
- `PUT /api/orders/{id}`  
- `DELETE /api/orders/{id}`  

### Reviews
- `POST /api/reviews`  
- `GET /api/reviews`  
- `GET /api/reviews/{id}`  
- `PUT /api/reviews/{id}`  
- `DELETE /api/reviews/{id}`  

### Order Tracking
- `POST /api/order-tracking`  
- `GET /api/order-tracking`  
- `GET /api/order-tracking/{id}`  
- `PUT /api/order-tracking/{id}`  
- `DELETE /api/order-tracking/{id}`  

---

## 🧪 Testing

You can test APIs using:
- Postman  
- Thunder Client  

All responses are in JSON format.

---

## 🔐 Future Enhancements

- Spring Security + JWT Authentication  
- Role-based access (Admin/User)  
- Pagination & Sorting  
- Global Exception Handling  
- DTO Mapping  
- Frontend Integration (React)

---

## 👨‍💻 Author

**Ezhilsree J**  
GitHub: https://github.com/EzhilsreeJ  

---

## 📜 License

This project is for learning and educational purposes only.
