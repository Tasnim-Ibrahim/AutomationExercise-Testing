# 📂 automation/python/tests/test_login.py
import pytest
from selenium.webdriver.common.by import By
from pages.login_page import LoginPage
from pages.signup_page import SignupPage
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class TestLogin:

    def test_valid_login(self, driver):
        login_page = LoginPage(driver)
        login_page.go_to_login()
        login_page.login("dummytester789@mail.com", "Test@1234")

        # ✅ Wait until the confirmation text is on the page
        WebDriverWait(driver, 10).until(
            EC.presence_of_element_located((By.XPATH, "//*[contains(text(), 'Logged in as')]"))
        )

        assert "Logged in as" in driver.page_source

    def test_invalid_login(self, driver):
        login_page = LoginPage(driver)
        login_page.go_to_login()
        login_page.login("invaliduser@example.com", "wrongpassword")
        assert "Your email or password is incorrect!" in driver.page_source

    def test_signup(self, driver):
        signup_page = SignupPage(driver)
        signup_page.go_to_signup()
        email = signup_page.generate_random_email()
        signup_page.fill_signup_form("Automation Tester", email, "Test@1234")

        # ✅ Wait for the <b> tag inside <h2> that contains the success message
        wait = WebDriverWait(driver, 10)
        heading_text = wait.until(
            EC.presence_of_element_located((By.XPATH, "//h2[@data-qa='account-created']/b"))
        )

        assert heading_text.text.strip() == "ACCOUNT CREATED!"

