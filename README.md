# **Nimap Task**

This project is a Java-based backend application developed as part of a recruitment process for Nimap Infotech. It is built using Spring Boot and focuses on creating and managing categories and products with a one-to-many relationship. The project adheres to best practices in REST API development, leveraging JPA, Hibernate, and server-side pagination.

---

## **Index**

- [Features](#features)  
- [Technologies Used](#technologies-used)  
- [API Documentation](#api-documentation)  
  - [Base URL](#base-url)  
  - [Category APIs](#category-apis)  
  - [Product APIs](#product-apis)  
- [Getting Started](#getting-started)  
  - [Prerequisites](#prerequisites)  
  - [Steps to Run](#steps-to-run)  
- [Project Structure](#project-structure)  
- [Contributing](#contributing)  
- [License](#license)  

---

## **Features**

1. **Category Management**:
   - Create, read, update, and delete (CRUD) categories.
   - API endpoints for managing category operations.

2. **Product Management**:
   - CRUD operations for products.
   - Association with categories (one-to-many relationship).

3. **One-to-Many Relationship**:
   - A single category can have multiple associated products.
   - While fetching product details, the corresponding category details are included.

4. **Server-Side Pagination**:
   - Implemented pagination for fetching large datasets of categories and products.

5. **Database Configuration**:
   - RDBMS (e.g., MySQL) integration with Spring Data JPA.
   - Annotation-based configuration (no XML).

---

## **Technologies Used**

- **Backend Framework**: Spring Boot  
- **Database**: MySQL  
- **ORM**: JPA and Hibernate  
- **Build Tool**: Maven  
- **Java Version**: Java 17+   

---

## **API Documentation**

### **Base URL**  
```
http://localhost:8080
```

### **Category APIs**
| Method | Endpoint                        | Description                  |
|--------|---------------------------------|------------------------------|
| GET    | `/api/categories?page={page}`   | Retrieve all categories      |
| POST   | `/api/categories`               | Create a new category        |
| GET    | `/api/categories/{id}`          | Retrieve a category by ID    |
| PUT    | `/api/categories/{id}`          | Update a category by ID      |
| DELETE | `/api/categories/{id}`          | Delete a category by ID      |

---

### **Product APIs**
| Method | Endpoint                        | Description                  |
|--------|---------------------------------|------------------------------|
| GET    | `/api/products?page={page}`     | Retrieve all products        |
| POST   | `/api/products`                 | Create a new product         |
| GET    | `/api/products/{id}`            | Retrieve a product by ID     |
| PUT    | `/api/products/{id}`            | Update a product by ID       |
| DELETE | `/api/products/{id}`            | Delete a product by ID       |
---

## **Getting Started**

### **Prerequisites**
- Install Java 17 or higher.  
- Install MySQL and create a database.  
- Set up Maven.

### **Steps to Run**  
1. Clone the repository:  
   ```bash
   git clone https://github.com/HARDIK-PANCHARIYA/Nimap-Task.git
   ```  
2. Navigate to the project directory:  
   ```bash
   cd Nimap-Task
   ```  
3. Configure database credentials in `application.properties`:  
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```  
4. Run the project:  
   ```bash
   mvn spring-boot:run
   ```  
5. Access the API:  
   - API Endpoints: `http://localhost:8080`  
---

## **Project Structure**

```plaintext
src/
├── main/
│   ├── java/
│   │   └── com.core/
│   │       ├── controller/  # REST controllers for APIs
│   │       ├── service/     # Business logic
│   │       ├── repository/  # Data persistence layer
│   │       ├── model/       # Entity classes
│   │       └── exception/   # Centralized exception handling
│   └── resources/
│       ├── application.properties  # Configuration file
│       └── schema.sql              # Database schema
```
----