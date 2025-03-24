# test_search.py
import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

@pytest.mark.usefixtures("setup")
class TestSearch:

    def test_search_existing_product(self, driver):
        driver.get("https://automationexercise.com")

        # Click on 'Products' from top menu
        driver.find_element(By.XPATH, "//a[@href='/products']").click()

        # Wait for search input
        search_input = WebDriverWait(driver, 10).until(
            EC.presence_of_element_located((By.ID, "search_product"))
        )
        search_input.send_keys("top")

        # Click the search button
        driver.find_element(By.ID, "submit_search").click()

        # Wait for results and assert product is visible
        WebDriverWait(driver, 10).until(
            EC.visibility_of_element_located((By.XPATH, "//h2[contains(text(),'Searched Products')]"))
        )

        assert "Top" in driver.page_source
