import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class TestCart:

    def test_add_product_to_cart(self, driver):
        driver.get("https://automationexercise.com/products")

        # Hover over first product and click 'Add to cart'
        product = driver.find_element(By.XPATH, "(//div[@class='product-image-wrapper'])[1]")
        add_to_cart = driver.find_element(By.XPATH, "(//a[@data-product-id])[1]")

        actions = ActionChains(driver)
        actions.move_to_element(product).click(add_to_cart).perform()

        # Click 'View Cart'
        wait = WebDriverWait(driver, 10)
        view_cart = wait.until(EC.element_to_be_clickable((By.XPATH, "//u[normalize-space()='View Cart']")))
        view_cart.click()

        # Assert product is in cart
        cart_items = driver.find_elements(By.XPATH, "//tr[contains(@id, 'product')]")
        assert len(cart_items) > 0
