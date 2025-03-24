import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains

class TestCheckout:
    def test_user_can_checkout_product(self, driver):
        driver.get("https://automationexercise.com/products")
        driver.execute_script("window.scrollBy(0, 600);")

        # Step 2 will go here in next part
