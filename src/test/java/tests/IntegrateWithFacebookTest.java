package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HomePage;

import static org.testng.Assert.assertEquals;

@Epic("Integrations")
@Feature("social media integration")
public class IntegrateWithFacebookTest extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void beforeMethodSetup() {
        homePage = new HomePage(driver);
    }


    @Test(description = "integrate with facebook")
    @Severity(SeverityLevel.MINOR)
    @Description("click on facebook logo and validate facebook web title")
    @Story("as a user I want to be able to integrate with facebook")
    public void tc01_integrateWithFacebook() {
        String ActualTitle = homePage.clickOnFacebookLogo();
        String ExpectedTitle = "Selenium Framework";
        assertEquals(ActualTitle, ExpectedTitle);
    }

}
