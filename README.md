# Smart Expense Tracker API

A REST API built with Java 17 and Spring Boot for managing personal expenses.

## API Features
- **Add Expense:** `POST /api/expenses`
- **List All Expenses:** `GET /api/expenses`
- **Filter by Category:** `GET /api/expenses?category=Food`
- **Calculate Total:** `GET /api/expenses/total` (Optional: `?category=Food`)
- **Delete Expense:** `DELETE /api/expenses/{id}`

---

## Installation Commands

```bash
mvn clean compile