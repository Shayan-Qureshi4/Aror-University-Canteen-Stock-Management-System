# Aror University Canteen Stock Management System

A desktop-based Inventory stock and sales management system developed for **Aror University Canteen**.  
The system helps manage products, monitor stock levels, handle daily sales, and support staff operations through a simple and user-friendly interface.

---

## 📌 Project Overview

This project is designed to digitize and simplify canteen operations by providing:
- Centralized stock management
- Role-based access (Manager & Staff)
- Real-time stock updates after sales
- Low-stock alerts
- Sales tracking
- Receipt generation
- QR-based payment display (UI-level)

The application is built using **Java Swing** with **MySQL** as the backend database and follows a clean separation of UI, services, models, and database layers.

---

## 🛠️ Technologies Used

- **Java (JDK 8 or above)**
- **Java Swing (GUI)**
- **MySQL**
- **JDBC**
- **Apache NetBeans IDE**

---

## 👥 User Roles

### Manager
- Login access
- View all products
- Monitor stock and low-stock items
- View total sales
- Manage inventory (via database/service layer)

### Staff
- Login access
- View available stock
- Sell products
- Search products by name
- View daily KPIs
- Print sale receipt
- Display QR code for payment

---

## 🔐 Default Login Credentials

| Role    | Username        | Password |
|-------- |----------------|----------|
| Manager | manager@aror   | 0987     |
| Staff   | staff@aror     | 1234     |

---

## 🗂️ Project Structure



## 🗂️ Project Structure
ui/

│ ├── LoginFrame.java

│ ├── ManagerDashboard.java

│ └── StaffDashboard.java

│

├── services/

│ └── ProductService.java

│

├── database/

│ └── DBConnection.java

│

└── models/

└── Product.java


---


## 🧩 Key Features

### ✔ Login System
- Role-based authentication  
- Redirects to respective dashboards  

### ✔ Dashboard KPIs
- Total products  
- Low stock count  
- Total sales  

### ✔ Stock Management
- View all products in tabular form  
- Real-time updates after selling  

### ✔ Product Selling
- Select product and quantity  
- Automatic stock reduction  
- Sale recorded in database  

### ✔ Search Functionality
- Search products by name  
- Instant filtered results  

### ✔ Receipt Generation
- Displays last sold product receipt  

### ✔ QR Code Payment
- Displays QR code for online payment option  

---

## 🗄️ Database Details

- Database: **canteen_stock**
- Tables include:
  - `products`
  - `sales_history`
- SQL file provided to initialize schema and sample data

---

## ▶️ How to Run the Project

### Step 1: Install Requirements
- Install **JDK 8 or later**
- Install **MySQL Server**
- Install **Apache NetBeans IDE**

---

### Step 2: Setup Database
1. Open **MySQL** (phpMyAdmin or MySQL Workbench)
2. Create a database:
   ```sql
   CREATE DATABASE canteen_stock;
   Import the provided file: canteen_stock.sql
   
---

### Step 3: Configure Database Connection
1. Open DBConnection.java and ensure the credentials match your MySQL setup:

private static final String URL = "jdbc:mysql://localhost:3306/canteen_stock";

private static final String USER = "root";

private static final String PASSWORD = "";

---

### Step 4: Open Project in NetBeans
Open NetBeans

Click File → Open Project

Select the project folder

Ensure MySQL JDBC driver is added to Libraries

---

### Step 5: Run the Application

Run LoginFrame.java

Login using Manager or Staff credentials

---

## 📈 Future Enhancements

- User registration system  
- Proper receipt printing (PDF)  
- Barcode scanning support  
- Role-based permissions via database  
- Cloud database integration  

---

## 👨‍💻 Author

**Shayan Qureshi**  
Software & AI Enthusiast

BS Artificial Intelligence – Semester 4 

https://github.com/Shayan-Qureshi4

---

## 📄 License

This project is developed for **educational purposes** and academic learning.

