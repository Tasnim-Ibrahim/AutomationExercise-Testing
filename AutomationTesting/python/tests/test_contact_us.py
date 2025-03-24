import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.alert import Alert

class TestContactUs:
    def test_submit_contact_form(self, driver):
        driver.get("https://automationexercise.com/contact_us")

        # Fill out the form
        driver.find_element(By.NAME, "name").send_keys("Tasnim QA")
        driver.find_element(By.NAME, "email").send_keys("tasnim@example.com")
        driver.find_element(By.NAME, "subject").send_keys("Test Subject")
        driver.find_element(By.ID, "message").send_keys("This is a test message for automation.")

        # File upload (optional, can be skipped if not needed)
        # file_input = driver.find_element(By.NAME, "upload_file")
        # file_input.send_keys("H:/path/to/sample.txt")

        driver.find_element(By.NAME, "submit").click()

        # Handle the JavaScript alert popup
        WebDriverWait(driver, 10).until(EC.alert_is_present())
        Alert(driver).accept()

        # Check for the success message
        success_message = WebDriverWait(driver, 10).until(
            EC.visibility_of_element_located((By.XPATH, "//div[@class='status alert alert-success']"))
        )
        assert "Success! Your details have been submitted successfully." in success_message.text
