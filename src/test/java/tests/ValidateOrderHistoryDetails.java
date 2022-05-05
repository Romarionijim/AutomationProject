package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.MyAccountPage;
import pageobject.MyOrderHistoryPage;

@Epic("miscellaneous ")
@Feature("provide order history details grid")
public class ValidateOrderHistoryDetails extends BaseTest {
    HomePage homePage;
    MyAccountPage myAccountPage;
    MyOrderHistoryPage myOrderHistoryPage;

    @BeforeMethod
    public void beforeMethodSetup() {
        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);
        myOrderHistoryPage = new MyOrderHistoryPage(driver);
    }

    @Test(description = "validate order history details")
    @Description("go to my history page and validate the details of the purchase history that was made by the customer")
    @Story("order history details validation test")
    public void tc01_validateOrderHistoryDetailsTest() {
        homePage.clickOnSignIn();
        myAccountPage.signInToYourAccount("romario@test.test", "Qa12345!");
        myAccountPage.clickOnOrderHistoryAndDetails();
        myOrderHistoryPage.validateOrderHistoryDetails(1,"AXKWPTGWA","04/22/2022","$45.51","Bank wire");
    }
}
