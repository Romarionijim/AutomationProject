package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.ForgotPasswordPage;
import pageobject.HomePage;
import pageobject.MyAccountPage;

@Epic("Security")
@Feature("retrieve password")
public class ForgotPasswordTest extends BaseTest {
    HomePage homePage;
    MyAccountPage myAccountPage;
    ForgotPasswordPage forgotPasswordPage;


    @BeforeMethod
    @Description("set driver before every method")
    public void beforeMethodSetup() {
        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);

    }

    @Test(description = "forgot password test")
    @Severity(SeverityLevel.CRITICAL)
    @Description("go to my account page and click on password to retrieve and create a new password")
    @Story("as a user I want to be able to retrieve my password when needed")
    public void tc01_forgotPasswordTest() {
        homePage.clickOnSignIn();
        myAccountPage.clickOnForgotYourPassword();
        forgotPasswordPage.fillEmailAndClickOnRetrievePassword("romario@test.test");
        String ConfirmationText = forgotPasswordPage.returnConfirmationText();
        String Expected = "A confirmation email has been sent to your address: romario@test.test";
        assertEquals(ConfirmationText, Expected);

    }
}
