package pages.account;

import pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    private WebElement accountInformationHeader;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "first_name")
    private WebElement firstNameField;

    @FindBy(id = "last_name")
    private WebElement lastNameField;

    @FindBy(id = "company")
    private WebElement companyField;

    @FindBy(id = "address1")
    private WebElement addressField;

    @FindBy(id = "address2")
    private WebElement address2Field;

    @FindBy(id = "state")
    private WebElement stateField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "zipcode")
    private WebElement zipCodeField;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberField;

    @FindBy(xpath = "//input[@value='Mr']")
    private WebElement titleMrRadio;

    @FindBy(xpath = "//input[@value='Mrs']")
    private WebElement titleMrsRadio;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;

    @FindBy(name = "days")
    private WebElement daysDropdown;

    @FindBy(name = "months")
    private WebElement monthsDropdown;

    @FindBy(name = "years")
    private WebElement yearsDropdown;

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountInfoHeaderVisible() {
        return isElementDisplayed(accountInformationHeader);
    }

    public SignupPage selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            click(titleMrRadio);
        } else if (title.equalsIgnoreCase("Mrs")) {
            click(titleMrsRadio);
        }
        return this;
    }

    public SignupPage enterPassword(String password) {
        type(passwordField, password);
        return this;
    }

    public SignupPage selectDateOfBirth(String day, String month, String year) {
        selectByValue(daysDropdown, day);
        selectByValue(monthsDropdown, month);
        selectByValue(yearsDropdown, year);
        return this;
    }

    public SignupPage setNewsletter(boolean subscribe) {
        if (subscribe) {
            click(newsletterCheckbox);
        }
        return this;
    }

    public SignupPage setSpecialOffers(boolean subscribe) {
        if (subscribe) {
            click(specialOffersCheckbox);
        }
        return this;
    }

    public SignupPage enterAddressInfo(String firstName, String lastName, String company,
                                       String address, String address2, String state,
                                       String city, String zipCode, String mobileNumber) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(companyField, company);
        type(addressField, address);
        type(address2Field, address2);
        type(stateField, state);
        type(cityField, city);
        type(zipCodeField, zipCode);
        type(mobileNumberField, mobileNumber);
        return this;
    }

    public SignupPage selectCountry(String countryName) {
        selectByVisibleText(countryDropdown, countryName);
        return this;
    }

    public AccountCreatedPage clickCreateAccount() {
        click(createAccountButton);
        return new AccountCreatedPage(driver);
    }
}