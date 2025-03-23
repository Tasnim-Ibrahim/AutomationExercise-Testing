import pytest
from pages.login_page import LoginPage

@pytest.mark.usefixtures("setup")
class TestLogin:

    def test_valid_login(self, driver):
        login_page = LoginPage(driver)
        login_page.go_to_login()
        login_page.login("dummytester789@mail.com", "Test@1234")

        assert "Logged in as" in driver.page_source

    def test_invalid_login(self, driver):
        login_page = LoginPage(driver)
        login_page.go_to_login()
        login_page.login("invaliduser@example.com", "wrongpassword")

        assert "Your email or password is incorrect!" in driver.page_source
