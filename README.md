# AutomationExercise Testing

## 📌 Overview
This repository is dedicated to **manual, automation, API, and performance testing** for [**Automation Exercise**](https://www.automationexercise.com/), a demo e-commerce platform used for testing practice. The goal is to ensure the site’s reliability, functionality, and performance through structured test strategies.

## 🛠 Technologies & Tools Used
| Type of Testing      | Tools Used                                              |
|----------------------|---------------------------------------------------------|
| **Manual Testing**   | Excel (Test case documentation, defect reporting)       |
| **Automation Testing** | Selenium, TestNG (Java) / Pytest (Python) (Automate UI testing) |
| **API Testing**      | Postman, RestAssured (Java) (Validate API responses)    |
| **Performance Testing** | Apache JMeter (Load and stress testing)               |

## 🔍 Project Structure
```
AutomationExercise-Testing
│── 📜 README.md  # Project documentation
│── 📜 .gitignore  # Ignore unnecessary files
│── 📜 LICENSE  # Project license (MIT recommended)
│── 📜 test_plan.md  # Test plan document
│── 📂 ManualTesting/  # Manual test cases & bug reports
│── 📂 AutomationTesting/  # Selenium automation tests
│   ├── Java/
│   │   ├── pom.xml  # Maven dependencies
│   │   ├── src/test/java/  # Java Selenium test scripts
│   ├── Python/
│       ├── requirements.txt  # Python dependencies
│       ├── tests/  # Python Selenium test scripts
│── 📂 APITesting/  # API testing scripts
│   ├── PostmanCollection.json
│   ├── restassured_tests.java
│   ├── api_tests.py
│── 📂 PerformanceTesting/  # JMeter performance tests
│   ├── jmeter_test_plan.jmx
│   ├── results.csv
│── 📂 Reports/  # Test execution reports
│   ├── manual_test_report.md
│   ├── automation_test_report.md
│   ├── performance_test_report.md
```

## 🚀 Getting Started
### 🏗 1. Clone the Repository
```bash
git clone https://github.com/Tasnim-Ibrahim/AutomationExercise-Testing.git
cd AutomationExercise-Testing
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
jmeter -n -t PerformanceTesting/jmeter_test_plan.jmx -l results.csv
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
