package tests.product;

import data.PurchaseSignUpData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.account.AccountCreatedPage;
import pages.account.AccountDeletedPage;
import pages.cart.CartPage;
import pages.checkout.CheckoutPage;
import pages.components.Header;
import pages.home.HomePage;
import pages.payment.OrderPlacedPage;
import pages.payment.PaymentPage;
import pages.product.BaseProductsPage;
import pages.product.ProductDetailsPage;
import tests.base.BaseTest;
import utils.TestDataProvider;

public class PurchaseWithSignupTests extends BaseTest {

    @Test(dataProvider = "PurchaseSignUpData", dataProviderClass = TestDataProvider.class)
    public void testCompletePurchaseFlow(PurchaseSignUpData purchaseData) {
        // Navigate to products page and verify visibility
        BaseProductsPage productsPage = new Header(driver)
                .navigateToBaseProductsPage();

        Assert.assertTrue(productsPage.isProductsPageVisible(),
                "Products page is not visible");

        // Navigate to product details page and verify correct product
        ProductDetailsPage productDetailsPage = productsPage
                .navigateToProductDetailsPage(purchaseData.getProduct().getProductId());

        Assert.assertEquals(productDetailsPage.getProductName(),purchaseData.getProduct().getName(),
                "Not on the correct product page");

        // Set quantity, add to cart and view cart
        CartPage cartPage = productDetailsPage
                .setQuantity(purchaseData.getProduct().getQuantity())
                .addToCart()
                .clickViewCartFromPopup();

        // Verify product in cart with correct quantity
        Assert.assertTrue(cartPage.isProductInCart(purchaseData.getProduct().getProductId()),
                "Product not found in cart");
        Assert.assertEquals(cartPage.getProductQuantity(purchaseData.getProduct().getProductId()),
                purchaseData.getProduct().getQuantity(),
                "Product quantity in cart doesn't match");

        // Proceed to checkout, register using data from JSON file
        CheckoutPage accountCreatedPage = cartPage
                .proceedToCheckout();

        cartPage.clickRegisterLoginLink().enterSignupDetails(purchaseData.getUser().getName(), purchaseData.getUser().getEmail())
                .selectTitle(purchaseData.getUser().getTitle())
                .enterPassword(purchaseData.getUser().getPassword())
                .selectDateOfBirth(
                        purchaseData.getUser().getDayOfBirth(),
                        purchaseData.getUser().getMonthOfBirth(),
                        purchaseData.getUser().getYearOfBirth())
                .setNewsletter(purchaseData.getUser().isNewsletter())
                .setSpecialOffers(purchaseData.getUser().isSpecialOffers())
                .enterAddressInfo(
                        purchaseData.getUser().getFirstName(),
                        purchaseData.getUser().getLastName(),
                        purchaseData.getUser().getCompany(),
                        purchaseData.getUser().getAddress1(),
                        purchaseData.getUser().getAddress2(),
                        purchaseData.getUser().getState(),
                        purchaseData.getUser().getCity(),
                        purchaseData.getUser().getZipcode(),
                        purchaseData.getUser().getMobileNumber())
                .selectCountry(purchaseData.getUser().getCountry())
                .clickCreateAccount();

        //Verify account created successfully
        AccountCreatedPage accountCreatedPageAfterSignup = new AccountCreatedPage(driver);
        Assert.assertTrue(accountCreatedPageAfterSignup.isAccountCreatedSuccessfully(),
                "Account created message is not visible");

        // Continue to home page and verify login
        HomePage homePageAfterSignup = accountCreatedPageAfterSignup.clickContinue();
        Assert.assertTrue(homePageAfterSignup.isLoggedIn(), "User is not logged in");
        Assert.assertEquals(homePageAfterSignup.getLoggedInUsername(), purchaseData.getUser().getName(),
                "Logged in username does not match expected");

        // Navigate to cart and proceed to checkout
        Header header = new Header(driver);
        CartPage cartPageAfterSignup = header.navigateToCartPage();
        Assert.assertTrue(cartPageAfterSignup.isProductInCart(purchaseData.getProduct().getProductId()),
                "Product not found in cart after signup");
        Assert.assertEquals(cartPageAfterSignup.getProductQuantity(purchaseData.getProduct().getProductId()),
                purchaseData.getProduct().getQuantity(),
                "Product quantity in cart doesn't match after signup");
        CheckoutPage checkoutPage = cartPageAfterSignup
                .proceedToCheckout();

        // Verify Product name and quantity in checkout page
        Assert.assertEquals(checkoutPage.getProductName(purchaseData.getProduct().getProductId()), purchaseData.getProduct().getName(),
                "Product name in checkout page does not match");
        Assert.assertEquals(checkoutPage.getProductQuantity(purchaseData.getProduct().getProductId()),
                purchaseData.getProduct().getQuantity(),
                "Product quantity in checkout page does not match");
        // Click Place order button
        PaymentPage paymentPage = checkoutPage.placeOrder().enterPaymentDetails(purchaseData.getPayment().getNameOnCard(),
                purchaseData.getPayment().getCardNumber(),
                purchaseData.getPayment().getCvc(),
                purchaseData.getPayment().getExpiryMonth(),
                purchaseData.getPayment().getExpiryYear());
        // Click Pay and Confirm order button
        OrderPlacedPage orderPlacedPage = paymentPage.payAndConfirmOrder();
        // Verify order placed successfully
        Assert.assertTrue(orderPlacedPage.isOrderPlacedSuccessfully(),
                "Order placed message is not visible");
        // Verify home page is visible
        Assert.assertTrue(orderPlacedPage.clickContinue().isHomePageVisible(),
                "Home page is not visible after clicking continue");
        // Delete account
        AccountDeletedPage accountDeletedPage = new HomePage(driver).
                navigateToDeleteAccountPage();
        // Verify account deleted successfully
        Assert.assertTrue(accountDeletedPage.isAccountDeletedSuccessfully(),
                "Account deleted message is not visible");
    }
}