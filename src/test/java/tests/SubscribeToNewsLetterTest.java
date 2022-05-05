package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HomePage;

@Epic("News letter subscription")
@Feature("subscribe to news letter")
public class SubscribeToNewsLetterTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void beforeMethodSetup() {
        homePage = new HomePage(driver);
    }

    @Test(description = "subscribe to news letter")
    @Severity(SeverityLevel.MINOR)
    @Description("subscribe to newsletter submit and validate confirmation text")
    @Story("as a newsLetter follower and subscriber I would like the ability to subscribe to a news letter")
    public void tc01_subscribeToNewsLetterTest() {
        homePage.enterEmailToGetNewsLetter("James@test.newTestEmail");
        String ActualConfirmationText = homePage.getNewsLetterAlertText();
        String Expected = "Newsletter : You have successfully subscribed to this newsletter.";
        assertEquals(ActualConfirmationText, Expected);
    }
}
