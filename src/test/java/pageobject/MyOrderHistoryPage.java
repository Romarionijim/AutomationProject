package pageobject;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class MyOrderHistoryPage extends HomePage {
    public MyOrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    WebElement orderPageAlertText;
    @FindBy(css = "[class='first_item '] td")
    List<WebElement> orderList;


    @Step("return header alert at top of page")
    public String returnOrderHistoryHeaderAlert() {
        return getText(orderPageAlertText);
    }

    @Step("click on my account through the upper menu bar")
    public void backToMyAccount() {
        click(myCustomerAccountButton);
    }

    @Step("validate order history cell value details")
    public void validateOrderHistoryDetails(int rowNumber, String reference, String date, String totalPrice, String payment) {
        WebElement rowNumberIndex = driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]"));
        WebElement referenceValue = driver.findElement(By.xpath("//tbody/tr/td[1]"));
        assertEquals(referenceValue.getText(), reference);
        WebElement dateValue = driver.findElement(By.xpath("//tbody/tr/td[2]"));
        assertEquals(dateValue.getText(), date);
        WebElement totalPriceValue = driver.findElement(By.xpath("//tbody/tr/td[3]"));
        assertEquals(totalPriceValue.getText(), totalPrice);
        WebElement paymentValue = driver.findElement(By.xpath("//tbody/tr/td[4]"));
        assertEquals(paymentValue.getText(), payment);
    }

    @Step("another method to validate the order details")
    public String validateOrderDetailsOnGrid(int rowNumber, String reference, String date, String totalPrice, String payment) {
        List<String> arrayList = new ArrayList<>();
        WebElement rowNumberIndex = driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]"));
        arrayList.add(reference);
        arrayList.add(date);
        arrayList.add(totalPrice);
        arrayList.add(payment);
        for (int i = 0; i < arrayList.size(); i++) {
            return arrayList.get(i);
        }
        return null;
    }

}
