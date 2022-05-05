package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChequePaymentPage extends HomePage{
    public ChequePaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[text()='Check payment']")
    WebElement checkPaymentHeaderText;
    @FindBy(xpath = "//span[text()='I confirm my order']")
    WebElement confirmOrderButton;
    @FindBy(xpath = "//strong[text()='Your order on My Store is complete.']")
    WebElement orderConfirmationMessage;
    @FindBy(css = ".button-exclusive.btn.btn-default")
    WebElement backToOrdersLocator;

    @Step("return cheque payment header text")
    public String returnPaymentHeaderText() {
        return getText(checkPaymentHeaderText);
    }

    @Step("click on I confirm my order button")
    public void clickOnConfirmMyOrder() {
        click(confirmOrderButton);
    }

    @Step("return order confirmation text")
    public String returnOrderConfirmationText() {
        return getText(orderConfirmationMessage);
    }

    @Step("click on back to orders")
    public void clickOnBackToOrdersButton() {
        click(backToOrdersLocator);
    }
}
