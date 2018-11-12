package myprojects.automation.assignment3;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver Driver;
    private WebDriverWait Wait;

    public GeneralActions(WebDriver Driver) {
        this.Driver = Driver;
        Wait = new WebDriverWait(Driver, 30);
    }

    public void login(String Login, String Password) {
        Wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
        WebElement FieldEmail = Driver.findElement(By.id("email"));

        Wait.until(ExpectedConditions.presenceOfElementLocated(By.id("passwd")));
        WebElement FieldPass = Driver.findElement(By.id("passwd"));

        Wait.until(ExpectedConditions.presenceOfElementLocated(By.name("submitLogin")));
        WebElement ButtonSignIn = Driver.findElement(By.name("submitLogin"));

        FieldEmail.sendKeys(Login);
        FieldPass.sendKeys(Password);

        Wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("email"), Login));
        Wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("passwd"), Password));

        ButtonSignIn.click();
    }

    public void createCategory(String CategoryName) {
        //find button "Catalog"
        Wait.until(ExpectedConditions.presenceOfElementLocated(By.id("subtab-AdminCatalog")));
        WebElement ButtonCatalog = Driver.findElement(By.id("subtab-AdminCatalog"));
        Wait.until(ExpectedConditions.visibilityOf(ButtonCatalog));

        //find button "Categories"
        Wait.until(ExpectedConditions.presenceOfElementLocated(By.id("subtab-AdminCategories")));
        WebElement ButtonCategor = Driver.findElement(By.id("subtab-AdminCategories"));

        //press to button "Categories"
        Actions ClickOnBtnCategory = new Actions(Driver);
        ClickOnBtnCategory.moveToElement(ButtonCatalog).pause(Duration.ofSeconds(5)).click(ButtonCategor).build().perform();

        //press to button "Add new category"
        Wait.until(ExpectedConditions.presenceOfElementLocated(By.id("page-header-desc-category-new_category")));
        WebElement ButtonAddCategor = Driver.findElement(By.id("page-header-desc-category-new_category"));
        ButtonAddCategor.click();

        //write name of new category
        Wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name_1")));
        WebElement FieldNameOfNewCategory = Driver.findElement(By.id("name_1"));
        Wait.until(ExpectedConditions.visibilityOf(FieldNameOfNewCategory));
        FieldNameOfNewCategory.sendKeys(CategoryName);

        //press to button "Save new category" after text was write
        Wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("name_1"), CategoryName));
        Wait.until(ExpectedConditions.presenceOfElementLocated(By.id("category_form_submit_btn")));
        WebElement ButtonSaveNewCategory = Driver.findElement(By.id("category_form_submit_btn"));
        Wait.until(ExpectedConditions.elementToBeClickable(ButtonSaveNewCategory));
        ButtonSaveNewCategory.click();

        //find alert of add new category
        try{
            Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
            WebElement AddNewCategoryAlert = Driver.findElement(By.xpath("//div[@class='alert alert-success']"));
            if(AddNewCategoryAlert.isDisplayed())
                System.out.println("New category was add");
            else
                System.out.println("New category was`nt add");
        }catch (TimeoutException e){
            System.out.println("New category was`nt add");
        }

    }

    public void sortedByCategoryName(String NameOfCategory){
        //add search text in search field
        Wait.until(ExpectedConditions.presenceOfElementLocated(By.name("categoryFilter_name")));
        WebElement FieldSearchByCategoryName = Driver.findElement(By.name("categoryFilter_name"));
        Wait.until(ExpectedConditions.visibilityOf(FieldSearchByCategoryName));
        FieldSearchByCategoryName.sendKeys(NameOfCategory);
        Wait.until(ExpectedConditions.textToBePresentInElementValue(FieldSearchByCategoryName, NameOfCategory));

        //press search button
        Wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitFilterButtoncategory")));
        WebElement ButtonSearcCategory = Driver.findElement(By.id("submitFilterButtoncategory"));
        Wait.until(ExpectedConditions.elementToBeClickable(ButtonSearcCategory));
        ButtonSearcCategory.click();
    }

    public void checkAddedCategories(){
        Wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table-category")));
        List <WebElement> FoundCategoryes = Driver.findElements(By.xpath("//tr[@id]//td[3]"));
        if(FoundCategoryes.size() == 0){
            System.out.println("Categories not found.");
            return;
        }
        System.out.println("Found " + FoundCategoryes.size() + " categories.");
    }

    public void logout(){
        Wait.until(ExpectedConditions.presenceOfElementLocated(By.id("header_employee_box")));
        WebElement HeaderEmplBox = Driver.findElement(By.id("header_employee_box"));
        HeaderEmplBox.click();

        Wait.until(ExpectedConditions.presenceOfElementLocated(By.id("header_logout")));
        WebElement ButtonExit = Driver.findElement(By.id("header_logout"));
        Wait.until(ExpectedConditions.visibilityOf(ButtonExit));
        ButtonExit.click();
    }

    public void closeWebDriver(){
        Driver.quit();
    }
}
