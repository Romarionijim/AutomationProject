package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WomenPage extends HomePage {
    public WomenPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div/a[@title='Tops']")
    WebElement topsLocator;
    @FindBy(xpath = "//div/a[@title='Dresses']")
    WebElement dressesLocator;
    @FindBy(css = "#ul_layered_id_attribute_group_3>li")
    List<WebElement> colorList;
    @FindBy(css = "[itemprop='name'] .product-name")
    List<WebElement> womenPageProductList;
    @FindBy(css = ".ui-slider-handle.ui-state-default.ui-corner-all.ui-state-hover")
    WebElement priceSliderLeftSideButton;
    @FindBy(css = ".ui-slider-handle.ui-state-default.ui-corner-all.ui-state-hover")
    WebElement priceSliderRightSideButton;
    @FindBy(xpath = "//span[text() ='Add to cart']")
    WebElement addToCartButton;
    @FindBy(xpath = "//span[text()='More']")
    WebElement moreButtonLocator;
    @FindBy(css = "layered_price_range")
    WebElement priceRangeLocator;
    @FindBy(xpath = "//span[text()='Quick view'][last()]")
    WebElement quickViewLocator;
    @FindBy(xpath = "//div[@class='wishlist'][last()]")
    WebElement wishListLocator;
    @FindBy(css = "#selectProductSort")
    WebElement sortProductLocator;
    @FindBy(xpath = "//a[@title='Faded Short Sleeve T-shirts'][last()]")
    WebElement productName;
    @FindBy(css = ".layer_cart_product.col-xs-12.col-md-6>h2")
    WebElement addedProductConfirmationText;
    @FindBy(name = " Product successfully added to your shopping cart ")
    WebElement addedConfirmationText;

    @Step("This method click on the tops subcategory on the top of the women page")
    public void clickOnTopsSubCategory() {
        click(topsLocator);
    }

    @Step("This method clicks on the dresses subcategory on the top of the women page")
    public void clickOnDressesSubCategory() {
        click(dressesLocator);
    }

    @Step("Choose a color from the catalog side list")
    public void chooseColorFromSideList(String colorText) {
        for (int i = 0; i < colorList.size(); i++) {
            if (getText(colorList.get(i)).equalsIgnoreCase(colorText)) {
                click(colorList.get(i));
                break;
            }
        }
    }

    @Step("Choose a product from the women page product list and click on add to cart then get the addedProduct confirmation text and proceed to checkout if the text matches the confirmation letter else continue shopping")
    public void chooseProductFromProductList(String productName,String confirmationText) {
        for (WebElement product : womenPageProductList) {
            if (product.getText().equalsIgnoreCase(productName)) {
                hover(product);
                click(addToCartButton);
                if (addedConfirmationText.getText().contains(confirmationText)) {
                    click(proceedToCheckoutLocator);
                } else {
                    click(continueShoppingLocator);
                }
                break;
            }
        }
    }

    @Step("hover over a product from list then click on more")
    public void hoverOverProductAndClickOnMore(String ProductName) {
        for (WebElement product : womenPageProductList) {
            if (product.getText().equalsIgnoreCase(ProductName)) {
                hover(product);
                click(moreButtonLocator);
                break;
            }
        }
    }

    @Step("get the confirmation text after adding a product to cart")
    public String getAddedProductConfirmationText() {
        return getText(addedProductConfirmationText);
    }

    @Step("This method goes over the product list hovers over one of the products by text then clicks on add to wish list and then does validations about the popup message text")
    public String addToWishList(String productName) {
        String alertText = null;
        for (WebElement productText : womenPageProductList) {
            if (productText.getText().equalsIgnoreCase(productName)) {
                hover(productText);
                click(wishListLocator);
                if (getAlertPopupText().equalsIgnoreCase("You must be logged in to manage your wishlist.")) {
                    alertText = getAlertPopupText();
                    click(closeDialogXButton);
                    return alertText;
                } else {
                    if (getAlertPopupText().equalsIgnoreCase("Added to your wishlist.")) {
                        alertText = getAlertPopupText();
                        click(closeDialogXButton);
                        return alertText;
                    }
                }
            }
        }
        return alertText;
    }

    @Step("gets the alert popup text after adding to wishlist")
    public String getAlertPopupText() {
        return getText(alertPopupText);
    }

    @Step("Get number of added items to compare before adding an item to compare and after adding an item to compare then clicks on compare button")
    public void addToCompare(String productName) {
        getNumberOfAddedItemsToCompareNumber();
        for (WebElement product: womenPageProductList) {
            if (product.getText().equalsIgnoreCase(productName)) {
                hover(product);
                click(addToCompareLocator);
                getNumberOfAddedItemsToCompareNumber();
                click(compareButtonLocator);
                break;
            }
        }
    }

    @Step("turn the numbers of the added items to compare into an integer and return the number")
    public int getNumberOfAddedItemsToCompareNumber() {
        int addToCompareNumber = Integer.parseInt(totalItemsToCompareNumber.getText());
        return addToCompareNumber;
    }

    @Step("sort dresses by your needs")
    public void sortBy(String category) {
        selectByText(sortProductLocator,category);
    }


    @Step("Hover over the product then add to cart")
    public void hoverOverTheProductAndAddToCart(String expectedProductName) {
        if (returnProductName().equalsIgnoreCase(expectedProductName)) {
            hover(productName);
            click(addToCartButton);
        }else {
            click(moreButtonLocator);
        }
    }

    @Step("return product name")
    public String returnProductName() {
        return getText(productName);
    }
}
