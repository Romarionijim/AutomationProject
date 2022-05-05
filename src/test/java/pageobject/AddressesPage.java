package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AddressesPage extends ShoppingCartSummaryPage {
    public AddressesPage(WebDriver driver) {
        super(driver);
    }

    @Step("click proceed to checkout")
    public void proceedToCheckout() {
        clickProceedToCheckout();
    }
}
