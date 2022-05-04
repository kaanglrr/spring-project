# Todo List App

---
### Technology stack
- Maven
- Java 11
- Spring Boot 
- Spring Data JPA
- H2 In memory database
- Swagger
- Docker

---
### Requirements
- Maven
- Docker

---
## Building and running with Maven

You can build and run your app by typing this in your terminal.

`.\mvnw clean install spring-boot:run` 

---

## Building and running with Docker

---

You can create docker image and run it by typing these in your terminal.

`docker build -t myproject:latest .`

`docker run -p 8050:8050 myproject` 

---

## Swagger OpenAPI UI
You can perform HTTP requests using swagger with this link:

`http://localhost:8050/swagger-ui.html`

---
