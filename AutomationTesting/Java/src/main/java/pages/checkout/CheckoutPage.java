package pages.checkout;

import pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.payment.PaymentPage;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//a[@href='/payment' and @class='btn btn-default check_out']")
    private WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage placeOrder() {
        click(placeOrderButton);
        return new PaymentPage(driver);
    }

    public boolean isProductInCheckout(int productId) {
        try {
            WebElement productElement = driver.findElement(
                    By.xpath("//tr[@id='product-" + productId + "']//a[@href='/product_details/" + productId + "']"));
            return productElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public int getProductQuantity(int productId) {
        WebElement quantityElement = driver.findElement(
                By.xpath("//tr[@id='product-" + productId + "']//td[@class='cart_quantity']/button"));
        return Integer.parseInt(getText(quantityElement));
    }

    public String getProductName(int productId) {
        WebElement nameElement = driver.findElement(
                By.xpath("//tr[@id='product-" + productId + "']//td[@class='cart_description']/h4/a"));
        return getText(nameElement);
    }
}