package pages.account;

import pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.home.HomePage;

public class AccountDeletedPage extends BasePage {

    @FindBy(xpath = "//h2[@data-qa='account-deleted']")
    private WebElement accountDeletedMessage;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountDeletedSuccessfully() {
        return isElementDisplayed(accountDeletedMessage);
    }

    public HomePage clickContinue() {
        click(continueButton);
        return new HomePage(driver);
    }
}