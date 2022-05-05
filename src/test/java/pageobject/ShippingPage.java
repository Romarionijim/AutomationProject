package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends ShoppingCartSummaryPage {
    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//tr/td[3]")
    WebElement deliveryCellLocator;
    @FindBy(xpath = "//tr/td[4]/div")
    WebElement shippingPriceCell;
    @FindBy(css = "#uniform-cgv")
    WebElement termsOfService;
    @FindBy(xpath = "//p[@class='fancybox-error']")
    WebElement popupAlertMessage;
    @FindBy(xpath = "//button[@name='processCarrier']/span")
    WebElement proceedToCheckout;

    @Step("return delivery detail")
    public String returnDeliveryDetail(String deliveryDetail) {
        if (deliveryCellLocator.getText().contains(deliveryDetail)) {

        }
        return getText(deliveryCellLocator);
    }

    @Step("return shipping price")
    public String returnShippingPrice(String price) {
        if (shippingPriceCell.getText().equalsIgnoreCase(price)) {

        }
        return getText(shippingPriceCell);
    }

    @Step("click on proceed to checkout")
    public void clickOnProceedToCheckOutButton() {
        click(proceedToCheckout);
    }

    @Step("check terms of service checkbox if it is enabled")
    public void checkTermsOfServiceCheckBox() {
        Boolean termsOfServiceCheckBoxIsEnabled = termsOfService.isSelected();
        if (termsOfServiceCheckBoxIsEnabled == false) {
            click(termsOfService);
        }
    }

    @Step("return popupMessage after clicking on proceed to checkout without checking the terms checkBOX")
    public String returnPopupMessage() {
        return getText(popupAlertMessage);
    }
}
