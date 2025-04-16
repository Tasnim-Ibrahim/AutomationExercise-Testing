# Automation Exercise

## Overview
This repository contains an automated testing framework for web applications using Java and Selenium WebDriver. The project implements the Page Object Model (POM) design pattern to create a maintainable and scalable test automation solution. This automation framework is specifically designed to test the website: https://www.automationexercise.com/

## Technologies Used
- Java
- Selenium WebDriver 
- TestNG
- Maven
- WebDriverManager

## Project Structure
The project follows a standard Maven structure with test resources organized according to the Page Object Model pattern:
- `src/main/java`: 
  - Page objects
  - Data classes
- `src/test/java`: 
  - Tests
  - Utils/Test data handlers
- `resources`: 
  - Configuration files
  - Test data

## Features
- Page Object Model implementation for better maintainability
- Data-driven test capabilities
- Cross-browser testing support
- Reusable components and utilities

## Setup Instructions

### Prerequisites
- Java JDK 23 or higher
- Maven
- IntelliJ IDEA (recommended)

### Installation
1. Clone the repository:
   ```
   git clone 
   ```
2. Navigate to the project directory:
   ```
   cd Automation_Exercise
   ```
3. Install dependencies:
   ```
   mvn clean install
   ```

## Running Tests
To run all tests:
```
mvn test
```

To run specific test classes:
```
mvn test -Dtest=TestClassName
```

Alternatively, you can run tests using the testng.xml file:
1. Right-click on the testng.xml file in IntelliJ IDEA
2. Select "Run 'testng.xml'"

## Acknowledgements
- [Selenium Documentation](https://www.selenium.dev/documentation/en/)
- [TestNG Documentation](https://testng.org/doc/)
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager)
- [Automation Exercise Website](https://www.automationexercise.com/)