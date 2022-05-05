package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.*;

@Epic("Transactions")
@Feature("buy product and checkout")
public class BuyProductAndCheckoutTest extends BaseTest {
    HomePage homepage;
    MyAccountPage myAccountPage;
    WomenPage womenPage;
    ShoppingCartSummaryPage shoppingCartSummaryPage;
    AddressesPage addressesPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;
    BankWirePaymentPage bankWirePaymentPage;
    ProductPage productPage;

    @BeforeMethod
    @Description("set driver before every method")
    public void beforeTest() {
        homepage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);
        womenPage = new WomenPage(driver);
        shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        addressesPage = new AddressesPage(driver);
        shippingPage = new ShippingPage(driver);
        paymentPage = new PaymentPage(driver);
        bankWirePaymentPage = new BankWirePaymentPage(driver);
        productPage = new ProductPage(driver);
    }

    @Test(description = "Buy a product end to end test")
    @Severity(SeverityLevel.CRITICAL)
    @Description("this test demo a purchase flow from the women page then proceed to checkout")
    @Story("as the main use case of this website - I should be able to purchase an item and checkout")
    public void tc01_buyProductAndCheckoutTest() {
        homepage.clickOnSignIn();
        myAccountPage.signInToYourAccount("romario@test.test", "Qa12345!");
        myAccountPage.clickOnWomenCategoryMenu();

        //choose product from list and add to cart then proceed to checkout
        homepage.hoverOnProductAndClickOnProduct("Blouse");
        productPage.addToCart();
        homepage.continueShopping();

        //click on home logo and add another product to cart
        homepage.clickHomeLogo();
        homepage.addItemToCartAndContinueShopping("Faded Short Sleeve T-shirts",1);

        //hover over cart and click on checkout button
        homepage.hoverOnCartDropdownAndCheckout();

        //validate product details in summaryPage
        String ActualResult = shoppingCartSummaryPage.returnProductDescriptionText(1, "Blouse","$27.00");
        String ExpectedResult = "Blouse";
        assertEquals(ActualResult, ExpectedResult);

        //validate second product in the summaryPage
        String ActualResult2 = shoppingCartSummaryPage.returnProductDescriptionText(2,"Faded Short Sleeve T-shirts","$16.51");
        String ExpectedResult2 = "Faded Short Sleeve T-shirts";
        assertEquals(ActualResult2,ExpectedResult2);

        //proceed to checkout
        shoppingCartSummaryPage.clickProceedToCheckout();
        addressesPage.proceedToCheckout();
        String ActualShippingPrice = shippingPage.returnShippingPrice("$2.00");
        String ExpectedShippingPrice = "$2.00";
        assertEquals(ActualShippingPrice,ExpectedShippingPrice);

        //check terms and conditions
        shippingPage.checkTermsOfServiceCheckBox();
        shippingPage.clickOnProceedToCheckOutButton();

        //pay for the item and confirm order
        paymentPage.clickOnPayByBankWire();

        //validate bank wire payment
        String ActualPayment = paymentPage.validateBankWireText();
        String ExpectedPayment = "BANK-WIRE PAYMENT.";
        assertEquals(ActualPayment,ExpectedPayment);

        //confirm order and validate order is completed
        bankWirePaymentPage.confirmOrder();
        String Actual = bankWirePaymentPage.returnConfirmationMessage();
        String Expected = "Your order on My Store is complete.";
        assertEquals(Actual, Expected);
    }
}
