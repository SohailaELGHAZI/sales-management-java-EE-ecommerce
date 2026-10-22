# Sales Management System – Enterprise Java E-commerce

A full-stack **Java EE** e-commerce platform built with the **MVC architecture (Struts 2)** and **Hibernate ORM**. It manages online sales, inventory and customer accounts, and generates **automated PDF invoices**.

> 🎓 **Academic project (2022)**: built in 1 month by a team of 2 · Status: ✅ Completed

## 🎬 Video Demo

[![Watch the demo](https://img.youtube.com/vi/Qz7FYhhLFk4/maxresdefault.jpg)](https://www.youtube.com/watch?v=Qz7FYhhLFk4)

🌐 [Project page in my portfolio](https://sohailaelghazi.vercel.app/projects/p5r4v6x2)

---

## 📖 The Story

### The Problem
Products, customer orders, inventory and invoicing all need to work together in one connected workflow. This project explores how an e-commerce application can centralize these operations while offering a complete online shopping experience.

### The Solution
A full-stack Java EE application using Struts 2 MVC and Hibernate ORM. Customers browse products, manage their cart, check out in several steps, and get a PDF invoice. Stock updates automatically with each order.

---

## ✨ Key Features

- 🔐 **User registration & authentication**
- 🛍️ **Dynamic product catalog** with pagination
- 🛒 **Shopping cart management**: add, update and remove items
- 💳 **Multi-step checkout**: order → payment → confirmation
- 👤 **Profile dashboard**: view and edit profile, profile picture
- 📦 **Real-time stock control**: inventory updated on each order
- 🧾 **Automated PDF invoices**
- 📱 **Responsive UI**

---

## 🛠️ Tech Stack

| Technology | Usage |
|---|---|
| Java EE (Servlets / JSP) | Core platform & views |
| Struts 2 | MVC framework (actions & routing) |
| Hibernate | ORM & data access |
| MySQL | Database |
| Bootstrap | Responsive UI |
| jQuery | Front-end interactions |
| Apache Tomcat | Application server |

---

## 🏗️ Architecture

```
Browser (JSP + Bootstrap + jQuery)
        │
        ▼
Struts 2 Actions  (user / Articles / commandes)
        │
        ▼
DAO layer  (UsersHome, CommandesHome, ArticlesPrixHome, ArticlesStockHome)
        │
        ▼
Hibernate ORM  (*.hbm.xml mappings)
        │
        ▼
MySQL
```

## 📁 Project Structure

```
src/main/
├── java/
│   ├── action/        # HibernateUtil (session factory)
│   ├── Articles/      # Product catalog actions
│   ├── commandes/     # Cart, order, payment actions
│   ├── dao/           # Data access objects
│   ├── mapping/       # Hibernate mapping files (.hbm.xml)
│   ├── models/        # Entities: Users, Commandes, ArticlesPrix, ArticlesStock
│   ├── user/          # Login, sign up, profile actions
│   ├── struts.xml     # Struts 2 configuration
│   └── hibernate_*.cfg.xml
└── webapp/
    ├── *.jsp          # Pages: home, login, cart, payment, invoice, profile
    ├── css/  js/  img/
    └── WEB-INF/       # web.xml & libraries
```

---

## 🚀 Getting Started

### Prerequisites
- JDK 8+
- Apache Tomcat 9
- MySQL
- Eclipse IDE for Enterprise Java (recommended)

### Run
1. Clone the repository:
   ```bash
   git clone https://github.com/SohailaELGHAZI/sales-management-java-ee-ecommerce.git
   ```
2. Import into Eclipse: **File → Import → Existing Projects into Workspace**.
3. Create the MySQL database and update the connection settings in `hibernate_v.cfg.xml` and `hibernate_stock.cfg.xml`.
4. Add the project to a Tomcat server and run it.
5. Open `http://localhost:8080/sales-management/`

---

## 👩‍💻 Author

**Sohaila EL GHAZI**: Full-Stack Developer

- 🌐 Portfolio: [sohailaelghazi.vercel.app](https://sohailaelghazi.vercel.app/)
- 💼 LinkedIn: [sohaila-el-ghazi](https://www.linkedin.com/in/sohaila-el-ghazi)
- 🐙 GitHub: [SohailaELGHAZI](https://github.com/SohailaELGHAZI)

*Academic project completed in 2022, in a team of 2.*
