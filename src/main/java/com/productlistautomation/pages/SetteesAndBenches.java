
package com.productlistautomation.pages;

import com.productlistautomation.utils.ScreenShotUtils;
import com.productlistautomation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SetteesAndBenches {
    WebDriver driver;
    public SetteesAndBenches(WebDriver driver){
        this.driver=driver;
    }

    // Display settees count
    public void setteesCount(){
        By settees= By.xpath("//div[text()='Settees']/following-sibling::div");
        WebElement setteesElement = WaitUtils.waitForVisible(driver,settees);
        System.out.println("The Settees count is: "+setteesElement.getText());
    }

    // Display benches count
    public void benchesCount(){
        By benches= By.xpath("//div[text()='Benches']/following-sibling::div");
        WebElement benchesElement = WaitUtils.waitForVisible(driver,benches);
        System.out.println("The benches count is: "+benchesElement.getText());
    }

    // Display recamiers count
    public void recamiersCount(){
        By  Recamiers= By.xpath("//div[text()='Recamiers']/following-sibling::div");
        WebElement RecamiersElement = WaitUtils.waitForVisible(driver,Recamiers);
        System.out.println("The Recamiers count is: "+RecamiersElement.getText());
    }

    // Scroll and click More Filters
    public void scrollAndClickMoreFilters() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By moreFilters = By.xpath("//span[contains(@class,'more-filter')]");
        WebElement mf = WaitUtils.waitForVisible(driver,moreFilters);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", mf);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(moreFilters)).click();
        } catch (Exception e) {
            WebElement fresh = driver.findElement(moreFilters);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fresh);
        }
        Thread.sleep(700);
    }

    // Open Materials dropdown
    public void clickMaterials(String name) throws InterruptedException {
        By materialDropdown = By.xpath("//h4[normalize-space()='"+name+"']");
        WebElement material = WaitUtils.waitForVisible(driver,materialDropdown);
        ScreenShotUtils.takeScreenShot(driver,"MaterialDropdown");
        material.click();
    }

    // Scroll and select Metal option
    public void scrollAndClickMetal(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By metalOption = By.xpath("//label[normalize-space()='Metal']");
        WebElement metal = WaitUtils.waitForVisible(driver,metalOption);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", metal);
        ScreenShotUtils.takeScreenShot(driver,"MetalOption");
        wait.until(ExpectedConditions.elementToBeClickable(metal)).click();
    }

    // Click Apply button
    public  void clickApplyButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By apply=By.xpath("(//button[@id='Button'])[3]");
        WebElement applyButton = WaitUtils.waitForPresence(driver,apply);
        Thread.sleep(900);
        wait.until(ExpectedConditions.elementToBeClickable(applyButton)).click();
    }

    // Scroll to results section
    public void scrollToResults() throws InterruptedException {
        Thread.sleep(900);
        By setAndBen = By.xpath("(//span[text()='Settees and Benches'])[2]");
        WebElement mf = WaitUtils.waitForVisible(driver,setAndBen);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,709);", mf);
        Thread.sleep(1000);
    }

    // Print product names in results
    public void displayBenches(){
        List<WebElement> names = driver.findElements(By.xpath("//h2[contains(@class,'product-name')]"));
        names.forEach(e -> System.out.println(e.getText()));
    }

    // Print result summary text
    public void countResult(){
        By res=By.xpath("//div[contains(text(),'Showing')]");
        WebElement resDiv=WaitUtils.waitForVisible(driver,res);
        System.out.println("The Result: "+resDiv.getText().replace("\n", " "));
    }
}
