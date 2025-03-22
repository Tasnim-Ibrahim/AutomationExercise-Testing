# 🧪 Test Plan - Automation Exercise

## 📌 Project Overview
This project is aimed at testing the core functionalities of [Automation Exercise](https://www.automationexercise.com/), an open-source e-commerce website designed for testing practice. The testing includes manual, automation, API, and performance testing.

## 🎯 Objectives
- Ensure the functionality of user flows (registration, login, product search, etc.)
- Validate form behaviors and input validations
- Test API endpoints (if publicly accessible)
- Measure performance under various load conditions
- Ensure the system works as expected across browsers (cross-browser testing)

## 🔍 Scope of Testing
### ✅ In Scope
- User Registration and Login
- Product Search and Filtering
- Add to Cart and Checkout Process
- Contact Form and Subscriptions
- API Testing (where applicable)
- Load and Stress Testing

### ❌ Out of Scope
- Payment Gateway Validation (no actual transactions)
- Admin Backend (not publicly accessible)

## 🧰 Types of Testing
| Type                  | Description                                      |
|-----------------------|--------------------------------------------------|
| Manual Testing        | Functional testing of UI and user flows          |
| Automation Testing    | UI automation using Selenium (Java/Python)       |
| API Testing           | Validation of API endpoints (Postman/RestAssured)|
| Performance Testing   | Load testing using Apache JMeter                 |
| Cross-browser Testing | Testing across different browsers                |

## 🛠 Tools & Technologies
- Selenium (Java, Python)
- TestNG, Pytest
- Postman, RestAssured
- Apache JMeter
- Excel / Markdown for test case management

## 📅 Milestones
| Phase              | Timeline      |
|-------------------|---------------|
| Requirement Analysis | Week 1     |
| Test Case Design     | Week 1-2   |
| Manual Testing       | Week 2-3   |
| Automation Scripts   | Week 3-4   |
| API & Performance    | Week 4-5   |
| Final Reporting      | Week 6     |

## 📂 Deliverables
- Test Plan Document
- Test Case Documentation
- Bug Reports
- Automation Scripts
- API Collections
- Performance Reports
- Final Summary Report

## 👥 Team Roles
- Test Lead: Oversees the overall testing process
- Testers: Write and execute test cases, report bugs
- Automation Engineers: Develop automation scripts
- Performance Engineer: Conducts load testing

## 📌 Risks & Mitigations
| Risk                         | Mitigation                                |
|------------------------------|--------------------------------------------|
| Site content changes         | Use stable selectors, maintain scripts     |
| Limited API documentation    | Use exploratory testing with Postman       |
| Network issues during testing| Use retries and stable environments        |

---

📢 **Note**: This plan is flexible and will evolve as the project progresses.
