package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HomePage;

import static org.testng.Assert.assertEquals;

@Epic("Integrations")
@Feature("social media integration")
public class IntegrateWithTwitterTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void beforeMethodSetup() {
        homePage = new HomePage(driver);
    }

    @Test(description = "integrate with twitter")
    @Severity(SeverityLevel.MINOR)
    @Description("click on twitter logo and validate page title")
    @Story("as a user I want to be able to integrate with twitter")
    public void tc01_integrateWithTwitter() {
        String ActualPageTitle = homePage.clickOnTwitterLogo();
        String ExpectedPageTitle = "Selenium Framework (@seleniumfrmwrk) / Twitter";
        assertEquals(ActualPageTitle,ExpectedPageTitle);
    }

}
