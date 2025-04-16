package pages.account;

import pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.home.HomePage;

public class AccountCreatedPage extends BasePage {

    @FindBy(xpath = "//h2[@data-qa='account-created']/b")
    private WebElement successMessage;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountCreatedSuccessfully() {
        return isElementDisplayed(successMessage) &&
                getText(successMessage).contains("ACCOUNT CREATED");
    }

    public HomePage clickContinue() {
        click(continueButton);
        return new HomePage(driver);
    }
}