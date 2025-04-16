package pages.components;

import pages.account.SignupLoginPage;
import pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.cart.CartPage;
import pages.contact.ContactUsPage;
import pages.home.HomePage;
import pages.product.BaseProductsPage;

public class Header extends BasePage {

    @FindBy(xpath = "//a[@href='/']")
    private WebElement homeLink;

    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productsLink;

    @FindBy(xpath = "//a[@href='/view_cart']")
    private WebElement cartLink;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement SignuploginLink;

    @FindBy(xpath = "//a[@href='/test_cases']")
    private WebElement testCasesLink;

    @FindBy(xpath = "//a[@href='/api_list']")
    private WebElement apiTestingLink;

    @FindBy(xpath = "//a[@href='https://www.youtube.com/c/AutomationExercise']")
    private WebElement videoTutorialsLink;

    @FindBy(xpath = "//a[@href='/contact_us']")
    private WebElement contactUsLink;

    public Header(WebDriver driver) {
        super(driver);
    }

    public HomePage navigateToHomePage() {
        click(homeLink);
        return new HomePage(driver);
    }

    public BaseProductsPage navigateToBaseProductsPage() {
        click(productsLink);
        return new BaseProductsPage(driver);
    }

    public CartPage navigateToCartPage() {
        click(cartLink);
        return new CartPage(driver);
    }

    public SignupLoginPage navigateToSignupLoginPage() {
        click(SignuploginLink);
        return new SignupLoginPage(driver);
    }

    public ContactUsPage navigateToContactUsPage() {
        click(contactUsLink);
        return new ContactUsPage(driver);
    }

    public void navigateToVideoTutorialsPage() {
        click(videoTutorialsLink);
    }
}