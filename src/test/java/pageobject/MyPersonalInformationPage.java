package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyPersonalInformationPage extends CreateAnAccountPage{
    public MyPersonalInformationPage(WebDriver driver) {
        super(driver);
    }

    @Step("return first name field string")
    public String validateFirstNameField() {
        return getText(firstNameFieldLocator);
    }

    @FindBy(css = "#firstname")
    WebElement firstNameField;
    @FindBy(css = "#lastname")
    WebElement lastNameField;
    @FindBy(css = "email")
    WebElement emailField;

    @Step("return firstName String text")
    public String validateFirstNameString() {
        return getText(firstNameField);
    }

    @Step("return lastName String text")
    public String validateLastNameString() {
        return getText(lastNameField);
    }

    @Step("return email address string text")
    public String validateEmailAddressString() {
        return getText(emailField);
    }

    @Step("click on homePage logo")
    public void goToHomePage() {
        clickHomeLogo();
    }
}
