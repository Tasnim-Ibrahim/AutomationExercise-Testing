package pages.product;

import pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.cart.CartPage;

public class BaseProductsPage extends BasePage {

    @FindBy(css = ".title.text-center")
    protected WebElement productsTitle;

    @FindBy(xpath = "//div[@class='modal-content']//a[@href='/view_cart']")
    protected WebElement viewCartButton;

    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    protected WebElement continueShoppingButton;

    public BaseProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsPageVisible() {
        return isElementDisplayed(productsTitle);
    }

    public BaseProductsPage addToCart(int productId) {
        WebElement addToCartButton = driver.findElement(
                By.xpath("//div[@class='productinfo text-center']//a[@data-product-id='" + productId + "']"));
        click(addToCartButton);
        return this;
    }

    public BaseProductsPage hoverAndAddToCart(int productId) {
        // First locate the product card/wrapper containing the specific product ID
        WebElement productCard = driver.findElement(
                By.xpath("//a[@data-product-id='" + productId + "']"));

        // Hover over the product card to show the overlay
        hover(productCard);

        // Now click the add to cart button in the overlay that appears
        WebElement overlayAddToCartButton = driver.findElement(
                By.xpath("//div[@class='product-overlay']//a[@data-product-id='" + productId + "']"));
        click(overlayAddToCartButton);
        return this;
    }

    public CartPage clickViewCartFromPopup() {
        click(viewCartButton);
        return new CartPage(driver);
    }

    public BaseProductsPage clickContinueShoppingFromPopup() {
        click(continueShoppingButton);
        return this;
    }

    public ProductDetailsPage navigateToProductDetailsPage(int productId) {
        WebElement viewProductButton = driver.findElement(
                By.xpath("//a[@href='/product_details/" + productId + "']"));
        click(viewProductButton);
        return new ProductDetailsPage(driver);
    }

    public BrandProductsPage navigateToBrandProductsPage(String brandName) {
        WebElement brandLink = driver.findElement(
                By.xpath("//a[@href='/brand_products/" + brandName + "']"));
        click(brandLink);
        return new BrandProductsPage(driver);
    }

    public CategoryProductsPage navigateToCategoryProductsPage(int categoryId) {
        WebElement categoryLink = driver.findElement(
                By.xpath("//a[@href='/category_products/" + categoryId + "']"));
        click(categoryLink);
        return new CategoryProductsPage(driver);
    }

    public BaseProductsPage expandCategoryGroup(String categoryName) {
        WebElement categoryLink = driver.findElement(
                By.xpath("//a[@data-toggle='collapse'][@href='#" + categoryName + "'][contains(@class, 'collapsed')]"));
        click(categoryLink);
        return this;
    }

    public BaseProductsPage collapseCategoryGroup(String categoryName) {
        WebElement categoryLink = driver.findElement(
                By.xpath("//a[@data-toggle='collapse'][@href='#" + categoryName + "'][not(contains(@class, 'collapsed'))]"));
        click(categoryLink);
        return this;
    }

}