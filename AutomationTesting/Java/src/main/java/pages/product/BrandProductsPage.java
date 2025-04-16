package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrandProductsPage extends BaseProductsPage {

    @FindBy(css = ".title.text-center")
    private WebElement brandTitle;

    public BrandProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getBrandTitle() {
        return getText(brandTitle);
    }
}