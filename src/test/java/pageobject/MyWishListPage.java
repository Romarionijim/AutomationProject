package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.*;

public class MyWishListPage extends HomePage {
    public MyWishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#name")
    WebElement nameFieldLocator;
    @FindBy(css = "#submitWishlist")
    WebElement saveButton;
    @FindBy(xpath = "//span[text()='Send this wishlist']")
    WebElement sendThisWishListLocator;
    @FindBy(xpath = "//p[text()='Added to your wishlist.']")
    WebElement addedToWishListTextLocator;

    @Step("create new wishList and save")
    public void createNewWishList(String name) {
        fillText(nameFieldLocator, name);
        click(saveButton);
    }

    @Step("click on send this wishList button")
    public void clickOnSendThisWishList() {
        click(sendThisWishListLocator);
    }

    @Step("validate wishlist details on grid with assertions")
    public void validateWishListGridDetails(int row, String wishListName, String qtyCellValue, String createdCell) {
        WebElement rowNumber = driver.findElement(By.xpath("//tbody/tr"));
        WebElement nameCellValue = driver.findElement(By.xpath("//tbody/tr/td[1]"));
        assertEquals(nameCellValue.getText(), wishListName);
        WebElement quantityCellValue = driver.findElement(By.xpath("//tbody/tr/td[2]"));
        assertEquals(quantityCellValue.getText(), qtyCellValue);
        WebElement createdCellValue = driver.findElement(By.xpath("//tbody/tr/td[4]"));
        assertEquals(createdCellValue.getText(), createdCell);
    }

    @Step("another method to validate details")
    public MyWishListPage validateDetails(int row ,String wishListName, String qtyCellValue, String viewed, String createdCell) {
        String[] array = {wishListName, qtyCellValue, viewed, createdCell};
        for (int i = 0; i < array.length; i++) {
            WebElement rowNumber = driver.findElement(By.xpath("//tbody/tr"));
            WebElement nameCellValue = driver.findElement(By.xpath("//tbody/tr/td[" + i + "]"));
            if (nameCellValue.getText().contains(array[i])) {
                return this;
            }

        }
        return null;
    }

    @Step("return the added to wish list text string")
    public String validateItemAddedToWishList() {
        return getText(addedToWishListTextLocator);
    }
}
