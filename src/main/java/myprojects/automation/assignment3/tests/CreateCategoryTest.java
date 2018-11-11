package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateCategoryTest extends BaseScript {
    public static void main(String[] args) throws InterruptedException {
        // TODO prepare driver object
        WebDriver Driver = getConfiguredDriver();
        String Email = "webinar.test@gmail.com";
        String Password = "Xcg7299bnSmMuRLp9ITw";
        String UrlOfadminPage = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
        String CategoryName = "TestCategory";

        GeneralActions genAction = new GeneralActions(Driver);
        Driver.get(UrlOfadminPage);
        // login
        genAction.login(Email, Password);
        // create category
        genAction.createCategory(CategoryName);
        // check that new category appears in Categories table
        genAction.sortedByCategoryName("asdasdas");
        genAction.checkAddedCategories();
        // finish script
    }
}
