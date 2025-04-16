package tests.components;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import pages.home.HomePage;
import pages.components.Footer;
import data.ContactUsData;
import utils.TestDataProvider;

public class SubscriptionTests extends BaseTest {

    @Test(dataProvider = "contactUsData", dataProviderClass = TestDataProvider.class)
    public void testFooterSubscription(ContactUsData contactUsData) {
        // 1 & 2. Launch browser and navigate to url (handled in BaseTest)

        // 3. Verify that home page is visible successfully
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible(),
                "Home page is not visible");

        Footer footer = new Footer(driver);

        // 4. Scroll down to footer
        // 5. Verify text 'SUBSCRIPTION'
        Assert.assertTrue(footer.scrollToFooter().isSubscriptionTextVisible(),
                "Subscription text is not visible");

        // 6. Enter email address in input and click arrow button
        // 7. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertTrue(footer.subscribeWithEmail(contactUsData.getEmail()).isSubscriptionSuccessful(),
                "Subscription success message is not visible");
    }
}