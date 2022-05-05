package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DressesPage extends WomenPage{
    public DressesPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[@class='subcategory-name']")
    List<WebElement> subCategoriesList;


    @Step("choose dress from subcategory list")
    public void chooseDressSubCategoryFromList(String dressTitle) {
        for (int i = 0; i <subCategoriesList.size() ; i++) {
            if (getText(subCategoriesList.get(i)).equalsIgnoreCase(dressTitle)) {
                click(subCategoriesList.get(i));
                break;
            }
        }
    }

    @Step("choose a dress from the dress list")
    public void chooseDressFromDressesList(String dress, String confirmationText) {
        chooseProductFromList(dress,confirmationText);
    }

    @Step("select dress by category")
    public void sortDressesByCategory(String category) {
        sortBy(category);
    }

}
