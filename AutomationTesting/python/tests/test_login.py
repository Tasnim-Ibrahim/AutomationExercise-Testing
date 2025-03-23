# 📂 automation/python/tests/test_login.py
import pytest
from pages.login_page import LoginPage
from pages.signup_page import SignupPage

class TestLogin:

    def test_valid_login(self, driver):
        login_page = LoginPage(driver)
        login_page.go_to_login()
        login_page.login("dummytester789@mail.com", "Test@1234")
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
        assert "ACCOUNT CREATED!" in driver.page_source
