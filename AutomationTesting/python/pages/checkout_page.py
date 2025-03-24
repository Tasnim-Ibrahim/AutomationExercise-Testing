from selenium.webdriver.common.by import By

class CheckoutPage:
    def __init__(self, driver):
        self.driver = driver
        self.cart_button = (By.XPATH, "//a[@href='/view_cart']")
        self.proceed_to_checkout_button = (By.XPATH, "//a[contains(text(),'Proceed To Checkout')]")
        self.cart_items = (By.CLASS_NAME, "cart_description")

    def go_to_cart(self):
        self.driver.find_element(*self.cart_button).click()

    def click_proceed_to_checkout(self):
        self.driver.find_element(*self.proceed_to_checkout_button).click()

    def get_cart_items(self):
        return self.driver.find_elements(*self.cart_items)
