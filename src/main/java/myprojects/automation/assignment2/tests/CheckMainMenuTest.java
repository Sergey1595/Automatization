package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class CheckMainMenuTest extends BaseScript {
    public static void main(String[] args) throws InterruptedException{
        String Email = "webinar.test@gmail.com";
        String Password = "Xcg7299bnSmMuRLp9ITw";

        //Start Chromedriver and go to admin page
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        driver.get(Properties.getBaseAdminUrl());
        sleep(5000);

        //login
        WebElement fieldEmail = driver.findElement(By.id("email"));
        WebElement fieldPass = driver.findElement(By.id("passwd"));
        WebElement buttonSignIn = driver.findElement(By.name("submitLogin"));
        fieldEmail.sendKeys(Email);
        fieldPass.sendKeys(Password);
        sleep(2000);
        buttonSignIn.click();
        sleep(5000);

        //make array list string of dates sub menus
        ArrayList<String> datesSubMenus = new ArrayList<String>();
        datesSubMenus.add("1");
        datesSubMenus.add("3");
        datesSubMenus.add("9");
        datesSubMenus.add("23");
        datesSubMenus.add("27");
        datesSubMenus.add("31");
        datesSubMenus.add("42");
        datesSubMenus.add("46");
        datesSubMenus.add("52");
        datesSubMenus.add("55");
        datesSubMenus.add("58");
        datesSubMenus.add("73");
        datesSubMenus.add("95");

        //check main menus
        String NameOfPageBeforeRefresh;
        String NameOfPageAfterRefresh;
        String NameOfElement;
        for(int i = 0; i < datesSubMenus.size(); i++){
            WebElement button = driver.findElement(By.xpath("//*[contains(@data-submenu, '" + datesSubMenus.get(i) + "')]"));
            NameOfElement = button.getText();
            System.out.println(NameOfElement);
            button.click();
            sleep(5000);
            NameOfPageBeforeRefresh = driver.getTitle();
            driver.navigate().refresh();
            sleep(5000);
            NameOfPageAfterRefresh = driver.getTitle();
            NameOfPageBeforeRefresh = NameOfPageBeforeRefresh.replaceAll("\\s+","");
            NameOfPageAfterRefresh = NameOfPageAfterRefresh.replaceAll("\\s+","");
            if(NameOfPageBeforeRefresh.equals(NameOfPageAfterRefresh))
                System.out.println("Check of " + NameOfElement + " is successful");
            else
                System.out.println("Check of " + NameOfElement + " is unsuccessful");
            sleep(5000);
        }

        //logout and close driver
        WebElement headerEmplBox = driver.findElement(By.id("header_employee_box"));
        WebElement buttonExit = driver.findElement(By.id("header_logout"));
        headerEmplBox.click();
        sleep(2000);
        buttonExit.click();
        sleep(5000);
        driver.quit();

    }
}
