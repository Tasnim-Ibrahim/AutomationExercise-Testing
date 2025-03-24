# 📂 AutomationTesting/python/tests/test_cart.py

import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class TestCart:

    def test_add_product_to_cart(self, driver):
        driver.get("https://automationexercise.com/products")

        # ✅ Scroll to make sure product is visible
        product = driver.find_element(By.XPATH, "(//div[@class='product-image-wrapper'])[1]")
        driver.execute_script("arguments[0].scrollIntoView(true);", product)

        # ✅ Hover and click 'Add to cart'
        add_button = driver.find_element(By.XPATH, "(//a[@data-product-id])[1]")
        actions = ActionChains(driver)
        actions.move_to_element(product).click(add_button).perform()

        # ✅ Wait for modal and click 'View Cart'
        wait = WebDriverWait(driver, 10)
        view_cart = wait.until(EC.element_to_be_clickable((By.LINK_TEXT, "View Cart")))
        view_cart.click()

        # ✅ Verify product is in cart by checking for "Blue Top"
        wait.until(EC.presence_of_element_located((By.XPATH, "//a[text()='Blue Top']")))
        assert driver.find_element(By.XPATH, "//a[text()='Blue Top']").is_displayed()
