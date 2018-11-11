package myprojects.automation.assignment3.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventHandler implements WebDriverEventListener {
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertDismiss(WebDriver webDriver) {

    }

    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Before navigating to: '" + s + "'");
    }

    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Navigated to:'" + s + "'");
    }

    public void beforeNavigateBack(WebDriver webDriver) {
        System.out.println("Navigating back to previous page");
    }

    public void afterNavigateBack(WebDriver webDriver) {
        System.out.println("Navigated back to previous page");
    }

    public void beforeNavigateForward(WebDriver webDriver) {
        System.out.println("Navigating forward to next page");
    }

    public void afterNavigateForward(WebDriver webDriver) {
        System.out.println("Navigated forward to next page");
    }

    public void beforeNavigateRefresh(WebDriver webDriver) {
        System.out.println("Refreshing page: '" +  webDriver.getCurrentUrl() + "'");
    }

    public void afterNavigateRefresh(WebDriver webDriver) {
        System.out.println("Refreshed page: '" +  webDriver.getCurrentUrl() + "'");
    }

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Trying to find Element By : " + by.toString());
    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Found Element By : " + by.toString());
    }

    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Trying to click on: " + webElement.toString());
    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Clicked on: " + webElement.toString());
    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Value of the:" + webElement.toString() + " before any changes made");
    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Element value changed to: " + webElement.toString());
    }

    public void beforeScript(String s, WebDriver webDriver) {

    }

    public void afterScript(String s, WebDriver webDriver) {

    }

    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    public void onException(Throwable throwable, WebDriver webDriver) {
        System.out.println("Exception occured: " + throwable.toString());
    }

    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }
}
