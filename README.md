
# 🛒 E-Commerce Management System (Spring Boot)

This is a backend E-Commerce Management System built using Spring Boot, Spring Data JPA, and MySQL.
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
- CRUD Operations  
- RESTful APIs  
- MySQL Database Integration  

---

## 🏗️ Tech Stack
Java, Spring Boot, Spring Data JPA (Hibernate), MySQL, Maven, Lombok, Git & GitHub

---

## ⚙️ Database
Database Name: `ecommerncedb`

---

# 🌐 API Documentation

Base URL: `http://localhost:8080/api`

---

## 👤 Users API

### ➕ Add User
**POST** `/users/add`  
Request:
```json
{
  "name": "John",
  "email": "john@gmail.com",
  "password": "12345"
}
```
Response:
```json
{
  "id": 1,
  "name": "John",
  "email": "john@gmail.com"
}
```

### 📥 Get All Users
**GET** `/users`
Response:
```json
[
  {
    "id": 1,
    "name": "John",
    "email": "john@gmail.com"
  }
]
```

---

## 🗂️ Categories API

### ➕ Add Category
**POST** `/categories/add`
```json
{
  "name": "Electronics",
  "description": "Devices",
  "parentId": null
}
```

### 📥 Get Categories
**GET** `/categories`
```json
[
  {
    "id": 1,
    "name": "Electronics",
    "description": "Devices"
  }
]
```

---

## 📦 Products API

### ➕ Add Product
**POST** `/products/add`
```json
{
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 60000,
  "stockQuantity": 10,
  "brand": "HP",
  "sku": "HP123",
  "categoryId": 1
}
```

### 📥 Get Products
**GET** `/products`
```json
[
  {
    "id": 1,
    "name": "Laptop",
    "price": 60000,
    "stockQuantity": 10
  }
]
```

---

## 🛒 Cart API

### ➕ Add to Cart
**POST** `/cart/add`
```json
{
  "userId": 1,
  "productId": 1,
  "quantity": 2
}
```

Response:
```json
{
  "id": 1,
  "quantity": 2,
  "priceAtAdded": 120000
}
```

---

## 🧾 Orders API

### ➕ Place Order
**POST** `/orders/addorder`
```json
{
  "userId": 1,
  "productId": 1,
  "quantity": 2
}
```

Response:
```json
{
  "orderGroupId": "ORD123",
  "status": "PLACED"
}
```

---

## ⭐ Reviews API

### ➕ Add Review
**POST** `/reviews`
```json
{
  "userId": 1,
  "productId": 1,
  "orderId": 1,
  "rating": 5,
  "comment": "Excellent product"
}
```

---

## 🚚 Order Tracking API

### ➕ Add Tracking
**POST** `/order-tracking`
```json
{
  "orderGroupId": "ORD123",
  "status": "SHIPPED",
  "location": "Chennai"
}
```

---

## ⚠️ Error Response Format
```json
{
  "timestamp": "2026-02-02T12:30:20",
  "status": 404,
  "error": "NOT FOUND",
  "message": "Product not found",
  "path": "/api/products/10"
}
```

---

## ▶️ Run Project
```bash
git clone https://github.com/EzhilsreeJ/E-Commerce.git
mvn spring-boot:run
```

---

## 👨‍💻 Author
Ezhilsree J  
GitHub: https://github.com/EzhilsreeJ
