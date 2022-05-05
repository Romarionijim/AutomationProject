package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public Logger log = LogManager.getLogger();
    public Actions actions;
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public Alert alert;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 15);

    }

    public void fillText(WebElement el, String text) {
        wait.until(ExpectedConditions.visibilityOf(el));
        highlightElement(el, "yellow");
        el.clear();
        el.sendKeys(text);
    }

    public void click(WebElement el) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(el));
        } finally {
            highlightElement(el, "yellow");
            el.click();
        }
    }

    public void waitForElement(WebElement el) {
        wait.until(ExpectedConditions.elementToBeClickable(el));
    }

    public void waitForVisibility(WebElement el) {
        wait.until(ExpectedConditions.visibilityOf(el));
    }

    public void waitForInvisibility(WebElement el) {
        wait.until(ExpectedConditions.invisibilityOf(el));
    }

    public void hover(WebElement el) {
        waitForVisibility(el);
        highlightElement(el, "orange");
        actions.moveToElement(el).build().perform();
    }

    public void pressEnter(WebElement el) {
        el.sendKeys(Keys.ENTER);
    }

    public void doubleClick(WebElement el) {
        actions.doubleClick(el).build().perform();
    }

    public String getText(WebElement el) {
        return el.getText();
    }

    public void alertAccept() {
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public void alertGetText() {
        alert = driver.switchTo().alert();
        alert.getText();
    }

    public void alertDismiss() {
        alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public String alertGetTextAndAccept() {
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertText;
    }

    public void dragAndDropBy(WebElement el, int xOffset, int yOffset) {
        actions.dragAndDropBy(el, xOffset, yOffset).build().perform();
    }

    public void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void closeWindowTab() {
        ((JavascriptExecutor) driver).executeScript("window.close()");
    }

    public void waitForElementVisibilityAndInvisibility(WebElement el) {
        wait.until(ExpectedConditions.visibilityOf(el));
        wait.until(ExpectedConditions.invisibilityOf(el));
    }

    public void selectByText(WebElement el, String text) {
        Select select = new Select(el);
        select.selectByVisibleText(text);
    }

    public void selectByIndex(WebElement el, int index) {
        Select select = new Select(el);
        select.selectByIndex(index);
    }

    public void selectByValue(WebElement el, String value) {
        Select select = new Select(el);
        select.selectByValue(value);
    }

    public void switchToFrame(WebElement el) {
        driver.switchTo().frame(el);
    }

    public void switchOutOfFrame() {
        driver.switchTo().defaultContent();
    }

    public boolean returnElementDisplayed(WebElement el) {
        try {
            return el.isDisplayed();
        } catch (StaleElementReferenceException ex) {
            return false;
        } catch (NoSuchElementException n) {
            return false;
        }
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void backToPreviousPage() {
        driver.navigate().back();
    }

    public void scrollTo(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ");");
    }

    public void validateElementIsDisplayed(WebElement el) {
        boolean isDisplayed = el.isDisplayed();
        if (isDisplayed == true) {
            el.click();
        }
    }

    public Boolean getCurrentUrl(String urlString) {
        if (driver.getCurrentUrl().toLowerCase().contains(urlString)) {
            return true;
        } else {
            return false;
        }
    }

    public void getPageTitle() {
        driver.getTitle();
    }

    public void closeWindow() {
        driver.close();
    }

    //highlight the element when clicking on element or when filling an element field
    private void highlightElement(WebElement element, String color) {
        //keep the old style to change it back
        String originalStyle = element.getAttribute("style");
        String newStyle = "background-color:yellow;border: 1px solid " + color + ";" + originalStyle;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Change the style
        js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
                element);

        // Change the style back after 400 milliseconds
        js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
                + originalStyle + "');},400);", element);
    }
}
