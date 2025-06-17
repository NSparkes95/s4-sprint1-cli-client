S4 Sprint 1 - Java CLI Client

This is the Java CLI application for Sprint Week 1 of Summer 2025. It allows users to retrieve and display airport and aircraft information by interacting with an API over HTTP.

Project Overview

This CLI client answers the following 4 questions by making GET requests to the API:
1. What airports are there in each city?
2. What aircraft has each passenger flown on?
3. What airports do aircraft take off from and land at?
4. What airports have passengers used?

Currently, the project uses mock data for development and testing purposes. It will be updated to consume live API responses once the backend service is completed.

Setup Instructions

Requirements
- Java 17+
- Maven

Clone & Run
git clone https://github.com/<your-username>/s4-sprint1-cli-client.git
cd s4-sprint1-cli-client
mvn clean install

To run the CLI:
mvn exec:java

Testing
JUnit 5 is used for unit testing.
Run tests with:
mvn test

Tests include:
- API service methods using mock data
- Menu selection flow using simulated user input
Test coverage includes valid choices, invalid input handling, and edge cases.

Team Members
- Christian Rose – CLI implementation, testing
- Nicole Sparkes – API/backend integration
- Dylan Finlay – Additional development & QA support

Next Steps (Post-API Launch)
- Replace mock logic with real HTTP GET calls to backend
- Update JUnit tests to reflect live API responses
- Final polish & demo video recording
