# Task Manager - Java Console
A simple task management project built in Java, running on the console.

## 🚀 Features

- Create task
- List tasks
- Update title
- Update status
- Delete task

## 🧠 Concepts applied

- Object-Oriented Programming (OOP)
- Separation of concerns (Service / DAO / Application)
- Enum for status control
- Input validation
- Full CRUD
- MySQL databsae integration with JDBC
- DAO pattern (Data Access Object)

## 🛠 Tech stack

- Java
- MySQL
- JDBC
- Git
- GitHub

## ▶️ How to run

### Requirements

- Java JDK installed
- MySQL server running locally
- A Java IDE (Eclipse, IntelliJ or VS Code)
- MySQL Connector/J driver (`.jar`) added to the project classpath

### Database setup

1. Open your MySQL client and run:

```sql
CREATE DATABASE task_manager;
USE task_manager;

CREATE TABLE tasks (
    id     INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title  VARCHAR(255) NOT NULL,
    status ENUM('NOT_STARTED', 'PENDING', 'COMPLETED') NOT NULL DEFAULT 'NOT_STARTED'
);
```

2. Open `src/db/Connector.java` and set your MySQL credentials:

```java
private static final String URL      = "jdbc:mysql://localhost:3306/task_manager";
private static final String USER     = "root";
private static final String PASSWORD = "your_password_here";
```

### Steps

1. Clone the repository

```bash
git clone https://github.com/LucasEdu-Santos/task-manager-java-console.git
```

2. Open the project in your IDE

3. Add the MySQL Connector/J `.jar` to the project classpath

4. Set up the database following steps above

5. Run the `Program.java` class

6. Use the console menu to manage your tasks

## 📌 Future improvements

- REST API with Spring Boot
- Graphical user interface