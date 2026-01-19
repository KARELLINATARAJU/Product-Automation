package com.productlistautomation.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class WaitUtils {
    public static WebElement waitForPresence(WebDriver driver, By locator){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public static WebElement waitForVisible(WebDriver driver,By locator){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated((locator)));
    }
    public static WebElement waitForClick(WebDriver driver,By locator){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void waitForPageLaod(WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        wait.until(driver1 ->((JavascriptExecutor)driver1).executeScript("return document.readyState").equals("complete"));
    }

}
