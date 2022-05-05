package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.CreateAnAccountPage;
import pageobject.HomePage;
import pageobject.MyAccountPage;

@Epic("Account register")
@Feature("Account register and creation")
public class CreateAnAccountTest extends BaseTest {
    CreateAnAccountPage createAnAccountPage;
    MyAccountPage myAccountPage;
    HomePage homePage;

    @BeforeMethod
    public void beforeMethodSetup() {
        createAnAccountPage = new CreateAnAccountPage(driver);
        myAccountPage = new MyAccountPage(driver);
        homePage = new HomePage(driver);
    }

    @Test(description = "create an account")
    @Severity(SeverityLevel.BLOCKER)
    @Description("This test goes to the automation practice website and creates an account then validates page url")
    @Story("as a user I want the ability to create an account")
    public void tc01_createAnAccount() {
        homePage.clickOnSignIn();
        myAccountPage.createAnAccount("JamesMike1122@test.test");
        createAnAccountPage.clickOnMrRadioButton();
        createAnAccountPage.fillPersonalInformationFields("Mike", "James", "fakeMail@gmail.com", "Qa12345!", "1", "3", "2022");
        createAnAccountPage.fillAddressDetailsFields("Mike", "James", "AutomationJavaCompany", "22 jump street", "NY", "New York", "12121", "United States", "5559027");
        String Actual = createAnAccountPage.returnCurrentUrl();
        String Expected = "http://automationpractice.com/index.php?controller=my-account";
        assertEquals(Actual, Expected, "no such url in this page");
    }
}
