package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends HomePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#quantity_wanted")
    WebElement productQuantityLocator;
    @FindBy(css = "[itemprop='name']")
    WebElement productNameHeader;
    @FindBy(css = "#our_price_display")
    WebElement priceLocator;
    @FindBy(css = "#send_friend_button")
    WebElement sendToAFriendLocator;
    @FindBy(css = "#friend_name")
    WebElement friendNameFieldLocator;
    @FindBy(css = "#friend_email")
    WebElement friendEmailAddressField;
    @FindBy(css = "#sendEmail")
    WebElement sendToFriendSendButton;
    @FindBy(css = ".print>a")
    WebElement printLocator;
    @FindBy(css = ".btn.btn-default.button-plus.product_quantity_up")
    WebElement increaseQuantityPlusButton;
    @FindBy(css = ".btn.btn-default.button-minus.product_quantity_down")
    WebElement decreaseQuantityMinusButton;
    @FindBy(css = "#add_to_cart>button")
    WebElement addToCartButton;
    @FindBy(css = "#wishlist_button")
    WebElement addToWishListLocator;
    @FindBy(xpath = "//span[@class='span_link no-print']")
    WebElement viewProductImageLargerLocator;
    @FindBy(css = "#group_1")
    WebElement sizeDropDownLocator;
    @FindBy(css = "#color_to_pick_list>li")
    WebElement productColorLocator;
    @FindBy(xpath = "//p[text()='Your e-mail has been sent successfully']")
    WebElement confirmationDialogText;
    @FindBy(xpath = "//input[@class='button']")
    WebElement confirmationDialogOkButton;
    @FindBy(xpath = "//p[text()='You must be logged in to manage your wishlist.']")
    WebElement mustBeLoggedToAddToWishListInText;
    @FindBy(xpath = "//p[text()='Added to your wishlist.']")
    WebElement addedToWishListTextLocator;

    @Step("This method returns the header innerText of the product title")
    public String getProductHeaderTitle() {
        return getText(productNameHeader);
    }

    @Step("This method returns the item quantity")
    public String getProductQuantity() {
        return getText(productQuantityLocator);
    }

    @Step("Increase product quantity by 3 times")
    public void increaseProductQuantity() {
        for (int i = 0; i <= 3 ; i++) {
            click(increaseQuantityPlusButton);
        }
    }

    @Step("Decrease product quantity by 2 times")
    public void decreaseProductQuantity() {
        for (int i = 0; i <=2 ; i++) {
            click(decreaseQuantityMinusButton);
        }
    }

    @Step("click on add to cart button")
    public void addToCart() {
        click(addToCartButton);
    }

    @Step("click on send to a friend and fill the details in the dialog then validates the confirmation text after sending the details")
    public void sendProductDetailsToFriend(String name, String email) {
        click(sendToAFriendLocator);
        fillText(friendNameFieldLocator,name);
        fillText(friendEmailAddressField,email);
        click(sendToFriendSendButton);
    }

    @Step("Return the dialog confirmation text after sending the details to a friend")
    public String getDialogConfirmationText() {
        return getText(confirmationDialogText);
    }

    @Step("click on the Ok button in the popUp dialog")
    public void clickOnDialogPopupOkButton() {
        click(confirmationDialogOkButton);
    }

    @Step("get the price value of the product text")
    public String getProductPriceValueText() {
        String valueText = priceLocator.getText();
        return valueText;
    }

    @Step("click on add to wishlist")
    public void addToWishList() {
        click(addToWishListLocator);
    }

    @Step("This method returns the text when trying to add to wish list without a logged in account")
    public String returnWishListTextWhenAddingWishListWithoutLoggedAccount() {
        click(closeDialogXButton);
        return getText(mustBeLoggedToAddToWishListInText);
    }

    @Step("click on print")
    public void print() {
        click(printLocator);
    }

    @Step("this method increase the view of the product image then click on X")
    public void increaseProductImageView() {
        click(viewProductImageLargerLocator);
        click(closeDialogXButton);
    }

    @Step("select a size for the product")
    public void selectSizeFromDropdown(String Text) {
        selectByText(sizeDropDownLocator,Text);
    }

    @Step("return added to your wishlist text and close the popup message")
    public String getWishListConfirmationText() {
        click(closeDialogXButton);
        return getText(addedToWishListTextLocator);
    }

}
