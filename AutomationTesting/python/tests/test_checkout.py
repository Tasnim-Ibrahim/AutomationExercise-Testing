import time
import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from pages.checkout_page import CheckoutPage

class TestCheckout:
    def test_user_can_checkout_product(self, driver):
        driver.get("https://automationexercise.com/products")

        # Scroll and add product to cart
        driver.execute_script("window.scrollBy(0, 600);")
        product = driver.find_element(By.XPATH, "(//div[@class='product-image-wrapper'])[1]")
        add_btn = driver.find_element(By.XPATH, "(//a[@data-product-id])[1]")

        actions = ActionChains(driver)
        actions.move_to_element(product).click(add_btn).perform()

        # Wait for modal and click View Cart
        wait = WebDriverWait(driver, 10)
        view_cart = wait.until(EC.element_to_be_clickable((By.LINK_TEXT, "View Cart")))
        view_cart.click()

        # Proceed to checkout
        checkout = CheckoutPage(driver)
        checkout.click_proceed_to_checkout()

        # Verify checkout page is displayed with cart items
        items = checkout.get_cart_items()
        assert len(items) > 0, "Cart is empty on checkout page"
