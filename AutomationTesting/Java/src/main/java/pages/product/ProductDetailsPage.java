package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BaseProductsPage {

    @FindBy(xpath = "//button[@class='btn btn-default cart']")
    private WebElement addToCartButton;

    @FindBy(id = "quantity")
    private WebElement quantityInput;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "review")
    private WebElement reviewTextarea;

    @FindBy(id = "button-review")
    private WebElement submitReviewButton;

    @FindBy(xpath = "//div[@class='product-information']/h2")
    private WebElement productName;

    @FindBy(xpath = "//div[@class='alert-success alert']/span[contains(text(), 'Thank you for your review')]")
    private WebElement reviewSuccessMessage;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return getText(productName);
    }

    public boolean isCorrectProductPage(String expectedProductName) {
        return getProductName().equals(expectedProductName);
    }

    public ProductDetailsPage setQuantity(int quantity) {
        quantityInput.clear();
        type(quantityInput, String.valueOf(quantity));
        return this;
    }

    public ProductDetailsPage addToCart() {
        click(addToCartButton);
        return this;
    }

    public ProductDetailsPage submitReview(String name, String email, String reviewText) {
        type(nameInput, name);
        type(emailInput, email);
        type(reviewTextarea, reviewText);
        click(submitReviewButton);
        return this;
    }

    public boolean isReviewSubmittedSuccessfully() {
        return isElementDisplayed(reviewSuccessMessage);
    }
}