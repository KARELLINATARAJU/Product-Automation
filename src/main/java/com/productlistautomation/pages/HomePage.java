
package com.productlistautomation.pages;
import com.productlistautomation.utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Open Pepperfry website
    public void openWebsite() {
        driver.get("https://www.pepperfry.com/");
    }

    // Handle login/signup popup if present
    public void handleLoginPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            if (driver.findElements(By.cssSelector("pf-modal")).isEmpty()) {
                return;
            }
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("pf-modal div.modal-container")));
            List<WebElement> closes = driver.findElements(By.cssSelector("pf-modal div.modal-container a.close-modal"));
            if (!closes.isEmpty()) {
                WebElement close = closes.get(0);
                Thread.sleep(600);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", close);
            }
        } catch (Exception e) {
            System.out.println("Popup handling error: " + e.getMessage());
        }
    }

    // Get homepage title
    public String getHomePageTitle() {
        return driver.getTitle();
    }

    // Hover on Furniture and click Settees & Benches
    public void hoverFurnitureAndClickSetteesAndBenches() throws InterruptedException {
        By furnitureNav = By.xpath("//a[contains(@href,'furniture')]");
        WebElement furniture = WaitUtils.waitForVisible(driver, furnitureNav);
        new Actions(driver).moveToElement(furniture).pause(Duration.ofMillis(500)).perform();
        Thread.sleep(1100);
        By setteesBenchesLinkByHref = By.xpath("//a[contains(@href,'settees-and-benches')]");
        WebElement setteesBenches = WaitUtils.waitForVisible(driver, setteesBenchesLinkByHref);
        setteesBenches.click();
        // System.out.println("Furniture page opened.");
    }
}
