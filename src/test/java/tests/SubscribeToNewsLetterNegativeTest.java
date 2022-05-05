package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HomePage;

import static org.testng.Assert.assertEquals;

@Epic("News letter subscription")
public class SubscribeToNewsLetterNegativeTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void beforeMethodSetup() {
        homePage = new HomePage(driver);
    }

    @Test(description = "subscribe for a newsletter negative test 01")
    @Severity(SeverityLevel.MINOR)
    @Description("subscribe to newsletter with an already subscribed email")
    @Story("news letter subscription negative testing")
    public void tc01_subscribeToNewsLetterNegativeTest01() {
        homePage.enterEmailToGetNewsLetter("romario@test.newTestEmail");
        String ActualConfirmationText = homePage.getNegativeNewsLetterAlert();
        String Expected = "Newsletter : This email address is already registered.";
        assertEquals(ActualConfirmationText, Expected);
    }

    @Test(description = "subscribe for a newsletter negative test 02")
    @Severity(SeverityLevel.MINOR)
    @Description("subscribe to newsletter with an invalid email")
    @Story("news letter subscription negative testing")
    public void tc02_subscribeToNewsLetterNegativeTest02() {
        homePage.enterEmailToGetNewsLetter("romario");
        String ActualConfirmationText = homePage.getNegativeNewsLetterAlert();
        String Expected = "Newsletter : Invalid email address.";
        assertEquals(ActualConfirmationText, Expected);
    }
}
