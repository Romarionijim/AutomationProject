package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.CreateAnAccountPage;
import pageobject.HomePage;
import pageobject.MyAccountPage;

@Epic("Account register")
public class CreateAnAccountNegativeTest extends BaseTest {

    CreateAnAccountPage createAnAccountPage;
    MyAccountPage myAccountPage;
    HomePage homePage;

    @BeforeMethod
    public void beforeMethodSetup() {
        createAnAccountPage = new CreateAnAccountPage(driver);
        myAccountPage = new MyAccountPage(driver);
        homePage = new HomePage(driver);

    }

    @Test(description = "create an account negative test #1")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Create an account with an already existing email address and validate error exception text")
    public void tc01_createAnAccountNegativeTest01() {
        homePage.clickOnSignIn();
        myAccountPage.createAnAccount("hello@gmail.com");
        String Actual = myAccountPage.returnExceptionError();
        String Expected = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
        assertEquals(Actual, Expected, "no such error exception");
    }

    @Test(description = "create an account negative test #2")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Create an account without filling anything in the field then validate the error exception text")
    public void tc02_createAnAccountNegativeTest02() {
        homePage.clickOnSignIn();
        myAccountPage.createAnAccount("romarioTesting11@random.com");
        createAnAccountPage.clickOnRegisterButton();
        String Actual = createAnAccountPage.returnExceptionErrorHeaderText();
        String Expected = "There are 8 errors\n" +
                "You must register at least one phone number.\n" +
                "lastname is required.\n" +
                "firstname is required.\n" +
                "passwd is required.\n" +
                "address1 is required.\n" +
                "city is required.\n" +
                "The Zip/Postal code you've entered is invalid. It must follow this format: 00000\n" +
                "This country requires you to choose a State.";
        assertEquals(Actual, Expected);

    }

    @Test(description = "create an account negative test #3")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Create an account without giving a mobile phone number and validate error exception text")
    public void tc03_createAnAccountNegativeTest03() {
        homePage.clickOnSignIn();
        myAccountPage.createAnAccount("anotherAccountTest@Test.com");
        createAnAccountPage.fillPersonalInformationFields("Romario", "Nijim", "rom@test.com", "Qa12346!", "1", "1", "2022");
        createAnAccountPage.fillAddressDetailsFields("Romario", "Nijim", "AutomationCompany", "22 jump street", "NY", "New York", "00000", "United States", "");
        String Actual = createAnAccountPage.returnExceptionErrorHeaderText();
        String Expected = "There is 1 error\n" +
                "You must register at least one phone number.";
        assertEquals(Actual, Expected, "no such error exception");
    }
}
