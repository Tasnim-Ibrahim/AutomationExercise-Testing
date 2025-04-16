# 📂 automation/python/pages/signup_page.py
import random
import string
import time
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class SignupPage:
    def __init__(self, driver):
        self.driver = driver
        self.signup_login_link = (By.LINK_TEXT, "Signup / Login")
        self.name_field = (By.NAME, "name")
        self.email_field = (By.XPATH, "//input[@data-qa='signup-email']")
        self.signup_button = (By.XPATH, "//button[@data-qa='signup-button']")
        self.password_field = (By.ID, "password")
        self.first_name = (By.ID, "first_name")
        self.last_name = (By.ID, "last_name")
        self.address = (By.ID, "address1")
        self.state = (By.ID, "state")
        self.city = (By.ID, "city")
        self.zipcode = (By.ID, "zipcode")
        self.mobile = (By.ID, "mobile_number")
        self.create_account_btn = (By.XPATH, "//button[@data-qa='create-account']")

    def go_to_signup(self):
        self.driver.find_element(*self.signup_login_link).click()
        time.sleep(5)


    def generate_random_email(self):
        prefix = ''.join(random.choices(string.ascii_lowercase + string.digits, k=6))
        return f"testuser_{prefix}@example.com"

    def fill_signup_form(self, name, email, password):
        self.driver.find_element(*self.name_field).send_keys(name)
        self.driver.find_element(*self.email_field).send_keys(email)
        self.driver.find_element(*self.signup_button).click()

        self.driver.find_element(*self.password_field).send_keys(password)
        self.driver.find_element(*self.first_name).send_keys("Test")
        self.driver.find_element(*self.last_name).send_keys("User")
        self.driver.find_element(*self.address).send_keys("123 Test Lane")
        self.driver.find_element(*self.state).send_keys("Test State")
        self.driver.find_element(*self.city).send_keys("Test City")
        self.driver.find_element(*self.zipcode).send_keys("12345")
        self.driver.find_element(*self.mobile).send_keys("1234567890")

        # ✅ Scroll into view
        button = self.driver.find_element(*self.create_account_btn)
        self.driver.execute_script("arguments[0].scrollIntoView(true);", button)

        # ✅ Wait until clickable
        WebDriverWait(self.driver, 10).until(EC.element_to_be_clickable(self.create_account_btn))

        # ✅ Click safely
        button.click()

