
# Smart Expense Tracker API

A REST API built with Java 17 and Spring Boot for managing personal expenses.

## Features

* Add an expense
* View all expenses
* Filter expenses by category
* Calculate total expenses
* Calculate total expenses by category
* Delete an expense
* In-memory data storage

## Technologies Used

* Java 17
* Spring Boot
* Maven
* REST API

## API Endpoints

| Method | Endpoint                            | Description              |
| ------ | ----------------------------------- | ------------------------ |
| POST   | `/api/expenses`                     | Add a new expense        |
| GET    | `/api/expenses`                     | View all expenses        |
| GET    | `/api/expenses?category=Food`       | Filter by category       |
| GET    | `/api/expenses/total`               | Calculate total expenses |
| GET    | `/api/expenses/total?category=Food` | Calculate category total |
| DELETE | `/api/expenses/{id}`                | Delete an expense        |

## How to Run

Make sure Java 17 is installed.

Open the IntelliJ Terminal in the project folder and run:

```bash
mvn clean compile
```

Then run:

```bash
mvn spring-boot:run
```

The application will run at:

`http://localhost:8080`

## Example Expense

```json
{
  "title": "Lunch",
  "amount": 250,
  "category": "Food",
  "date": "2026-08-01"
}
```

## Data Storage

The application uses in-memory storage. Expense data will be reset when the application is restarted.

## Project Structure

```text
smart-expense-tracker
├── src
├── pom.xml
├── README.md
├── AI_NOTES.md
└── .gitignore
```

## Author

Sandhiya
