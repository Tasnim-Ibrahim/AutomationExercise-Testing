package tests.account;

import data.LogoutData;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import pages.home.HomePage;
import pages.account.SignupLoginPage;
import pages.components.Header;
import data.LoginData;
import utils.TestDataProvider;

public class LoginTests extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
    public void testUserLogin(LoginData loginData) {
        // 1 & 2. Launch browser and navigate to url (handled in BaseTest)

        // 3. Verify that home page is visible successfully
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible(),
                "Home page is not visible");

        // 4. Click on 'Signup / Login' button
        SignupLoginPage signupLoginPage = new Header(driver).navigateToSignupLoginPage();

        // 5. Verify 'Login to your account' is visible
        Assert.assertTrue(signupLoginPage.isLoginSectionVisible(),
                "Login section is not visible");

        // 6 & 7. Enter email address and password and click 'login' button
        HomePage homePageAfterLogin = signupLoginPage.login(
                loginData.getEmail(),
                loginData.getPassword());

        if (loginData.isShouldSucceed()) {
            // 8. Verify that 'Logged in as username' is visible for successful login
            Assert.assertTrue(homePageAfterLogin.isLoggedIn(),
                    "User should be logged in");

            // Verify the correct username is displayed
            // Assuming username is the part before @ in email
            String expectedUsername = loginData.getName();
            Assert.assertEquals(homePageAfterLogin.getLoggedInUsername(), expectedUsername,
                    "Logged in username does not match expected username");
        } else {
            // Verify error message for invalid credentials
            Assert.assertTrue(signupLoginPage.isLoginErrorDisplayed(),
                    "Login error message should be displayed for invalid credentials");
        }
    }
}