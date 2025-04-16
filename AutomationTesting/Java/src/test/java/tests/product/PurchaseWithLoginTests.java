package tests.product;

import data.PurchaseWithLoginData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.account.SignupLoginPage;
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

public class PurchaseWithLoginTests extends BaseTest {

    @Test(dataProvider = "purchaseLoginData", dataProviderClass = TestDataProvider.class)
    public void testPurchaseWithLogin(PurchaseWithLoginData purchaseData) {
        // 1 & 2. Launch browser and navigate to url (handled in BaseTest)

        // 3. Verify that home page is visible successfully
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible(),
                "Home page is not visible");

        // 4. Click 'Signup / Login' button
        SignupLoginPage signupLoginPage = new Header(driver).navigateToSignupLoginPage();

        // 5. Fill email, password and click 'Login' button
        HomePage homePageAfterLogin = signupLoginPage.login(
                purchaseData.getUser().getEmail(),
                purchaseData.getUser().getPassword());

        // 6. Verify 'Logged in as username' at top
        Assert.assertTrue(homePageAfterLogin.isLoggedIn(),
                "User is not logged in");
        Assert.assertEquals(homePageAfterLogin.getLoggedInUsername(),
                purchaseData.getUser().getName(),
                "Logged in username does not match expected");

        // 7. Add products to cart
        BaseProductsPage productsPage = new Header(driver)
                .navigateToBaseProductsPage();

        productsPage.hoverAndAddToCart(purchaseData.getProduct().getProductId());

        // 8. Click 'Cart' button
        CartPage cartPage = productsPage
                .clickViewCartFromPopup();

        // 9. Verify that cart page is displayed with correct product
        Assert.assertTrue(cartPage.isProductInCart(purchaseData.getProduct().getProductId()),
                "Product not found in cart");

        // 10. Click Proceed To Checkout
        CheckoutPage checkoutPage = cartPage.proceedToCheckout();

        // 11. Review The Order
        Assert.assertTrue(checkoutPage.isProductInCheckout(purchaseData.getProduct().getProductId()),
                "Product not found in checkout");
        Assert.assertEquals(checkoutPage.getProductName(purchaseData.getProduct().getProductId()),
                purchaseData.getProduct().getName(),
                "Product name in checkout doesn't match");

        // 12. Click 'Place Order'
        PaymentPage paymentPage = checkoutPage.placeOrder();

        // 13. Enter payment details
        paymentPage.enterPaymentDetails(
                purchaseData.getPayment().getNameOnCard(),
                purchaseData.getPayment().getCardNumber(),
                purchaseData.getPayment().getCvc(),
                purchaseData.getPayment().getExpiryMonth(),
                purchaseData.getPayment().getExpiryYear());

        // 14. Click 'Pay and Confirm Order' button
        OrderPlacedPage orderPlacedPage = paymentPage.payAndConfirmOrder();

        // 15. Verify success message
        Assert.assertTrue(orderPlacedPage.isOrderPlacedSuccessfully(),
                "Order placed message is not visible");

        // 16. Click continue
        HomePage homePageAfterOrder = orderPlacedPage.clickContinue();

        // 17. Click logout
        SignupLoginPage loginPageAfterLogout = homePageAfterOrder.logout();

