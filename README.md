
# 🎓 AutomationExercise Testing Project – Graduation Portfolio

Welcome to the **AutomationExercise Testing Project**, a comprehensive QA project developed as a **Graduation Project** for the **Digital Egypt Pioneers Initiative (DEPI)**. This project applies a full suite of quality assurance practices across **Manual, Automation, API, and Performance Testing**, targeting the live [Automation Exercise](https://automationexercise.com) e-commerce demo platform.

---

## 👥 Team Members

- **Tasnim Ibrahim Hassan**
- **Mohamed Zaki Mohamed**
- **Aya Helmy Mohamed**
- **Mo'men Mohamed Abdullah**
- **AbdelRahman Mohamed Ibrahim**

---

## 📁 Repository Overview

```
AutomationExercise-Testing/
├── ManualTesting/          # Test cases, execution logs, and bug reports
├── AutomationTesting/
│   ├── python/             # Selenium WebDriver automation using Python + Pytest
│   └── java/               # Selenium WebDriver automation using Java + TestNG/JUnit
├── APITesting/             # Postman collections and test scripts
├── PerformanceTesting/     # JMeter test plans and reports
├── Reports/                # Generated reports (HTML, Allure, PDF)
├── Jenkins/                # CI/CD configuration (optional)
├── Database/               # Sample test data (Note: Database files are not included in repo)
├── requirements.txt        # Python dependencies
├── test_plan.md            # Test planning documentation
└── README.md               # Project documentation
```
---

## 🧰 Tools & Technologies

| Category            | Tools & Technologies                                                                 |
|---------------------|----------------------------------------------------------------------------------------|
| Manual Testing      | Excel, Word, Bug Reports (PDF), Test Cases                                             |
| Automation Testing  | **Python** (Selenium + Pytest), **Java** (Selenium + TestNG/JUnit)                     |
| API Testing         | Postman, Newman, JavaScript-based tests                                                |
| Performance Testing | Apache JMeter                                                                          |
| CI/CD               | Jenkins (pipeline setup for automation execution), GitHub                              |
| Reporting           | HTML Reports, Allure, Logs                                                             |
| Database (Mock/Test)| SQL scripts or CSV-based test data (defined in `/Database`)                            |
| Version Control     | Git, GitHub                                                                            |
| Documentation       | Markdown, test plan documents, bug reports  

---

## 🚀 Quick Start

### 🔧 Setup

1. Clone the repository:
```bash
git clone https://github.com/Tasnim-Ibrahim/AutomationExercise-Testing.git
```

2. Install Python dependencies:
```bash
pip install -r requirements.txt
```

---

## 🧪 Run Automation Tests

```bash
pytest AutomationTesting/python/tests/ --html=Reports/checkout_report.html
```

---

## 📊 Run API Tests with Newman

```bash
newman run APITesting/collection.json -r cli,html --reporter-html-export=APITesting/report.html
```

---

## ⚙️ Run Performance Tests (JMeter)

1. Open `.jmx` file in Apache JMeter.
2. Configure thread group.
3. Run and analyze the results using listeners.

---

## 🗂️ Test Artifacts Included

- ✅ Manual Test Cases (Excel)
- 🐞 Bug Reports (PDF/Excel)
- ✅ Automation Test Scripts (Selenium + Python)
- 🔁 API Test Collection (Postman + Newman)
- ⚙️ Performance Test Plan (JMeter)
- 📄 Test Plan Document (`test_plan.md`)
- 📈 Reports (HTML and Allure-ready)

---

## 📌 Final Notes

This project reflects a real-world QA lifecycle and professional testing structure. It demonstrates your ability to organize, automate, report, and validate end-to-end software quality.

> ⭐ Star the repository if you find this useful or inspiring!

---

## 📄 License

This project is developed for educational purposes and licensed under the [MIT License](LICENSE).
