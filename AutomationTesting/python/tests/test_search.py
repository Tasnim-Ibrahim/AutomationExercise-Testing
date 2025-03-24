# ✅ test_search.py (cleaned up)
import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class TestSearch:

    def test_search_existing_product(self, driver):
        driver.get("https://automationexercise.com/products")

        # Search for existing product
        search_input = driver.find_element(By.ID, "search_product")
        search_input.send_keys("Blue")

        driver.find_element(By.ID, "submit_search").click()

        # Wait for product results to load
        WebDriverWait(driver, 10).until(
            EC.visibility_of_element_located((By.CLASS_NAME, "productinfo"))
        )

        # Assertion
        assert "Blue Top" in driver.page_source

    def test_search_non_existing_product(self, driver):
        driver.get("https://automationexercise.com/products")

        # Search for non-existing product
        search_input = driver.find_element(By.ID, "search_product")
        search_input.send_keys("NonExistentProduct123")

        driver.find_element(By.ID, "submit_search").click()

        # Wait for the search results section to appear
        WebDriverWait(driver, 10).until(
            EC.visibility_of_element_located((By.XPATH, "//h2[contains(text(), 'Searched Products')]"))
        )

        # Assert no product cards are shown
        product_elements = driver.find_elements(By.CLASS_NAME, "productinfo")
        assert len(product_elements) == 0
