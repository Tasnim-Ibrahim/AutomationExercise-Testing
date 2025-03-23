# 🧪 QA Final Project – AutomationExercise Testing

This repository contains a complete QA project based on [AutomationExercise](https://www.automationexercise.com/), designed as a **graduation project** for a QA test team.

It includes:
- ✅ Manual Test Cases
- 🤖 Automation Testing (Python & Java)
- 🔌 API Testing
- ⚙️ Performance Testing

---

## 📁 Project Structure

```
AutomationExercise-Testing/
├── manual/              # Manual test cases (Excel, PDF, etc.)
├── automation/          # Automation testing
│   ├── python/
│   └── java/
├── api/                 # API testing scripts (Postman / Python / JavaScript)
├── performance/         # Performance tests (JMeter / Locust / etc.)
├── .gitignore
├── README.md
└── requirements.txt     # For Python dependencies
```

---

## 💻 Technologies Used

- Manual Testing: Test case design, test execution
- Automation:
  - Python (unittest/pytest, Selenium)
  - Java (JUnit/TestNG, Selenium)
- API: Postman / REST-assured / Python `requests`
- Performance: JMeter / Locust
- Tools: Git, GitHub, VS Code, IntelliJ, Postman, JMeter

---

## 🚀 How to Use

### 📄 Manual Tests

Find test case documents in the `manual/` folder (PDFs, Excel, etc.)

---

### 🐍 Run Python Automation Tests

```bash
cd automation/python
python sample_test.py
```

---

### ☕ Run Java Automation Tests

```bash
cd automation/java
javac SampleTest.java
java SampleTest
```

---

### 🔌 Run API Tests

If using Postman:
- Import the collection from `api/` into Postman
- Run using Collection Runner

If using code:
```bash
cd api/
python test_api_sample.py
```

---

### ⚙️ Run Performance Tests

If using JMeter:
- Open `.jmx` files in JMeter GUI

If using Locust:
```bash
cd performance/
locust
```

---

## 🤝 Contributing

1. Fork the repo
2. Create your feature branch: `git checkout -b feature/your-feature`
3. Commit your changes
4. Push to GitHub
5. Open a Pull Request

---

## 👥 Team

This project is part of a **QA graduation project** done by a test team covering all key QA disciplines.

---

## 📌 Notes

- Placeholder test files are included — replace them with your real tests.
- Make sure to update dependencies in `requirements.txt` as needed.

---
