package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends MyAccountPage {
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Retrieve Password']")
    WebElement retrievePasswordButton;
    @FindBy(xpath = "//a[@title='Back to Login']")
    WebElement backToLoginButton;
    @FindBy(xpath = "//P[@class='alert alert-success']")
    WebElement passwordRetrieveConfirmationText;
    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement confirmationTextLocator;

    @Step("fill your email then click on retrieve password")
    public void fillEmailAndClickOnRetrievePassword(String email) {
        fillText(signInEmailAddressField, email);
        click(retrievePasswordButton);
    }

    @Step("click on back to login button")
    public void clickOnBackToLogin() {
        click(backToLoginButton);
    }

    @Step("get confirmation text after retrieving password")
    public String getConfirmationText() {
        return getText(passwordRetrieveConfirmationText);
    }

    @Step("return error exception")
    public String returnErrorException() {
        return getText(dynamicErrorException);
    }

    @Step("return confirmation text after retrieving password")
    public String returnConfirmationText() {
        return getText(confirmationTextLocator);
    }
}
