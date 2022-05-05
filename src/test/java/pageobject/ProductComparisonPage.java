package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductComparisonPage extends WomenPage {
    public ProductComparisonPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".icon-trash")
    WebElement trashIconLocator;
    @FindBy(xpath = "//span[text()='View']")
    WebElement viewLocator;


    @Step("return product title")
    public String returnProductTitle(String itemName) {
        return getText(driver.findElement(By.xpath("//a[@title='" + itemName + "']")));
    }

    @Step("remove item by clicking on he trash icon")
    public void removeItem() {
        click(trashIconLocator);
    }

    @Step("click on add to cart button if actual product title matches expected title click on continue shopping else click on close button then clicks on homeLogoIcon")
    public void clickOnAddToCart(String productTitle, String expectedTitle) {
        if (returnProductTitle(productTitle).equalsIgnoreCase(expectedTitle)) {
            click(addToCartButton);
        }
        if (getAddedProductConfirmationText().equalsIgnoreCase("Product successfully added to your shopping cart")) {
            click(continueShoppingLocator);
        } else {
            click(closeWindowLocator);
        }
        click(homeLogo);

    }

    @Step("click on view button")
    public void clickOnView() {
        click(viewLocator);
    }
}
