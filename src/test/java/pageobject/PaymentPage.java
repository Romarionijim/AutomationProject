package pageobject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends ShoppingCartSummaryPage {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Pay by bank wire']")
    WebElement payByBankWireLocator;
    @FindBy(xpath = "//a[@title='Pay by check.']")
    WebElement payByCheckLocator;
    @FindBy(xpath = "//h3[@class='page-subheading']")
    WebElement bankWireText;

    @Step("click on pay by bank wire")
    public void clickOnPayByBankWire() {
        click(payByBankWireLocator);
    }

    @Step("click on pay by check")
    public void clickOnPayByCheck() {
        click(payByCheckLocator);
    }

    @Step("validate the bank wire text innerText")
    public String validateBankWireText() {
        return getText(bankWireText);
    }
}
