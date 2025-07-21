## 🌍 Country & Region Management System

A Spring Boot REST API project for managing **countries** and **regions** with PostgreSQL integration and custom exception handling.

---

### 🚀 Features

- CRUD operations for **Countries**
- CRUD operations for **Regions**
- Error handling using `@ControllerAdvice`
- PostgreSQL database integration with Hibernate (JPA)
- Validation for duplicate names and data not found
- Built with Spring Boot 3+

---

### 📁 Project Structure

```
com.example.county_curd
├── controller
│   ├── CountryController.java
│   └── RegionController.java
├── exceptions
│   └── GlobleExceptionHandler.java
├── model
│   ├── Country.java
│   ├── Region.java
│   └── ErorrReseponse.java
├── Repository
│   ├── CountryRepo.java
│   └── RegionRepo.java
├── service
│   ├── CountryService.java
│   └── RegionService.java
└── CountyCurdApplication.java
```

---

### 🛠️ Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok

---

### ⚙️ Configuration

Make sure you have PostgreSQL running and the database named `student` created.

Update `application.properties`:

```properties
server.port=9090
spring.application.name=county_curd

# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/student
spring.datasource.username=postgres
spring.datasource.password=1895
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 🔗 API Endpoints

#### Countries
| Method | Endpoint            | Description                  |
|--------|---------------------|------------------------------|
| GET    | `/countries`        | Get all countries            |
| GET    | `/countries/{id}`   | Get country by ID            |
| POST   | `/countries`        | Create a new country         |
| PUT    | `/countries/{id}`   | Update country by ID         |
| DELETE | `/countries/{id}`   | Delete country by ID         |

#### Regions
| Method | Endpoint           | Description                 |
|--------|--------------------|-----------------------------|
| GET    | `/regions`         | Get all regions             |
| GET    | `/regions/{id}`    | Get region by ID            |
| POST   | `/regions`         | Create a new region         |
| PUT    | `/regions/{id}`    | Update region name by ID    |
| DELETE | `/regions/{id}`    | Delete region by ID         |

---

### ❗ Custom Exceptions

- `DuplicateDataFoundException`
- `DataNotFoundException`
- `DatabaseEmptyException`

All exceptions are handled globally with meaningful error responses via `ErorrReseponse`.

---

### ▶️ How to Run

1. Clone the repo:
   ```bash
   git clone <your-repo-url>
   cd country-region-management
   ```

2. Run PostgreSQL and create the `student` database.

3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Test endpoints using Postman or Swagger.

---

### 📌 Note

- Ensure Lombok is installed in your IDE.
- Spring Boot DevTools is recommended for live reloads.

---

### 👨‍💻 Developed by

**Nikhil Vyavahare**
