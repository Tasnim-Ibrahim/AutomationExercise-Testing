package pages.home;

import pages.base.BasePage;
import pages.account.SignupLoginPage;
import pages.account.AccountDeletedPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(text(), ' Logged in as')]")
    private WebElement loggedInElement;

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//a[@href='/delete_account']")
    private WebElement deleteAccountButton;

    @FindBy(css = ".carousel-inner")
    private WebElement slider;

    @FindBy(css = "a.left.control-carousel.hidden-xs")
    private WebElement prevSlideButton;

    @FindBy(css = "a.right.control-carousel.hidden-xs")
    private WebElement nextSlideButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageVisible() {
        return isElementDisplayed(slider);
    }

    public boolean isLoggedIn() {
        return isElementDisplayed(loggedInElement);
    }

    public String getLoggedInUsername() {
        String fullText = getText(loggedInElement);
        return fullText.replace("Logged in as ", "").trim();
    }

    public boolean isCorrectUserLoggedIn(String expectedUsername) {
        return getLoggedInUsername().equals(expectedUsername);
    }

    public AccountDeletedPage navigateToDeleteAccountPage() {
        click(deleteAccountButton);
        return new AccountDeletedPage(driver);
    }

    public HomePage clickPreviousSlide() {
        click(prevSlideButton);
        return this;
    }

    public HomePage clickNextSlide() {
        click(nextSlideButton);
        return this;
    }

    public SignupLoginPage logout() {
        click(logoutButton);
        return new SignupLoginPage(driver);
    }
}