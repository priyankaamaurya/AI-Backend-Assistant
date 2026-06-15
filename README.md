# AI Backend Assistant API

A production-ready **Spring Boot backend** that integrates with AI APIs (OpenRouter) to generate intelligent responses and store chat history using PostgreSQL.

---

## Features

🔹 AI Chat API using OpenRouter (GPT models)

🔹 RESTful API with Spring Boot

🔹 Store prompt & response in PostgreSQL

🔹 DTO-based clean architecture

🔹 Global Exception Handling

🔹 Logging using SLF4J

🔹 Swagger UI for API testing

🔹 Clean layered structure (Controller → Service → Repository)

---

## Tech Stack

- **Backend:** Spring Boot, WebClient
- **Database:** PostgreSQL
- **ORM:** Spring Data JPA (Hibernate)
- **API Integration:** OpenRouter (GPT API)
- **Documentation:** Swagger (OpenAPI)
- **Logging:** SLF4J + Logback

---

## Project Structure

```
com.priyanka.aibackend
│
├── controller # REST APIs
├── service # Business logic
├── repository # Database layer
├── entity # JPA Entities
├── dto # Data Transfer Objects
├── exception # Global exception handling
└── config # Configuration classes
```

---

## API Endpoints

### 🔹 Ask AI

```
POST /api/ai/ask

```

**Request Body:**
json

```
{
  "prompt": "What is Java?"
}
```

### 🔹 Get Chat History

```
GET /api/ai/history
```
---

## Swagger UI
```
http://localhost:8080/swagger-ui/index.html
```
---

## Environment Variables

Create .env file:
```
openrouter.api.key=YOUR_API_KEY
```
---

## Run Project
```
./mvnw spring-boot:run
```
---

## Future Improvements
🔹 User authentication (JWT)

🔹 Rate limiting

🔹 Chat session support

🔹 Frontend integration (React)

---

## Author

Priyanka Maurya
