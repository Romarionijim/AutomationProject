package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateAnAccountPage extends HomePage {
    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "#id_gender1")
    WebElement mrRadioButton;
    @FindBy(css = "#id_gender2")
    WebElement mrsRadioButton;
    @FindBy(css = "[name='id_gender']")
    List<WebElement> genderRadioButton;
    @FindBy(css = "#customer_firstname")
    WebElement firstNameFieldLocator;
    @FindBy(css = "#customer_lastname")
    WebElement lastNameFieldLocator;
    @FindBy(css = "#email")
    WebElement emailFieldLocator;
    @FindBy(css = "#passwd")
    WebElement passwordFieldLocator;
    @FindBy(css = "#days")
    WebElement daysDropdownSelection;
    @FindBy(css = "#months")
    WebElement monthDropdownSelection;
    @FindBy(css = "#years")
    WebElement yearDropdownSelection;
    @FindBy(xpath = "//input[@name='firstname']")
    WebElement addressFirstNameField;
    @FindBy(xpath = "//input[@name='lastname']")
    WebElement addressLastNameField;
    @FindBy(xpath = "//input[@name='company']")
    WebElement companyFieldLocator;
    @FindBy(xpath = "//input[@name='address1']")
    WebElement addressFieldLocator;
    @FindBy(xpath = "//input[@name='city']")
    WebElement cityLFieldLocator;
    @FindBy(css = "#id_state")
    WebElement stateDropdownSelection;
    @FindBy(css = "#postcode")
    WebElement zipPostalCodeField;
    @FindBy(css = "#id_country")
    WebElement countryDropdownSelection;
    @FindBy(css = "#other")
    WebElement additionalInformationLocator;
    @FindBy(css = "#phone")
    WebElement homePhoneLocator;
    @FindBy(css = "#phone_mobile")
    WebElement mobilePhoneLocator;
    @FindBy(css = "#alias")
    WebElement aliasAddressFieldLocator;
    @FindBy(css = "#submitAccount")
    WebElement registerButton;
    @FindBy(xpath = "//div[@class='alert alert-danger']")
    WebElement errorExceptionHeaderText;
    @FindBy(xpath = "//p[@class='inline-infos']")
    WebElement phoneMandatoryException;
    @FindBy(xpath = "//span[text()='(Five characters minimum)']")
    WebElement passwordMinimumCharactersNote;

    @Step("in this method we select a gender from the gender radio button")
    public CreateAnAccountPage selectTitle(String genderValue) {
        click(driver.findElement(By.xpath("//input[@value='" + genderValue + "']")));
        return this;
    }

    @Step("fill required personal information fields: full name, email, password and date of birth")
    public void fillPersonalInformationFields(String firstName, String lastName, String email, String password, String day, String month, String year) {
        fillText(firstNameFieldLocator, firstName);
        fillText(lastNameFieldLocator, lastName);
        fillText(emailFieldLocator, email);
        fillText(passwordFieldLocator, password);
        selectByValue(daysDropdownSelection, day);
        selectByValue(monthDropdownSelection, month);
        selectByValue(yearDropdownSelection, year);
    }

    @Step("This method validates the email that is already populated in the email field")
    public Boolean validateEmailValue(String emailValue) {
        WebElement populatedEmail = driver.findElement(By.xpath("//input[@id='email']"));
        if (populatedEmail.getText().equalsIgnoreCase(emailValue)) {
            return true;
        } else {
            return false;
        }
    }

    @Step("check MR. radio button")
    public void clickOnMrRadioButton() {
        click(mrRadioButton);
    }

    @Step("fill required address details: fullName, company, address, city, state, phone number and country")
    public void fillAddressDetailsFields(String firstName, String lastName, String company, String address, String city, String state, String zipCode, String country, String mobilePhone) {
        fillText(addressFirstNameField, firstName);
        fillText(addressLastNameField, lastName);
        fillText(companyFieldLocator, company);
        fillText(addressFieldLocator, address);
        fillText(cityLFieldLocator, city);
        selectByText(stateDropdownSelection, state);
        fillText(zipPostalCodeField, zipCode);
        selectByText(countryDropdownSelection, country);
        fillText(mobilePhoneLocator, mobilePhone);
        click(registerButton);
    }

    @Step("return exception text at the top of the page when something is missing or incorrect")
    public String returnExceptionErrorHeaderText() {
        waitForVisibility(errorExceptionHeaderText);
        return getText(errorExceptionHeaderText);
    }

    @Step("This method returns must register at least one phone text when leaving phone fields empty")
    public String returnMustRegisterOnePhoneException() {
        return getText(phoneMandatoryException);
    }

    @Step("This method returns the red marked required password characters exception")
    public String returnMinimumPasswordCharactersException() {
        return getText(passwordMinimumCharactersNote);
    }

    @Step("return the current page url")
    public String returnCurrentUrl() {
        String myAccountUrl = driver.getCurrentUrl();
        return myAccountUrl;
    }

    @Step("click on the register button")
    public void clickOnRegisterButton() {
        click(registerButton);
    }
}