        // 18. Verify that user is navigated to login page
        Assert.assertTrue(loginPageAfterLogout.isLoginSectionVisible(),
                "User should be navigated to login page after logout");
    }

    @Test(dataProvider = "purchaseLoginData", dataProviderClass = TestDataProvider.class)
    public void testPurchaseWithDirectAddToCart(PurchaseWithLoginData purchaseData) {
        // 1 & 2. Launch browser and navigate to url (handled in BaseTest)

        // 3. Verify that home page is visible successfully
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible(),
                "Home page is not visible");

        // 4. Click 'Signup / Login' button
        SignupLoginPage signupLoginPage = new Header(driver).navigateToSignupLoginPage();

        // 5. Fill email, password and click 'Login' button
        HomePage homePageAfterLogin = signupLoginPage.login(
                purchaseData.getUser().getEmail(),
                purchaseData.getUser().getPassword());

        // 6. Verify 'Logged in as username' at top
        Assert.assertTrue(homePageAfterLogin.isLoggedIn(),
                "User is not logged in");
        Assert.assertEquals(homePageAfterLogin.getLoggedInUsername(),
                purchaseData.getUser().getName(),
                "Logged in username does not match expected");

        // 7. Add products to cart directly (without hovering)
        BaseProductsPage productsPage = new Header(driver)
                .navigateToBaseProductsPage();

        productsPage.addToCart(purchaseData.getProduct().getProductId());

        // 8. Click 'Cart' button
        CartPage cartPage = productsPage
                .clickViewCartFromPopup();

        // 9. Verify that cart page is displayed with correct product
        Assert.assertTrue(cartPage.isProductInCart(purchaseData.getProduct().getProductId()),
                "Product not found in cart");

        // 10. Click Proceed To Checkout
        CheckoutPage checkoutPage = cartPage.proceedToCheckout();

        // 11. Review The Order
        Assert.assertTrue(checkoutPage.isProductInCheckout(purchaseData.getProduct().getProductId()),
                "Product not found in checkout");
        Assert.assertEquals(checkoutPage.getProductName(purchaseData.getProduct().getProductId()),
                purchaseData.getProduct().getName(),
                "Product name in checkout doesn't match");

        // 12. Click 'Place Order'
        PaymentPage paymentPage = checkoutPage.placeOrder();

        // 13. Enter payment details
        paymentPage.enterPaymentDetails(
                purchaseData.getPayment().getNameOnCard(),
                purchaseData.getPayment().getCardNumber(),
                purchaseData.getPayment().getCvc(),
                purchaseData.getPayment().getExpiryMonth(),
                purchaseData.getPayment().getExpiryYear());

        // 14. Click 'Pay and Confirm Order' button
        OrderPlacedPage orderPlacedPage = paymentPage.payAndConfirmOrder();

        // 15. Verify success message
        Assert.assertTrue(orderPlacedPage.isOrderPlacedSuccessfully(),
                "Order placed message is not visible");

        // 16. Click continue
        HomePage homePageAfterOrder = orderPlacedPage.clickContinue();

        // 17. Click logout
        SignupLoginPage loginPageAfterLogout = homePageAfterOrder.logout();

        // 18. Verify that user is navigated to login page
        Assert.assertTrue(loginPageAfterLogout.isLoginSectionVisible(),
                "User should be navigated to login page after logout");
    }

    @Test(dataProvider = "purchaseLoginData", dataProviderClass = TestDataProvider.class)
    public void testPurchaseFromProductDetails(PurchaseWithLoginData purchaseData) {
        // 1 & 2. Launch browser and navigate to url (handled in BaseTest)

        // 3. Verify that home page is visible successfully
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible(),
                "Home page is not visible");

        // 4. Click 'Signup / Login' button
        SignupLoginPage signupLoginPage = new Header(driver).navigateToSignupLoginPage();

        // 5. Fill email, password and click 'Login' button
        HomePage homePageAfterLogin = signupLoginPage.login(
                purchaseData.getUser().getEmail(),
                purchaseData.getUser().getPassword());

        // 6. Verify 'Logged in as username' at top
        Assert.assertTrue(homePageAfterLogin.isLoggedIn(),
                "User is not logged in");
        Assert.assertEquals(homePageAfterLogin.getLoggedInUsername(),
                purchaseData.getUser().getName(),
                "Logged in username does not match expected");

        // 7. Navigate to products page and view product details
        BaseProductsPage productsPage = new Header(driver).navigateToBaseProductsPage();
        ProductDetailsPage productDetailsPage = productsPage.navigateToProductDetailsPage(
                purchaseData.getProduct().getProductId());

        // 8. Verify that product detail is opened
        Assert.assertEquals(productDetailsPage.getProductName(), purchaseData.getProduct().getName(),
                "Not on the correct product page");

        // 9. Set quantity and add to cart
        productDetailsPage.setQuantity(purchaseData.getProduct().getQuantity())
                .addToCart();

        // 10. Click 'View Cart' button
        CartPage cartPage = productDetailsPage.clickViewCartFromPopup();

        // 11. Verify product is displayed in cart with correct quantity
        Assert.assertTrue(cartPage.isProductInCart(purchaseData.getProduct().getProductId()),
                "Product not found in cart");
        Assert.assertEquals(cartPage.getProductQuantity(purchaseData.getProduct().getProductId()),
                purchaseData.getProduct().getQuantity(),
                "Product quantity in cart doesn't match expected");

        // 12. Click Proceed To Checkout
        CheckoutPage checkoutPage = cartPage.proceedToCheckout();

        // 13. Review The Order
        Assert.assertTrue(checkoutPage.isProductInCheckout(purchaseData.getProduct().getProductId()),
                "Product not found in checkout");
        Assert.assertEquals(checkoutPage.getProductName(purchaseData.getProduct().getProductId()),
                purchaseData.getProduct().getName(),
                "Product name in checkout doesn't match");

        // 14. Click 'Place Order'
        PaymentPage paymentPage = checkoutPage.placeOrder();

        // 15. Enter payment details
        paymentPage.enterPaymentDetails(
                purchaseData.getPayment().getNameOnCard(),
                purchaseData.getPayment().getCardNumber(),
                purchaseData.getPayment().getCvc(),
                purchaseData.getPayment().getExpiryMonth(),
                purchaseData.getPayment().getExpiryYear());

        // 16. Click 'Pay and Confirm Order' button
        OrderPlacedPage orderPlacedPage = paymentPage.payAndConfirmOrder();

        // 17. Verify success message
        Assert.assertTrue(orderPlacedPage.isOrderPlacedSuccessfully(),
                "Order placed message is not visible");

        // 18. Click continue
        HomePage homePageAfterOrder = orderPlacedPage.clickContinue();

        // 19. Click logout
        SignupLoginPage loginPageAfterLogout = homePageAfterOrder.logout();

        // 20. Verify that user is navigated to login page
        Assert.assertTrue(loginPageAfterLogout.isLoginSectionVisible(),
                "User should be navigated to login page after logout");
    }
}