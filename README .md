# OrangeHRM Testing

## 📌 Overview
This repository contains comprehensive **manual, automation, API, and performance testing** for **OrangeHRM**, an open-source Human Resource Management system. The goal is to ensure system reliability, functionality, and performance through structured testing methodologies.

## 🛠 Technologies & Tools Used
| Type of Testing  | Tools Used  |
|-----------------|------------|
| **Manual Testing** | Excel (Test case documentation, defect reporting) |
| **Automation Testing** | Selenium, TestNG (Java) / Pytest (Python) (Automate UI testing) |
| **API Testing** | Postman, RestAssured (Java) (Validate API responses) |
| **Performance Testing** | Apache JMeter (Load and stress testing) |

## 🔍 Project Structure
```
OrangeHRM-Testing
│── 📜 README.md  # Project documentation
│── 📜 test_plan.md  # Test plan document
│── 📂 ManualTesting  # Manual test cases & bug reports
│   ├── test_cases.xlsx
│   ├── bug_reports.md
│── 📂 AutomationTesting  # Automated UI tests (Selenium)
│   ├── test_scripts/  # Java/Python Selenium scripts
│   ├── pom.xml  # Maven dependencies (if using Java)
│── 📂 APITesting  # API testing with Postman & RestAssured
│   ├── api_tests.postman_collection.json
│   ├── restassured_tests.java
│── 📂 PerformanceTesting  # JMeter scripts
│   ├── orangehrm_performance.jmx
│   ├── results.csv
│── 📂 Reports  # Test execution reports
│   ├── manual_test_report.md
│   ├── automation_test_report.md
│   ├── performance_test_report.md
```

## 🚀 Getting Started
### 🏗 1. Clone the Repository
```bash
git clone https://github.com/TasnimIbrahim/OrangeHRM-Testing.git
cd OrangeHRM-Testing
```
### 🔧 2. Set Up Dependencies
#### ➤ For Selenium (Java)
```bash
# Ensure Java and Maven are installed
mvn install
```
#### ➤ For Selenium (Python)
```bash
# Ensure Python is installed
pip install -r requirements.txt
```
### 🎯 3. Running Tests
#### ➤ Run Automated UI Tests
```bash
mvn test  # Generates reports in target/surefire-reports/
pytest    # Generates logs in reports/
```
#### ➤ Run API Tests (Postman)
```bash
newman run api_tests.postman_collection.json --reporters cli,junit
```
#### ➤ Run JMeter Performance Test
```bash
jmeter -n -t PerformanceTesting/orangehrm_performance.jmx -l results.csv
```

## 📊 Test Reports
- **Manual Test Report** → `Reports/manual_test_report.md` (Generated after test execution)
- **Automation Report** → `Reports/automation_test_report.md` (Selenium test results)
- **API Test Results** → `Reports/api_test_report.md` (Postman Newman results)
- **Performance Report** → `Reports/performance_test_report.md` (JMeter execution report)

## 🤝 Contributing
Contributions are welcome! If you'd like to improve the test coverage:
1. Fork the repository.
2. Create a feature branch (`feature-branch`).
3. Commit your changes.
4. Open a pull request.

## 📜 License
This project is licensed under the **MIT License**.
