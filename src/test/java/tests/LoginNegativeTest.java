package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.MyAccountPage;

import static org.testng.Assert.*;

@Epic("Security")
public class LoginNegativeTest extends BaseTest {
    MyAccountPage myAccountPage;
    HomePage homePage;

    @BeforeMethod
    public void beforeMethodSetup() {
        myAccountPage = new MyAccountPage(driver);
        homePage = new HomePage(driver);
    }

    @Test(description = "login negative test with invalid email")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Login with an invalid email address")
    @Story("login negative testing")
    public void tc01_loginNegativeTest01() {
        homePage.clickOnSignIn();
        myAccountPage.signInToYourAccount("invalid email", "Qa12345!");
        String ActualException = myAccountPage.returnExceptionError();
        String Expected = "Invalid email address.";
        assertEquals(ActualException, Expected);
    }

    @Test(description = "login negative test with invalid password")
    @Severity(SeverityLevel.BLOCKER)
    @Description("login with an invalid password and validate error message")
    @Story("login negative testing")
    public void tc02_loginNegativeTest02() {
        homePage.clickOnSignIn();
        myAccountPage.signInToYourAccount("romario@test.test", "wrongPassword");
        String ActualException = myAccountPage.returnExceptionError();
        String Expected = "Authentication failed.";
        assertEquals(ActualException, Expected);
    }

    @Test(description = "login with leaving email field empty")
    @Severity(SeverityLevel.BLOCKER)
    @Description("click on sign in and login by leaving email field empty and validate error message")
    @Story("login negative testing")
    public void tc03_loginNegativeText03() {
        homePage.clickOnSignIn();
        myAccountPage.signInToYourAccount("", "Qa12345!");
        String ActualException = myAccountPage.returnExceptionError();
        String Expected = "An email address required.";
        assertEquals(ActualException, Expected, "no such exception text");
    }

    @Test(description = "login without filling in password field")
    @Severity(SeverityLevel.BLOCKER)
    @Description("click on sign in and try to login without filling the password field and validate the error message")
    @Story("login negative testing")
    public void tc04_loginNegativeTest04() {
        homePage.clickOnSignIn();
        myAccountPage.signInToYourAccount("romario@test.test", "");
        String ActualException = myAccountPage.returnExceptionError();
        String Expected = "Password is required.";
        assertEquals(ActualException, Expected, "no such error message");
    }

//    @Description("this method stores invalid and valid emails and passwords formats to fill in the login fields for negative testing")
//    public Object[][] getData() {
//        Object[][] myData = {
//                {"noSuchEmail", "Qa12345!"},
//                {"romario@test.test", "randomPassword"},
//                {"", "Qa12345!"},
//                {"romario@test.test", ""},
//
//        };
//        return myData;
//    }

}
