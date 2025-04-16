package pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class Footer extends BasePage {

    @FindBy(xpath = "//h2[text()='Subscription']")
    private WebElement subscriptionText;

    @FindBy(id = "susbscribe_email")
    private WebElement subscribeEmailInput;

    @FindBy(id = "subscribe")
    private WebElement subscribeButton;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    private WebElement subscriptionSuccessMessage;

    public Footer(WebDriver driver) {
        super(driver);
    }

    public Footer scrollToFooter() {
        scrollToBottom();
        return this;
    }

    public boolean isSubscriptionTextVisible() {
        return isElementDisplayed(subscriptionText);
    }

    public Footer subscribeWithEmail(String email) {
        type(subscribeEmailInput, email);
        click(subscribeButton);
        return this;
    }

    public boolean isSubscriptionSuccessful() {
        return isElementDisplayed(subscriptionSuccessMessage);
    }
}