package tests.contact;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import pages.home.HomePage;
import pages.contact.ContactUsPage;
import pages.components.Header;
import data.ContactUsData;
import utils.TestDataProvider;

public class ContactUsTests extends BaseTest {

    @Test(dataProvider = "contactUsData", dataProviderClass = TestDataProvider.class)
    public void testContactUsForm(ContactUsData contactUsData) {
        // 1 & 2. Launch browser and navigate to url (handled in BaseTest)

        // 3. Verify that home page is visible successfully
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible(),
                "Home page is not visible");

        // 4. Click on 'Contact Us' button
        ContactUsPage contactUsPage = new Header(driver).navigateToContactUsPage();

        // 5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(contactUsPage.isGetInTouchHeaderVisible(),
                "'Get In Touch' header is not visible");

        // 6. Enter name, email, subject and message
        // 7. Skip upload file
        // 8. Click 'Submit' button
        // 9. Click OK button
        // 10. Verify success message is visible
        Assert.assertTrue(contactUsPage.enterContactDetails(
                contactUsData.getName(),
                contactUsData.getEmail(),
                contactUsData.getSubject(),
                contactUsData.getMessage()).submitForm().isSuccessMessageVisible(),
                "Success message is not visible");

        // Verify success message text
        Assert.assertEquals(contactUsPage.getSuccessMessageText(),
                "Success! Your details have been submitted successfully.",
                "Success message text does not match expected");

        // 11. Click 'Home' button and verify that landed to home page successfully
        HomePage homePageAfterSubmit = contactUsPage.clickHomeButton();
        Assert.assertTrue(homePageAfterSubmit.isHomePageVisible(),
                "Home page is not visible after clicking home button");
    }
}