package pages.account;

import pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.home.HomePage;

public class SignupLoginPage extends BasePage {

    // Login section elements
    @FindBy(xpath = "//h2[text()='Login to your account']")
    private WebElement loginHeader;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmailField;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement loginPasswordField;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    private WebElement loginErrorMessage;

    // Signup section elements
    @FindBy(xpath = "//h2[text()='New User Signup!']")
    private WebElement signupHeader;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement signupNameField;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement signupEmailField;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    private WebElement emailExistsErrorMessage;

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginSectionVisible() {
        return isElementDisplayed(loginHeader);
    }

    public HomePage login(String email, String password) {
        type(loginEmailField, email);
        type(loginPasswordField, password);
        click(loginButton);
        return new HomePage(driver);
    }

    public boolean isLoginErrorDisplayed() {
        return isElementDisplayed(loginErrorMessage);
    }

    public boolean isSignupSectionVisible() {
        return isElementDisplayed(signupHeader);
    }

    public SignupPage enterSignupDetails(String name, String email) {
        type(signupNameField, name);
        type(signupEmailField, email);
        click(signupButton);
        return new SignupPage(driver);
    }

    public boolean isEmailExistsErrorDisplayed() {
        return isElementDisplayed(emailExistsErrorMessage);
    }
}