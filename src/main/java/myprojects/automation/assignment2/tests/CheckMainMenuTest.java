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
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        driver.get(Properties.getBaseAdminUrl());
        sleep(5000);

        //login
        login(Email, Password, driver);

        //check elements of menu
        List <WebElement> ElemOfMenu = driver.findElements(By.xpath("//nav/ul/li/a/i[@class='material-icons']/parent::a/parent::li"));
        for(int i = 0; i < ElemOfMenu.size(); i++){
            ElemOfMenu.clear();
            ElemOfMenu = driver.findElements(By.xpath("//nav/ul/li/a/i[@class='material-icons']/parent::a/parent::li"));
            checkElemOfMenu(driver, ElemOfMenu.get(i));
        }

        //logout and close driver
        logout(driver);
        driver.quit();
    }

    private static void checkElemOfMenu(WebDriver driver, WebElement ButtonInMenu){
        String NameOfPageBeforeRefresh;
        String NameOfPageAfterRefresh;
        String NameOfElement;
        NameOfElement = ButtonInMenu.getText();
        System.out.println(NameOfElement);
        ButtonInMenu.click();
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
}
