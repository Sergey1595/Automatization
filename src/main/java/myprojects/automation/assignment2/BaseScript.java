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

    public static void login(String Email, String Password, WebDriver Driver){
        WebElement FieldEmail = Driver.findElement(By.id("email"));
        WebElement FieldPass = Driver.findElement(By.id("passwd"));
        WebElement ButtonSignIn = Driver.findElement(By.name("submitLogin"));
        FieldEmail.sendKeys(Email);
        FieldPass.sendKeys(Password);
        sleep(2000);
        ButtonSignIn.click();
        sleep(5000);
    }

    public static void logout(WebDriver Driver){
        WebElement HeaderEmplBox = Driver.findElement(By.id("header_employee_box"));
        WebElement ButtonExit = Driver.findElement(By.id("header_logout"));
        HeaderEmplBox.click();
        sleep(2000);
        ButtonExit.click();
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
