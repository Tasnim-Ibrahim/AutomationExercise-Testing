import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
import time

@pytest.fixture(scope="module")
def setup():
    service = Service(executable_path="drivers/chromedriver")  # Update path as needed
    driver = webdriver.Chrome(service=service)
    driver.maximize_window()
    yield driver
    driver.quit()

def test_valid_login(setup):
    driver = setup
    driver.get("https://www.automationexercise.com/")

    # Click on 'Signup / Login'
    login_link = driver.find_element(By.XPATH, "//a[@href='/login']")
    login_link.click()

    # Enter email and password
    email_field = driver.find_element(By.XPATH, "//input[@data-qa='login-email']")
    password_field = driver.find_element(By.XPATH, "//input[@data-qa='login-password']")
    login_button = driver.find_element(By.XPATH, "//button[@data-qa='login-button']")

    email_field.send_keys("testuser123@test.com")   # Replace with your valid email
    password_field.send_keys("Test@1234")           # Replace with your valid password
    login_button.click()

    # Assert user is logged in
    time.sleep(2)  # Wait for page load
    assert "Logged in as" in driver.page_source
