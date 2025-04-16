package pages.payment;

import pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    @FindBy(css = "h2.heading")
    private WebElement pageHeading;

    @FindBy(name = "name_on_card")
    private WebElement nameOnCardField;

    @FindBy(name = "card_number")
    private WebElement cardNumberField;

    @FindBy(name = "cvc")
    private WebElement cvcField;

    @FindBy(name = "expiry_month")
    private WebElement expiryMonthField;

    @FindBy(name = "expiry_year")
    private WebElement expiryYearField;

    @FindBy(id = "submit")
    private WebElement payAndConfirmOrderButton;

    @FindBy(css = ".alert-success.alert")
    private WebElement successMessage;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnPaymentPage(String expectedHeading) {
        return isElementDisplayed(pageHeading) && getText(pageHeading).equals(expectedHeading);
    }

    public PaymentPage enterPaymentDetails(String nameOnCard, String cardNumber,
                                           String cvc, String expiryMonth, String expiryYear) {
        type(nameOnCardField, nameOnCard);
        type(cardNumberField, cardNumber);
        type(cvcField, cvc);
        type(expiryMonthField, expiryMonth);
        type(expiryYearField, expiryYear);
        return this;
    }

    public OrderPlacedPage payAndConfirmOrder() {
        click(payAndConfirmOrderButton);
        return new OrderPlacedPage(driver);
    }

    public boolean isOrderSuccessful() {
        return isElementDisplayed(successMessage);
    }

    public String getSuccessMessage() {
        return getText(successMessage);
    }
}