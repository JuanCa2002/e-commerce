
# 🛒 E-commerce Nexsys (Platzy Fake Api)

This is a technical test for Nexsys, where I developed an e-commerce platform using a mock API from Platzi.

<p align="center">
  <img src="https://github.com/user-attachments/assets/8ff352c8-2040-4725-8629-c446b633f8b9"/>
</p>

## 🏅 Badges

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-007396?logo=java">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.3.4-brightgreen?logo=spring-boot">
  <img src="https://img.shields.io/badge/Maven-4.0.0-blue?logo=apache-maven">
  <img src="https://img.shields.io/badge/Lombok-optional-brightgreen?logo=lombok">
  <img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white">
</p>


## 📚 Appendix

* [Title and Cover Image](#-e-commerce-nexsys-platzy-fake-api)

* [Badges](#badges)

* [Appendix](#-appendix)

* [Features](#-features)

* [Installation](#-installation)

* [API Reference](#-api-reference)


## ✨ Features

- Java 17
- Spring Boot 3.3.4
- MapStruct for mapping DTOs
- Lombok for reducing boilerplate code
- OpenFeign for REST client communication
- Swagger and OpenAPI for API documentation

## 🔧 Installation

To get started with this e-commerce platform, follow the steps below:

### Prerequisites

- Java 17 or higher
- Maven 4.0.0 or higher
- Git installed on your machine

### Steps

1. **Clone the repository:**
   
   First, clone the project repository to your local machine:

   ```bash
   git clone https://github.com/JuanCa2002/e-commerce.git
   ```

2. **Navigate to the project directory:**

    Once cloned, navigate to the project's root directory:

    ```bash
    cd e-commerce
    ```

3. **Build the project using Maven:**

    Build the project to download dependencies and compile the code:

    ```bash
    mvn clean install
    ```

4. **Run the Spring Boot application**

    After building the project, you can run the application using the Spring Boot Maven plugin:

    ```bash
    mvn spring-boot:run
    ```

5. **Access the application:**

    The application should now be running. By default, you can access it at:

    ```bash
    http://localhost:2208
    ```


    
# 📄 API Reference

## 📦 Product

#### 🔵 Get All Products

```http
  GET /nexsys/v1/products
```
**Params: None**

**Response [JSON]**

```json
[
  {
    "pid": 4,
    "name": "Tablet",
    "priceFinal": 599,
    "description": "A new tablet with high performance"
  }
  ...
]
```
 
#### 🟠 Create Product

```http
  POST /nexsys/v1/products
```
**Request Body [JSON]**

```json
{
  "name": "Tablet",
  "priceFinal": 599,
  "description": "A new tablet with high performance",
  "categoryId": 1,
  "imageUrl":"https://placeimg.com/640/480/any?r=0.9178516507833767"
}
```

**Response [JSON]**

```json
{
  "pid": 28
}
```

## 🏷️ Category

#### 🔵 Get All Categories

```http
  GET /nexsys/v1/categories
```
**Params: None**

**Response [JSON]**

```json
[
  {
    "cid": 4,
    "title": "Electronics"
  }
  ...
]
