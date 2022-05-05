package pageobject;

import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends HomePage {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#id_contact")
    WebElement subjectHeadingDropdownLocator;
    @FindBy(css = "#email")
    WebElement emailAddressFieldLocator;
    @FindBy(css = "#id_order")
    WebElement orderReferenceField;
    @FindBy(css = "#uniform-fileUpload .action")
    WebElement chooseFileLocator;
    @FindBy(css = "#message")
    WebElement messageFieldLocator;
    @FindBy(xpath = "//span[text()='Send']")
    WebElement sendButtonLocator;


    @Step("select a subject heading from dropdown")
    public void selectSubjectHeading(String text) {
        selectByText(subjectHeadingDropdownLocator, text);
    }

    @Step("Fill your email address")
    public void fillEmailAddress(String email) {
        fillText(emailAddressFieldLocator, email);
    }

    @Step("Fill the reference number")
    public void fillInOrderReferenceNumber(String referenceNumber) {
        fillText(orderReferenceField, referenceNumber);
    }

    @Step("This method uploads a file from a path in my computer")
    public ContactUsPage uploadFile(String filePath) {
        fillText(chooseFileLocator, filePath);
        return this;
    }

    @Step("Type the message that you want to send to contact customer service")
    public void typeContactMessage(String message) {
        fillText(messageFieldLocator, message);
    }

    @Step("This method validate if the send button is visible or displayed then if true it clicks on send")
    public void sendContactInfo() {
        Boolean sendButtonIsDisplayed = sendButtonLocator.isDisplayed();
        if (sendButtonIsDisplayed == true) {
            click(sendButtonLocator);
        }
    }
}
