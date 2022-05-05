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
public class LogoutTest extends BaseTest {
    MyAccountPage myAccountPage;
    HomePage homePage;

    @BeforeMethod
    public void beforeMethodSetup() {
        myAccountPage = new MyAccountPage(driver);
        homePage = new HomePage(driver);
    }

    @Test(priority = 1, description = "logout test")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login to the website with an existing email validate the user name is displayed with the relevant url and password and then logout and validate the sign in button changed and as well as the url")
    @Story("logging out from the website")
    public void tc01_logOutTest() {
        homePage.clickOnSignIn();
        myAccountPage.signInToYourAccount("romario@test.test","Qa12345!");
        //validate url after signing in
        String AfterSigningInUrl = myAccountPage.returnUrl();
        assertEquals(AfterSigningInUrl,"http://automationpractice.com/index.php?controller=my-account","no such url after signing in");
        //validate url after signing out
        myAccountPage.signOut();
        String AfterSigningOutUrl = myAccountPage.returnUrl();
        assertEquals(AfterSigningOutUrl,"http://automationpractice.com/index.php?controller=authentication&back=my-account","no such url after signing out");
    }
}
