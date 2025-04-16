package pages.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import pages.home.HomePage;

public class ContactUsPage extends BasePage {

    @FindBy(xpath = "//h2[@class='title text-center' and text()='Get In Touch']")
    private WebElement getInTouchHeader;

    @FindBy(name = "name")
    private WebElement nameField;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "subject")
    private WebElement subjectField;

    @FindBy(id = "message")
    private WebElement messageTextarea;

    @FindBy(name = "submit")
    private WebElement submitButton;

    @FindBy(css = ".status.alert.alert-success")
    private WebElement successMessage;

    @FindBy(xpath = "//a[@class='btn btn-success']")
    private WebElement homeButton;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isGetInTouchHeaderVisible() {
        return isElementDisplayed(getInTouchHeader);
    }

    public ContactUsPage enterContactDetails(String name, String email, String subject, String message) {
        type(nameField, name);
        type(emailField, email);
        type(subjectField, subject);
        type(messageTextarea, message);
        return this;
    }

    public ContactUsPage submitForm() {
        click(submitButton);
        // Handle the alert
        driver.switchTo().alert().accept();
        return this;
    }

    public boolean isSuccessMessageVisible() {
        return isElementDisplayed(successMessage);
    }

    public String getSuccessMessageText() {
        return getText(successMessage);
    }

    public HomePage clickHomeButton() {
        click(homeButton);
        return new HomePage(driver);
    }
}