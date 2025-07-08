# Online Book Store

A Java-based online book store application. Users can browse books, register, login, purchase paper and e-books, and admins can manage inventory, pricing, and stock.

## 📸 Demo

![Demo Screenshot](./demo.png)

## 🚀 Features

- User registration & authentication
- Admin panel for adding/removing books, updating quantity & price
- Browse and view available books
- Purchase:
  - Paper books (check stock, ship to address)
  - E-books (send via email)
- Automatic pricing and quantity handling
- Remove outdated inventory

## 🧩 Architecture

- `Book` (abstract class):
  - `PaperBook`, `EBook`, `ShowcaseBook` extend it with custom purchase logic
- `QuantumBookstore`: main store handling inventory, purchases, removals
- Clean OOP design following SOLID principles

## 🛠️ Prerequisites

- Java 8+
- Maven or Gradle (whichever you're using)
- JUnit 5 for testing

## 📁 Project Structure
```
online-book-store-Task/
/BookStore/src
├── Main/
│       └── 
│           ├── Book.java
│           ├── PaperBook.java
│           ├── EBook.java
│           ├── ShowcaseBook.java
│           └── QuantumBookstore.java
|           └── Main.java
└── test/
        └── 
            ├── PaperBookTest.java
            ├── EBookTest.java
            ├── ShowcaseBookTest.java
            └── QuantumBookstoreTest.java
```
