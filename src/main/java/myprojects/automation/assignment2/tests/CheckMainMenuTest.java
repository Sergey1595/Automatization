package myprojects.automation.assignment2.tests;


import myprojects.automation.assignment2.BaseScript;
import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CheckMainMenuTest extends BaseScript {
    public static void main(String[] args) throws InterruptedException{
        String Email = "webinar.test@gmail.com";
        String Password = "Xcg7299bnSmMuRLp9ITw";

        //Start Chromedriver and go to admin page
        WebDriver Driver = getDriver();
        Driver.manage().window().maximize();
        Driver.get(Properties.getBaseAdminUrl());
        sleep(5000);

        //login
        login(Email, Password, Driver);

        //check elements of menu
        List <WebElement> ElemOfMenu = Driver.findElements(By.xpath("//ul[@class='main-menu' or @class='menu']/child::li[not(span or div)]"));
        for(int i = 0; i < ElemOfMenu.size(); i++){
            ElemOfMenu.clear();
            ElemOfMenu = Driver.findElements(By.xpath("//ul[@class='main-menu' or @class='menu']/child::li[not(span or div)]"));
            checkElemOfMenu(Driver, ElemOfMenu.get(i));
        }

        //logout and close driver
        logout(Driver);
        Driver.quit();
    }

    private static void checkElemOfMenu(WebDriver Driver, WebElement ButtonInMenu){
        String NameOfPageBeforeRefresh;
        String NameOfPageAfterRefresh;
        String NameOfElement;
        WebElement TitleOfPage = null;

        NameOfElement = ButtonInMenu.getText();
        System.out.println(NameOfElement);
        ButtonInMenu.click();
        sleep(5000);

        TitleOfPage = Driver.findElement(By.xpath("//h2[@class='title' or @class='page-title']"));
        NameOfPageBeforeRefresh = TitleOfPage.getText();
        Driver.navigate().refresh();
        sleep(5000);

        TitleOfPage = Driver.findElement(By.xpath("//h2[@class='title' or @class='page-title']"));
        NameOfPageAfterRefresh = TitleOfPage.getText();
        NameOfPageBeforeRefresh = NameOfPageBeforeRefresh.replaceAll("\\s+","");
        NameOfPageAfterRefresh = NameOfPageAfterRefresh.replaceAll("\\s+","");
        if(NameOfPageBeforeRefresh.equals(NameOfPageAfterRefresh))
            System.out.println("Check of " + NameOfElement + " is successful");
        else
            System.out.println("Check of " + NameOfElement + " is unsuccessful");
        sleep(5000);
    }
}
