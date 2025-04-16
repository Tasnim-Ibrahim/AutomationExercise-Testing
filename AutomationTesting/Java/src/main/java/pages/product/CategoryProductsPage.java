package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryProductsPage extends BaseProductsPage {

    @FindBy(css = ".title.text-center")
    private WebElement categoryTitle;

    public CategoryProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getCategoryTitle() {
        return getText(categoryTitle);
    }
}