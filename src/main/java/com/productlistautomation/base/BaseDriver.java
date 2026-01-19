package com.productlistautomation.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseDriver {
    protected  WebDriver driver;

    // Initialize browser
    public  WebDriver initDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
    //close browser
    public void quitDriver(){
        driver.quit();
        driver=null;
    }
}
