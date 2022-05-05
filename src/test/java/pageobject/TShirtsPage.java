package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class TShirtsPage extends WomenPage{
    public TShirtsPage(WebDriver driver) {
        super(driver);
    }

    @Step("sort TShirt by your needs")
    public void sortTShirtBy(String category) {
        sortBy(category);
    }

    @Step("add TShirt product to cart")
    public void addTShirtProductToCart(String productName) {
        hoverOverTheProductAndAddToCart(productName);
    }
}
