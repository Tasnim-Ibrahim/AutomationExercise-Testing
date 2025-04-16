package pages.cart;

import pages.account.SignupLoginPage;
import pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.checkout.CheckoutPage;

public class CartPage extends BasePage {

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//div[@class='modal-content']//a[@href='/login']")
    private WebElement registerLoginLink;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public SignupLoginPage clickRegisterLoginLink() {
        click(registerLoginLink);
        return new SignupLoginPage(driver);
    }

    public CheckoutPage proceedToCheckout() {
        click(proceedToCheckoutButton);
        return new CheckoutPage(driver);
    }

    public boolean isProductInCart(int productId) {
        try {
            WebElement productElement = driver.findElement(
                    By.xpath("//a[@href='/product_details/" + productId + "']"));
            return productElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public CartPage removeProduct(int productId) {
        WebElement removeButton = driver.findElement(
                By.xpath("//a[@class='cart_quantity_delete'][@data-product-id='" + productId + "']"));
        click(removeButton);
        return this;
    }

    public int getProductQuantity(int productId) {
        WebElement quantityElement = driver.findElement(
                By.xpath("//tr[@id='product-"+productId+"']//td[@class='cart_quantity']"));
        return Integer.parseInt(getText(quantityElement));
    }
}