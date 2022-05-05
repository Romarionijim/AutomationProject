package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HomePage;

@Epic("Transactions")
@Feature("remove item from cart")
public class RemoveItemFromCartTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void beforeMethodSetup() {
        homePage = new HomePage(driver);
    }

    @Test(description = "remove item from cart test")
    @Severity(SeverityLevel.CRITICAL)
    @Description("add item to cart then remove the item from the cart and validate cart details changed")
    @Story("as a user I want the ability to remove items from the cart")
    public void tc01_removeItemFromCartTest() {
        homePage.addItemToCartAndContinueShopping("Blouse", 2);
        //get cart items number
        String ActualCartItemNumber = homePage.getCartStatus(1);
        String ExpectedCartItemNumber = "1";
        assertEquals(ActualCartItemNumber, ExpectedCartItemNumber);
        //remove item from cart
        homePage.removeProductFromCartDropdown();
        //validate cart is empty after removing the item from the cart
        String ActualCartStatus = homePage.getCartStatus(5);
        String ExpectedCartStatus = "(empty)";
        assertEquals(ActualCartStatus, ExpectedCartStatus);
    }
}
