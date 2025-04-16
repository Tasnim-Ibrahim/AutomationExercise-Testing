package tests.account;

import data.LogoutData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.account.SignupLoginPage;
import pages.components.Header;
import pages.home.HomePage;
import tests.base.BaseTest;
import utils.TestDataProvider;

public class LogoutTests extends BaseTest {
    @Test(dataProvider = "logoutData", dataProviderClass = TestDataProvider.class)
    public void testUserLogout(LogoutData logoutData) {
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
                logoutData.getEmail(),
                logoutData.getPassword());

        // 8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(homePageAfterLogin.isLoggedIn(),
                "User should be logged in");

        // Verify the correct username is displayed
        String expectedUsername = logoutData.getName();
        Assert.assertEquals(homePageAfterLogin.getLoggedInUsername(), expectedUsername,
                "Logged in username does not match expected username");

        // 9. Click 'Logout' button
        SignupLoginPage loginPageAfterLogout = homePageAfterLogin.logout();

        // 10. Verify that user is navigated to login page
        Assert.assertTrue(loginPageAfterLogout.isLoginSectionVisible(),
                "User should be navigated to login page after logout");
    }
}
