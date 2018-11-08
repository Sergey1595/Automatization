package myprojects.automation.assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseScript {

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//chromedriver.exe");
            return new ChromeDriver();
        //throw new UnsupportedOperationException("Method doesn't return WebDriver instance");
    }

    public static void login(String Email, String Password, WebDriver driver){
        WebElement fieldEmail = driver.findElement(By.id("email"));
        WebElement fieldPass = driver.findElement(By.id("passwd"));
        WebElement buttonSignIn = driver.findElement(By.name("submitLogin"));
        fieldEmail.sendKeys(Email);
        fieldPass.sendKeys(Password);
        sleep(2000);
        buttonSignIn.click();
        sleep(5000);
    }

    public static void logout(WebDriver driver){
        WebElement headerEmplBox = driver.findElement(By.id("header_employee_box"));
        WebElement buttonExit = driver.findElement(By.id("header_logout"));
        headerEmplBox.click();
        sleep(2000);
        buttonExit.click();
        sleep(5000);
    }

    public static void sleep(long millSec){
        if(millSec == 0)
            return;
        try{
            Thread.sleep(millSec);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
