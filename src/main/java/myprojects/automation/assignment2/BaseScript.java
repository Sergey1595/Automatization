package myprojects.automation.assignment2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseScript {

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//chromedriver.exe");
            return new ChromeDriver();
        //throw new UnsupportedOperationException("Method doesn't return WebDriver instance");
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
