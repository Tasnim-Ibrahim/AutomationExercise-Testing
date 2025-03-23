from selenium.webdriver.common.by import By

class LoginPage:
    def __init__(self, driver):
        self.driver = driver
        self.login_link = (By.LINK_TEXT, "Signup / Login")
        self.email_field = (By.NAME, "email")
        self.password_field = (By.NAME, "password")
        self.login_button = (By.XPATH, "//button[@data-qa='login-button']")

    def go_to_login(self):
        self.driver.find_element(*self.login_link).click()

    def login(self, email, password):
        self.driver.find_element(*self.email_field).send_keys(email)
        self.driver.find_element(*self.password_field).send_keys(password)
        self.driver.find_element(*self.login_button).click()


