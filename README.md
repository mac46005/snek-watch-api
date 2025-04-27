# 🐍 Snek Watch API

A RESTful API built with Spring Boot to monitor and manage your snake-watching activities on a private network.

---

## 🚀 Features

- ✅ Create, read, update, delete (CRUD) endpoints
- ✅ PostgreSQL integration
- ✅ JSON-based request/response
- ✅ Easily deployable as a `.jar` on any machine with Java

## 📦 Technologies Used

- Java 17+
- Spring Boot
- PostgreSQL
- Maven

## ⚙️ Setup & Installation

### 1. Cone the Repository

```bash
git clone https://github.com/your-username/snek-watch-api.git
cd snek-watch-api
```

### 2. Configure Application Properties

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/snekdb
spring.datasource.username=your_user
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=none
server.port=8080
```

### 3. Build the Project

```bash
./mvnw clean install
```

### 4. Run the Application

```bash
java -jar target/snek-watch-api-1.0.0.jar
```

## 📚 API Endpoints

## 📄 License

MIT License — do whatever you want, just don’t sue 😄
