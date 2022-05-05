package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BankWirePaymentPage extends HomePage{
    public BankWirePaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='I confirm my order']")
    WebElement IConfirmMyOrderButtonLocator;
    @FindBy(css = ".button-exclusive.btn.btn-default")
    WebElement otherPaymentMethodsLocator;
    @FindBy(xpath = "//strong[text()='Your order on My Store is complete.']")
    WebElement orderConfirmationMessage;
    @FindBy(css = ".button-exclusive.btn.btn-default")
    WebElement backToOrdersLocator;


    @Step("click on I confirm my order button")
    public void confirmOrder() {
        click(IConfirmMyOrderButtonLocator);
    }

    @Step("click on other payment methods")
    public void clickOtherPaymentMethods() {
        click(otherPaymentMethodsLocator);
    }

    @Step("return confirmation message after purchase")
    public String returnConfirmationMessage() {
        return getText(orderConfirmationMessage);
    }

    @Step("click on back to orders")
    public void clickOnBackToOrders() {
        click(backToOrdersLocator);
    }
}
