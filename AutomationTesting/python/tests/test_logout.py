import pytest
from selenium.webdriver.common.by import By
from pages.login_page import LoginPage

class TestLogout:

    def test_user_can_logout(self, driver):
        login_page = LoginPage(driver)
        login_page.go_to_login()
        login_page.login("dummytester789@mail.com", "Test@1234")

        # ✅ Click the Logout button
        driver.find_element(By.XPATH, "//a[contains(text(),'Logout')]").click()

        # ✅ Assert the user is back on login page
        assert "Login to your account" in driver.page_source
