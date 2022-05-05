package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.MyAccountPage;

@Epic("Security")
@Feature("user authentication")
public class LoginTest extends BaseTest {
    MyAccountPage myAccountPage;
    HomePage homePage;

    @BeforeMethod
    public void beforeMethodSetup() {
    myAccountPage = new MyAccountPage(driver);
    homePage = new HomePage(driver);
    }

    @Test(description = "login test")
    @Severity(SeverityLevel.BLOCKER)
    @Description("this is test to login with an email address and a password to automation practice website then validate url")
    @Story("logging to the website")
    public void tc01_LoginTest() {
        homePage.clickOnSignIn();
        myAccountPage.signInToYourAccount("romario@test.test","Qa12345!");
        String myAccountUrl = myAccountPage.returnUrl();
        assertEquals(myAccountUrl,"http://automationpractice.com/index.php?controller=my-account","no such url address");
    }
}
