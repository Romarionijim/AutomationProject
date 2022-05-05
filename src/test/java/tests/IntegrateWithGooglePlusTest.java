package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HomePage;

import static org.testng.Assert.assertEquals;

@Epic("Integrations")
@Feature("social media integration")
public class IntegrateWithGooglePlusTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void beforeMethodSetup() {
        homePage = new HomePage(driver);
    }

    @Test(description = "integrate with google plus")
    @Severity(SeverityLevel.MINOR)
    @Description("click on google logo and validate page title")
    @Story("as a user I want to be able to integrate with google plus")
    public void tc01_integrateWithGooglePlus() {
        String ActualWebTitle = homePage.clickOnGooglePlusLogo();
        String ExpectedWebTitle = "כניסה - חשבונות Google";
        assertEquals(ActualWebTitle,ExpectedWebTitle);
    }
}
