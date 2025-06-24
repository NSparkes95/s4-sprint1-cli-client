# ✈️ S4 Sprint 1 - Java CLI Client

This is the Java CLI application developed during Sprint Week 1 – Summer 2025.  
It allows users to interact with a Spring Boot API to explore city, passenger, airport, and aircraft data.

---

## ✅ Project Overview

This CLI client answers the following four questions using live API data:

1. What airports are there in each city?  
2. What aircraft has each passenger flown on?  
3. What airports do aircraft take off from and land at?  
4. What airports have passengers used?

---

## ⚙️ Setup Instructions

### Requirements
- Java 17+
- Maven 3+

---

### 🛠️ Clone and Build

```bash
git clone https://github.com/CRose1497/s4-sprint1-cli-client.git
cd s4-sprint1-cli-client
mvn clean install
```



▶️ **Run the CLI**
```bash
mvn exec:java
```
---
🧪 **Testing**

JUnit 5 is used for automated testing.

**Run Tests**
```bash
mvn test
```


✅ What’s Covered

- ✅ API service logic with real HTTP GET requests

- ✅ Input handling and CLI flow simulation

- ✅ Validation and edge cases (e.g. empty input, bad IDs, typos)

---
🔌 **API Info**

Base URL:
```bash
 http://localhost:8080
 ```

Endpoints used:

- `GET /city/{id}/airports`

- `GET /passenger/{id}/aircraft`

- `GET /aircraft/{id}/airports`

- `GET /passenger/{id}/airports`

Example Queries:

- `GET http://localhost:8080/city/7/airports` → returns airports in St. John's

- `GET http://localhost:8080/passenger/1/aircraft` → returns aircraft flown by passenger 1

---
🧠 **Team Members**

- Christian Rose – CLI development, input handling, test coverage

- Nicole Sparkes – Backend API integration & testing

- Dylan Finlay – Dev support, validation & QA

---
📹 **Demo Video**

A short demo video will be submitted to showcase:

- Live CLI walkthrough

- Answering the 4 required questions

- How the app handles errors and invalid input

---
📝 **Notes**

- Supports robust input validation and graceful error handling

- Ready to demo with real API data

- Fully automated JUnit test suite in place