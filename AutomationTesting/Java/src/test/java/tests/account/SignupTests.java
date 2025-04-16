package tests.account;

import org.testng.Assert;
import org.testng.annotations.Test;
import data.SignupData;
import pages.account.AccountCreatedPage;
import pages.account.AccountDeletedPage;
import pages.account.SignupLoginPage;
import pages.account.SignupPage;
import pages.components.Header;
import pages.home.HomePage;
import tests.base.BaseTest;
import utils.TestDataProvider;

public class SignupTests extends BaseTest {

    @Test(dataProvider = "signupData", dataProviderClass = TestDataProvider.class)
    public void testRegisterUser(SignupData signupData) {
        // 1 & 2. Launch browser and navigate to url (handled in BaseTest)

        // 3. Verify that home page is visible successfully
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible(),
                "Home page is not visible");

        // 4. Click on 'Signup / Login' button
        // 5. Verify 'New User Signup!' is visible
        SignupLoginPage signupLoginPage = new Header(driver).navigateToSignupLoginPage();
        Assert.assertTrue(signupLoginPage.isSignupSectionVisible(),
                "New User Signup section is not visible");

        // 6 & 7. Enter name and email address and click 'Signup' button
        SignupPage signupPage = signupLoginPage.enterSignupDetails(
                signupData.getName(),
                signupData.getEmail());

        // Handle existing user case
        if (!signupData.isShouldSucceed()) {
            Assert.assertTrue(signupLoginPage.isEmailExistsErrorDisplayed(),
                    "Email exists error should be displayed for existing user");
            return;
        }

        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(signupPage.isAccountInfoHeaderVisible(),
                "Enter Account Information header is not visible");

        // 9-13. Fill all registration details and create account
        AccountCreatedPage accountCreatedPage = signupPage.selectTitle(signupData.getTitle())
                .enterPassword(signupData.getPassword())
                .selectDateOfBirth(
                        signupData.getDayOfBirth(),
                        signupData.getMonthOfBirth(),
                        signupData.getYearOfBirth())
                .setNewsletter(signupData.isNewsletter())
                .setSpecialOffers(signupData.isSpecialOffers())
                .enterAddressInfo(
                        signupData.getFirstName(),
                        signupData.getLastName(),
                        signupData.getCompany(),
                        signupData.getAddress1(),
                        signupData.getAddress2(),
                        signupData.getState(),
                        signupData.getCity(),
                        signupData.getZipcode(),
                        signupData.getMobileNumber())
                .selectCountry(signupData.getCountry())
                .clickCreateAccount();

        // 14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(accountCreatedPage.isAccountCreatedSuccessfully(),
                "Account created message is not visible");

        // 15-18. Continue, verify login, delete account, and verify deletion
        HomePage homePageAfterSignup = accountCreatedPage.clickContinue();

        // 16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(homePageAfterSignup.isLoggedIn(), "User is not logged in");
        Assert.assertEquals(homePageAfterSignup.getLoggedInUsername(), signupData.getName(),
                "Logged in username does not match");

        // 17-18. Delete account and verify deletion
        AccountDeletedPage accountDeletedPage = homePageAfterSignup.navigateToDeleteAccountPage();
        Assert.assertTrue(accountDeletedPage.isAccountDeletedSuccessfully(),
                "Account deleted message is not visible");
        accountDeletedPage.clickContinue();
    }
}