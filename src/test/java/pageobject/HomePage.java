package pageobject;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Set;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".logo.img-responsive")
    WebElement homeLogo;
    @FindBy(xpath = "//li/a[@title='Women']")
    WebElement womenHeaderMenu;
    @FindBy(xpath = "//li/a[@title='Dresses' and text()='Dresses'][last()]")
    WebElement dressesHeaderMenu;
    @FindBy(xpath = "//li[3]/a[@title='T-shirts']")
    WebElement tShirtsHeaderMenu;
    @FindBy(xpath = "//div/a[@title='View my shopping cart']")
    WebElement shoppingCart;
    @FindBy(css = "#contact-link")
    WebElement contactUsLocator;
    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    WebElement signInButtonLocator;
    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement signOutButton;
    @FindBy(xpath = "//a[@title='View my customer account']/span")
    WebElement myCustomerAccountButton;
    @FindBy(css = "#search_query_top")
    WebElement searchBoxLocator;
    @FindBy(xpath = "//span[@class='remove_link']/a")
    WebElement removeProductFromCartDropdown;
    @FindBy(xpath = "//a[@title='Check out']")
    WebElement checkOutCartDropdownLocator;
    @FindBy(xpath = "//a[@title='View my shopping cart']")
    WebElement shoppingCartDropdownLocator;
    @FindBy(xpath = "//div[@class='cart-prices-line first-line']/span[1]")
    WebElement shippingPriceLocator;
    @FindBy(xpath = "//div[@class='cart-prices-line first-line']/span[2]")
    WebElement shippingInnerTextLocator;
    @FindBy(xpath = "//div[@class='cart-prices-line last-line']/span[1]")
    WebElement totalPriceLocator;
    @FindBy(xpath = "//div[@class='cart-prices-line last-line']/span[2]")
    WebElement totalInnerTextLocator;
    @FindBy(xpath = "//a[@class='product-name']")
    List<WebElement> homePageProductList;
    @FindBy(xpath = "//a[@class='button ajax_add_to_cart_button btn btn-default']/span[last()]")
    WebElement addToCartButton;
    @FindBy(xpath = "//span[text()='More'][last()]")
    WebElement moreButton;
    @FindBy(css = "#newsletter-input")
    WebElement newsLetterInputEmail;
    @FindBy(css = "[name='submitNewsletter']")
    WebElement submitNewsLetterLocator;
    @FindBy(xpath = "//li[@class='facebook']/a")
    WebElement faceBookLocator;
    @FindBy(xpath = "//li[@class='twitter']/a")
    WebElement twitterLocator;
    @FindBy(xpath = "//li[@class='youtube']/a")
    WebElement youtubeLocator;
    @FindBy(xpath = "//li[@class='google-plus']/a")
    WebElement googlePlusLocator;
    @FindBy(css = "#social_block li")
    WebElement socialMediaList;
    @FindBy(xpath = "//div[@id='search-input']/input")
    WebElement youtubeSearchBox;
    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement homePageNewsLetterAlert;
    @FindBy(xpath = "//p[@class='alert alert-danger']")
    WebElement failedNewsLetterAlert;
    @FindBy(css = ".layer_cart_product.col-xs-12.col-md-6>h2")
    WebElement addedProductConfirmationText;
    @FindBy(xpath = "//a[@title='Close']")
    WebElement closeDialogXButton;
    @FindBy(css = "[title='Continue shopping']")
    WebElement continueShoppingLocator;
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement proceedToCheckoutLocator;
    @FindBy(css = ".fancybox-inner>p")
    WebElement alertPopupText;
    @FindBy(xpath = "//a[@class='add_to_compare']")
    WebElement addToCompareLocator;
    @FindBy(xpath = "//button[@class='btn btn-default button button-medium bt_compare bt_compare']")
    WebElement compareButtonLocator;
    @FindBy(xpath = "//strong[@class='total-compare-val']")
    WebElement totalItemsToCompareNumber;
    @FindBy(css = "[title='Close window']")
    WebElement closeWindowLocator;
    @FindBy(xpath = "//a[@title='Check out']")
    WebElement cartCheckoutLocator;


    @Step("click on homePage logo")
    public void clickHomeLogo() {
        click(homeLogo);
    }

    @Step("choose women menu category")
    public void clickOnWomenCategoryMenu() {
        click(womenHeaderMenu);
    }

    @Step("choose dresses menu category")
    public void clickOnDressesCategoryMenu() {
        click(dressesHeaderMenu);
    }

    @Step("choose TShirts menu category")
    public void clickOnTShirtsCategoryMenu() {
        click(tShirtsHeaderMenu);
    }

    @Step("return sign in button text")
    public String returnSignInnText() {
        return getText(signInButtonLocator);
    }

    @Step("return sign out button text")
    public String returnSignOutText() {
        return getText(signOutButton);
    }

    @Step("return shipping price")
    public String getShippingPrice() {
        String shippingPriceText = shippingPriceLocator.getText();
        return shippingPriceText;
    }

    @Step("return total price")
    public String getTotalPrice() {
        return getText(totalPriceLocator);
    }

    @Step("This method clicks on contact us option")
    public void clickOnContactUs() {
        click(contactUsLocator);
    }

    @Step("search for a value in the homePage searchBox")
    public void searchInSearchBox(String value) {
        fillText(searchBoxLocator, value);
    }

    @Step("click on sign in and login to your account")
    public void clickOnSignIn() {
        click(signInButtonLocator);
    }

    @Step("Sign out from the account")
    public void signOut() {
        click(signOutButton);
    }

    @Step("this method clicks on the customer name button and returns the inner text of the button")
    public String clickOnMyCustomerAccountButton() {
        click(myCustomerAccountButton);
        return getText(myCustomerAccountButton);
    }

    @Step(" Scroll page down and Enter your email input to get a Web newsLetter then validate the submit button is displayed and click on it")
    public void enterEmailToGetNewsLetter(String email) {
        // scrollTo(0, 1000);
        fillText(newsLetterInputEmail, email);
        validateElementIsDisplayed(submitNewsLetterLocator);
    }

    @Step("This method switches to another url window")
    public void switchToNewWindow() {
        String currentWindow = driver.getWindowHandle();
        Set<String> list = driver.getWindowHandles();
        for (String newWindow : list) {
            driver.switchTo().window(newWindow);
            String urlTitle = driver.getTitle();
            getCurrentUrl(urlTitle);
        }
    }

    @Step("switch to tab")
    public void switchToTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    @Step("click on facebook logo at end of the page and return facebook web title")
    public String clickOnFacebookLogo() {
        click(faceBookLocator);
        switchToNewWindow();
        return driver.getTitle();
    }

    @Step("click on twitter logo at end of the page and return twitter web title")
    public String clickOnTwitterLogo() {
        click(twitterLocator);
        switchToNewWindow();
        return driver.getTitle();
    }

    @Step("click on youtube logo at end of the page and validate current url")
    public String clickOnYouTubeLogoAndSearchForContent(String value) {
        click(youtubeLocator);
        switchToNewWindow();
        fillText(youtubeSearchBox, value);
        pressEnter(youtubeSearchBox);
        sleep(1000);
        return driver.getCurrentUrl();
    }

    @Step("click on googlePlus logo at end of the page and get page title")
    public String clickOnGooglePlusLogo() {
        click(googlePlusLocator);
        switchToNewWindow();
        return driver.getTitle();
    }

    @Step("get news letter header alert text after clicking on submit newsLetter email input")
    public String getNewsLetterAlertText() {
        waitForVisibility(homePageNewsLetterAlert);
        return getText(homePageNewsLetterAlert);
    }

    @Step("This method goes over the products list in the homepage by text then hovers over the product and adds it to the cart")
    public void chooseProductFromList(String productName, String confirmationText) {
        for (WebElement el : homePageProductList) {
            if (el.getText().equalsIgnoreCase(productName)) {
                hover(el);
                click(addToCartButton);
                if (addedProductConfirmationText.getText().contains(confirmationText)) {
                    click(proceedToCheckoutLocator);
                } else {
                    click(continueShoppingLocator);
                }
                break;
            }
        }
    }

    @Step("This Method removes the product from cart then returns the total price and shipping details")
    public void removeProductFromCartDropdown() {
        hover(shoppingCart);
        click(removeProductFromCartDropdown);
        sleep(2000);
    }

    @Step("get the number of the current windows")
    public int getNumberOfWindows() {
        return driver.getWindowHandles().size();
    }

    @Step("hover over the product list and click on the chosen product")
    public void hoverOnProductAndClickOnProduct(String productName) {
        for (WebElement product : homePageProductList) {
            if (product.getText().equalsIgnoreCase(productName)) {
                hover(product);
                product.click();
                break;
            }
        }
    }

    @Step("add item to cart and then click on continue shopping")
    public void addItemToCartAndContinueShopping(String productName, int index) {
        for (WebElement productElement : homePageProductList) {
            if (productElement.getText().contains(productName)) {
                hover(productElement);
                click(driver.findElement(By.xpath("(//a[@title='Add to cart'])[" + index + "]")));
                click(continueShoppingLocator);
                break;
            }
        }
    }

    @Step("This method hovers on the cartDropdown and checkout")
    public void hoverOnCartDropdownAndCheckout() {
        hover(shoppingCartDropdownLocator);
        click(cartCheckoutLocator);
    }

    @Step("get cart status if its empty or it has items in it by the span element number")
    public String getCartStatus(int spanIndex) {
        sleep(2000);
        WebElement cartStatus = driver.findElement(By.xpath("//a[@title='View my shopping cart']/span[" + spanIndex + "]"));
        return getText(cartStatus);
    }

    @Step("click on proceed to checkout")
    public void proceedToCheckOut() {
        click(proceedToCheckoutLocator);
    }

    @Step("click on continue shopping")
    public void continueShopping() {
        click(continueShoppingLocator);
    }

    @Step("return news letter alert text when the newsLetter subscription fails")
    public String getNegativeNewsLetterAlert() {
        return getText(failedNewsLetterAlert);
    }
}
