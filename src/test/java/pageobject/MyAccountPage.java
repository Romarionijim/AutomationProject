package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends HomePage {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ol/li[text()][last()]")
    WebElement dynamicErrorException;
    @FindBy(xpath = " //li[text() = 'Invalid email address.']")
    WebElement invalidEmailException;
    @FindBy(xpath = " //li[text() = 'An email address required.']")
    WebElement emailIsRequiredException;
    @FindBy(css = "#email_create")
    WebElement createAccountEmailAddressField;
    @FindBy(css = "#SubmitCreate")
    WebElement createAnAccountButton;
    @FindBy(css = "#email")
    WebElement signInEmailAddressField;
    @FindBy(css = "#passwd")
    WebElement passwordField;
    @FindBy(xpath = "//a[@title='Recover your forgotten password']")
    WebElement forgotYourPasswordLocator;
    @FindBy(css = "#SubmitLogin")
    WebElement signInButton;
    @FindBy(xpath = "//span[text()='Order history and details']")
    WebElement orderHistoryAndDetailsButton;
    @FindBy(xpath = "//span[text()='My wishlists']")
    WebElement myWishListButtonLocator;
    @FindBy(xpath = "//span[text()='My credit slips']")
    WebElement myCreditSlipsLocator;
    @FindBy(xpath = "//span[text()='My addresses']")
    WebElement myAddressesLocator;
    @FindBy(xpath = "//span[text()='My personal information']")
    WebElement myPersonalInformationLocator;


    @Step("create an account and Fill in your email address")
    public void createAnAccount(String emailAddress) {
        fillText(createAccountEmailAddressField, emailAddress);
        click(createAnAccountButton);
    }

    @Step("Sign in with your existing email and password")
    public void signInToYourAccount(String emailAddress, String password) {
        fillText(signInEmailAddressField, emailAddress);
        fillText(passwordField, password);
        click(signInButton);
    }

    @Step("click on forgot password to change it")
    public void clickOnForgotYourPassword() {
        click(forgotYourPasswordLocator);
    }

    @Step("This method returns error exception when email is required")
    public String returnErrorException() {
        return getText(emailIsRequiredException);
    }


    @Step("This method returns an invalid email exception when signing in with invalid details")
    public String returnInvalidEmailException() {
        return getText(invalidEmailException);

    }

    @Step("This method returns an error when an exception is thrown")
    public String returnExceptionError() {
        return getText(dynamicErrorException);
    }

    @Step("click on order history and details")
    public void clickOnOrderHistoryAndDetails() {
        click(orderHistoryAndDetailsButton);
    }

    @Step("click on my wishList")
    public void clickOnMyWishList() {
        click(myWishListButtonLocator);
    }

    @Step("click on my addresses")
    public void clickOnMyAddresses() {
        click(myAddressesLocator);
    }

    @Step("click on my personal information")
    public void clickOnMyPersonalInformation() {
        click(myPersonalInformationLocator);
    }

    @Step("click on my credit lips")
    public void clickOnMyCreditLips() {
        click(myCreditSlipsLocator);
    }

    @Step("return the current page url")
    public String returnUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    @Step("click on the homePage logo")
    public void clickOnHomeLogo() {
        clickHomeLogo();
    }

    @Step("return signIn inner text")
    public String getSignInButtonInnerText() {
        return getText(signInButton);
    }
}
