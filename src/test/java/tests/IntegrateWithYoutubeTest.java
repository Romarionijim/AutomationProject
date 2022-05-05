package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;

import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HomePage;

@Epic("Integrations")
@Feature("social media integration")
public class IntegrateWithYoutubeTest extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void beforeMethodSetup() {
        homePage = new HomePage(driver);
    }

    @Test(description = "integrate with youtube")
    @Severity(SeverityLevel.MINOR)
    @Description("go to homePage and click on youtube logo then search for content on youtube web and validate the current url")
    @Story("as a user I want to be able to integrate with youtube")
    public void tc01_integrateWithYoutube() {
       String ActualUrl = homePage.clickOnYouTubeLogoAndSearchForContent("NBA highlights");
       String ExpectedUrl = "https://www.youtube.com/results?search_query=NBA+highlights";
       assertEquals(ActualUrl,ExpectedUrl);
    }
}
