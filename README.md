
# 🛒 E-Commerce Management System (Spring Boot)

## 📡 API Documentation (CRUD with Request & Response)

Base URL: `http://localhost:8080/api`

---

## 👤 USERS

### ➕ Create User
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

### 📄 Get All Users
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

### ✏️ Update User
**PUT** `/users/1`
Request:
```json
{
  "name": "John Updated",
  "email": "john@gmail.com"
}
```
Response:
```json
{
  "id": 1,
  "name": "John Updated",
  "email": "john@gmail.com"
}
```

### ❌ Delete User
**DELETE** `/users/1`
Response:
```json
{
  "message": "User deleted successfully"
}
```

---

## 🗂️ CATEGORY

### ➕ Create Category
**POST** `/categories/add`
```json
{
  "name": "Electronics",
  "description": "Electronic Items"
}
```

### 📄 Get Categories
**GET** `/categories`

### ✏️ Update Category
**PUT** `/categories/1`
```json
{
  "name": "Mobiles",
  "description": "Mobile Devices"
}
```

### ❌ Delete Category
**DELETE** `/categories/1`

---

## 📦 PRODUCT

### ➕ Create Product
**POST** `/products/add`
```json
{
  "name": "iPhone",
  "price": 80000,
  "stockQuantity": 10,
  "categoryId": 1
}
```

### 📄 Get Products
**GET** `/products`

### ✏️ Update Product
**PUT** `/products/1`
```json
{
  "name": "iPhone 15",
  "price": 90000
}
```

### ❌ Delete Product
**DELETE** `/products/1`

---

## 🛒 CART

### ➕ Add to Cart
**POST** `/cart/add`
```json
{
  "userId": 1,
  "productId": 1,
  "quantity": 2
}
```

### 📄 Get Cart
**GET** `/cart`

### ✏️ Update Cart
**PUT** `/cart/1`
```json
{
  "quantity": 3
}
```

### ❌ Delete Cart Item
**DELETE** `/cart/1`

---

## 📦 ORDERS

### ➕ Place Order
**POST** `/orders/addorder`
```json
{
  "userId": 1,
  "productId": 1,
  "quantity": 2
}
```

### 📄 Get Orders
**GET** `/orders`

### ✏️ Update Order
**PUT** `/orders/1`
```json
{
  "orderStatus": "DELIVERED"
}
```

### ❌ Delete Order
**DELETE** `/orders/1`

---

## ⭐ REVIEW

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

### 📄 Get Reviews
**GET** `/reviews`

### ✏️ Update Review
**PUT** `/reviews/1`
```json
{
  "rating": 4,
  "comment": "Good product"
}
```

### ❌ Delete Review
**DELETE** `/reviews/1`

---

## 🚚 ORDER TRACKING

### ➕ Add Tracking
**POST** `/order-tracking`
```json
{
  "orderGroupId": "ORD123",
  "status": "Shipped",
  "location": "Chennai"
}
```

### 📄 Get Tracking
**GET** `/order-tracking`

### ✏️ Update Tracking
**PUT** `/order-tracking/1`
```json
{
  "status": "Delivered"
}
```

### ❌ Delete Tracking
**DELETE** `/order-tracking/1`

---

## 🧪 Testing Tools
- Postman
- Thunder Client

---

Author: **Ezhilsree J**
