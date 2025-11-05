# 🧭 Lost and Found Portal — Spring Boot Project

A **backend web application** built using **Spring Boot** and **Spring Data JPA** that allows users to post and browse lost and found items.  
The system uses **Single Table Inheritance** in Hibernate to manage both Lost and Found items efficiently within a single database table.

---

## 🎯 Project Objective

Every organization, college, or public place faces the issue of misplaced or found belongings.  
The **Lost and Found Portal** is designed to simplify this process by providing a platform where:

- A person who **loses** something can post item details.
- A person who **finds** something can record the found item.
- Others can **browse** through all posted items and find matches.

This is the **first version** of the project (v1), focused on **core CRUD functionality** for Lost and Found items.

---

## ⚙️ Tech Stack

| Layer | Technology Used |
|--------|------------------|
| Language | Java 21 |
| Framework | Spring Boot |
| Persistence Layer | Spring Data JPA (Hibernate ORM) |
| Database | MySQL |
| Build Tool | Maven |
| Logging | SLF4J + Logback |
| API Testing | Postman |

---

## 🧩 Core Functionalities (v1)

| Feature | Description |
|----------|--------------|
| ➕ Post Lost Item | Users can add an item they lost. |
| ➕ Post Found Item | Users can record an item they found. |
| 🔍 View All Items | Retrieve a combined list of all Lost and Found items. |
| Delete an Item from portal |
| Update an Item in portal |

This version is designed as the **foundation** on which future functionalities like **search**, **update status**, **pagination**, and **authentication** will be added.

---

## 🧱 Database Design

This project uses the **Single Table Inheritance** strategy.  
That means all Lost and Found items are stored in a **single table (`items`)**, with Hibernate automatically differentiating between them using a **discriminator column** (`item_type`).

### Table: `items`

| Column | Type | Description |
|---------|------|-------------|
| `id` | BIGINT | Primary key (auto-generated) |
| `item_name` | VARCHAR | Name of the item |
| `item_description` | VARCHAR | Description or details |
| `date` | DATE | Date when it was lost/found |
| `place` | VARCHAR | Location of loss/found |
| `contact_number` | VARCHAR | Contact number of user |
| `status` | ENUM | Item status (default: `PENDING`) |
| `created_time` | TIMESTAMP | Auto-set when created |
| `updated_time` | TIMESTAMP | Auto-set when updated |
| `item_type` | VARCHAR | Set automatically (`LOST` or `FOUND`) |
