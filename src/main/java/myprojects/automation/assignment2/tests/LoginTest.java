package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;

import org.openqa.selenium.WebDriver;
import myprojects.automation.assignment2.utils.Properties;

public class LoginTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
        String Email = "webinar.test@gmail.com";
        String Password = "Xcg7299bnSmMuRLp9ITw";

        //Start Chromedriver and go to admin page
        WebDriver Driver = getDriver();
        Driver.manage().window().maximize();
        Driver.get(Properties.getBaseAdminUrl());
        sleep(5000);

        //login
        login(Email, Password, Driver);

        //logout and close driver
        logout(Driver);
        Driver.quit();
    }
}
