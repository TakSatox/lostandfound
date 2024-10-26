# Lost and Found API

This project is a Spring Boot application for managing lost and found items. It provides a RESTful API to create, read, update, and delete items.

## Table of Contents

- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Configuration](#configuration)
- [Building and Running](#building-and-running)
- [License](#license)

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6.3 or higher
- PostgreSQL

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/TakSatox/lostandfound.git
    cd lostandfound
    ```

2. Install the dependencies:
    ```sh
    ./mvnw clean install
    ```

### Running

1. Configure the database connection by setting the following environment variables:
    ```sh
    export DATABASE_USER=<your-database-username>
    export DATABASE_PASSWORD=<your-database-password>
    export DATABASE_HOST=<your-database-host>
    ```

2. Execute boot command:
    ```sh
    ./mvnw spring-boot:run
    ```

3. (Optional) Access the Swagger UI on http://localhost:8080/swagger-ui/index.html#/


## API Endpoints

### Item Endpoints

- **Create Item**
    ```http
    POST /api/v1/items
    ```
    Request Body:
    ```json
    {
        "title": "Updated Item",
        "pictureLink": "http://example.com/updated_item.jpg",
        "currentLocation": "Updated Location",
        "foundLocation": "Updated Found Location",
        "foundDate": "2023-02-01",
        "whoFound": "Person B",
        "isRetrieved": true,
        "whoRetrieved": "Person C",
        "retrievedDate": "2023-02-15"
    }
    ```
    

- **List Items**
    ```http
    GET /api/v1/items
    ```
    Response:
    ```json
    [
        {
            "id": 1,
            "title": "Item 1",
            "pictureLink": "http://example.com/item1.jpg",
            "currentLocation": "Location 1",
            "foundLocation": "Location 2",
            "foundDate": "2023-01-01",
            "whoFound": "Person A",
            "isRetrieved": false,
            "whoRetrieved": null,
            "retrievedDate": null
        }
    ]
    ```

- **Get One Item**
    ```http
    GET /api/v1/items/{id}
    ```
    Response:
    ```json
    {
        "id": 1,
        "title": "Item 1",
        "pictureLink": "http://example.com/item1.jpg",
        "currentLocation": "Location 1",
        "foundLocation": "Location 2",
        "foundDate": "2023-01-01",
        "whoFound": "Person A",
        "isRetrieved": false,
        "whoRetrieved": null,
        "retrievedDate": null
    }
    ```

- **Update Item**
    ```http
    PUT /api/v1/items/{id}
    ```
    Request Body:
    ```json
    {
        "title": "Updated Item",
        "pictureLink": "http://example.com/updated_item.jpg",
        "currentLocation": "Updated Location",
        "foundLocation": "Updated Found Location",
        "foundDate": "2023-02-01",
        "whoFound": "Person B",
        "isRetrieved": true,
        "whoRetrieved": "Person C",
        "retrievedDate": "2023-02-15"
    }
    ```

- **Delete Item**
    ```http
    DELETE /api/v1/items/{id}
    ```

## Authors

Carlos Takeshi Sato - [Linkedin](https://linkedin.com/in/carlostak/)