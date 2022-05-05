package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.MyAccountPage;
import pageobject.MyWishListPage;
import pageobject.ProductPage;

@Epic("WishList")
@Feature("add product to wishList")
public class AddProductToWishListTest extends BaseTest {
    HomePage homePage;
    MyAccountPage myAccountPage;
    ProductPage productPage;
    MyWishListPage myWishListPage;

    @BeforeMethod
    public void beforeMethodSetup() {
        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);
        productPage = new ProductPage(driver);
        myWishListPage = new MyWishListPage(driver);
    }

    @Test(description = "add product to wishlist")
    @Severity(SeverityLevel.MINOR)
    @Description("choose a product and click on it then add the product to wishlist")
    @Story("as a user I want to be able to add items to a wishList")
    public void tc01_addProductToWishListTest() {
        homePage.clickOnSignIn();
        myAccountPage.signInToYourAccount("romario@test.test", "Qa12345!");
        myAccountPage.clickOnHomeLogo();
        homePage.hoverOnProductAndClickOnProduct("Blouse");

        //validate item price
        String ActualProductPrice = productPage.getProductPriceValueText();
        String ExpectedProductPrice = "$27.00";
        assertEquals(ActualProductPrice, ExpectedProductPrice);

        //validate item added to wishlist
        productPage.addToWishList();
        String ActualConfirmationText = productPage.getWishListConfirmationText();
        String ExpectedConfirmationText = "Added to your wishlist.";
        assertEquals(ActualConfirmationText, ExpectedConfirmationText);
    }

    @Test(description = "validate wish list details on the wishList Table grid")
    @Severity(SeverityLevel.NORMAL)
    @Description("go to my account page and click on my wishlists and validate the wishlist details in the grid cells")
    @Story("validating the wish list details after adding a product to the wishlist")
    public void tc02_validateWishListDetailsOnGridTable() {
        homePage.clickOnMyCustomerAccountButton();
        myAccountPage.clickOnMyWishList();
        myWishListPage.validateWishListGridDetails(1,"My wishlist","16","2022-04-21");
    }
}
