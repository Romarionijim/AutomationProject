package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartSummaryPage extends HomePage {
    public ShoppingCartSummaryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#total_product")
    WebElement totalProductsLocator;
    @FindBy(css = "#total_shipping")
    WebElement totalShippingLocator;
    @FindBy(css = "#total_tax")
    WebElement taxLocator;
    @FindBy(css = "#total_price")
    WebElement totalPriceLocator;
    @FindBy(xpath = "//td[@class='cart_description']/p")
    WebElement productDescription;
    @FindBy(xpath = "//tbody/tr")
    WebElement webTableRowNumber;
    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    WebElement proceedToCheckOutButton;
    @FindBy(xpath = "//a[@title='Continue shopping']")
    WebElement continueShopping;

    @Step("return total product price string text")
    public String returnTotalProductsPrice() {
        return getText(totalProductsLocator);
    }

    @Step("return total shipping price string text")
    public String returnTotalSippingPrice() {
        return getText(totalShippingLocator);
    }

    @Step("return total tax price string text")
    public String returnTotalTaxPrice() {
        return getText(taxLocator);
    }

    @Step("return total price amount string text")
    public String returnTotalPriceAmount() {
        return getText(totalPriceLocator);
    }

    @Step("This method validates product description and unit price td cells text if it matches the current parameters")
    public String returnProductDescriptionText(int rowNumber, String productCell, String unitPrice) {
        String[] details = {productCell, unitPrice};
        for (int i = 0; i < details.length; i++) {
            if (i == 1 && i == 0) {
                WebElement productDescriptionCell = driver.findElement(By.xpath("//tbody/tr[' " + rowNumber + " ']/td[" + i + 1 + "]"));
                continue;
            }
            return details[i];
        }
        return null;
    }

    @Step("click proceed to checkout if button is displayed else click on continue shopping")
    public void clickProceedToCheckout() {
        Boolean isVisible = proceedToCheckOutButton.isDisplayed();
        if (isVisible == true) {
            click(proceedToCheckOutButton);
        } else
            click(continueShopping);
    }
}
