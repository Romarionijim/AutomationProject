package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.MyAccountPage;
import pageobject.ProductPage;

@Epic("product page miscellaneous")
@Feature("sending info to a friend")
public class SendProductDetailsToAFriendTest extends BaseTest {
    HomePage homepage;
    MyAccountPage myAccountPage;
    ProductPage productPage;

    @BeforeMethod
    public void beforeMethodSetup() {
        homepage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);
        productPage = new ProductPage(driver);
    }

    @Test(description = "send product to a friend")
    @Description("choose a product then navigate to product page and send the product details to a friend and validate confirmation popup text")
    @Severity(SeverityLevel.MINOR)
    @Story("as a user I want to be able top send the item info to a friend via product page")
    public void tc01_sendProductToAFriend() {
        homepage.clickOnSignIn();
        myAccountPage.signInToYourAccount("romario@test.test","Qa12345!");
        myAccountPage.clickOnHomeLogo();
        homepage.hoverOnProductAndClickOnProduct("Blouse");
        productPage.sendProductDetailsToFriend("James","James@test.test");
        //validate confirmation text that email was sent
        String ActualConfirmationPopupText = productPage.getDialogConfirmationText();
        String ExpectedPopupText = "Your e-mail has been sent successfully";
        assertEquals(ActualConfirmationPopupText,ExpectedPopupText);
        productPage.clickOnDialogPopupOkButton();
    }
}
