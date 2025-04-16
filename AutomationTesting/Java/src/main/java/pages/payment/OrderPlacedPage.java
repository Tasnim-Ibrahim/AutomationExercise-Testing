package pages.payment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import pages.home.HomePage;

public class OrderPlacedPage extends BasePage {

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    @FindBy(css = ".title.text-center")
    private WebElement orderPlacedMessage;

    public OrderPlacedPage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickContinue() {
        click(continueButton);
        return new HomePage(driver);
    }

    public boolean isOrderPlacedSuccessfully() {
        return isElementDisplayed(orderPlacedMessage);
    }
}