package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
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
