
package com.productlistautomation.tests;

import Reports.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.productlistautomation.base.BaseDriver;
import com.productlistautomation.pages.HomePage;
import com.productlistautomation.pages.SetteesAndBenches;
import com.productlistautomation.utils.ExcelUtils;
import com.productlistautomation.utils.ScreenShotUtils;
import com.productlistautomation.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

 //End-to-end test for Pepperfry furniture automation.
public class EndToEndTest extends BaseDriver {
    WebDriver driver;
    HomePage homePage;
    SetteesAndBenches snb;

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test = extent.createTest("ProductListAutomation", "Automation Report");

    // Launch browser and open homepage
    @Parameters("browser")
    @BeforeClass
    public void browserLaunchedAndWebsiteOpened(String browser) throws InterruptedException {
        driver = initDriver(browser);
        homePage = new HomePage(driver);
        snb = new SetteesAndBenches(driver);
        homePage.openWebsite();
        test.pass("Browser Launched and Website Opened");
        WaitUtils.waitForPageLaod(driver);
        ScreenShotUtils.takeScreenShot(driver, "Homepage_loaded");
    }

    // Verify homepage title
    @Test(priority = 1)
    public void verifyTitle() {
        String title = homePage.getHomePageTitle();
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(title, "Online Furniture Shopping Store");
        test.fail("Page Title Verification Failed");
        sa.assertAll();

    }

    // Handle login popup and navigate to Settees & Benches
    @Test(priority = 2)
    public void popupHandle() throws InterruptedException {
        homePage.handleLoginPopup();
        test.pass("Popup Handled");
        homePage.hoverFurnitureAndClickSetteesAndBenches();
    }

    // Initialize Settees & Benches page
    @Test(priority = 3)
    public void setteesAndBenchesPageOpened() throws InterruptedException {
        test.pass("SetteesAndBenches Page Opened");

    }

    // Display settees count
    @Test(priority = 4)
    public void setteesCountDisplayed() {
        snb.setteesCount();
        test.pass("Settees Count Displayed");
    }

    // Display benches count
    @Test(priority = 5)
    public void benchesCountDisplayed() {
        snb.benchesCount();
        test.pass("Benches Count Displayed");
    }

    // Display recamiers count and open More Filters
    @Test(priority = 6)
    public void recamiersCountDisplayed() throws InterruptedException {
        snb.recamiersCount();
        test.pass("Recamiers Count Displayed");
        Thread.sleep(900);
        ScreenShotUtils.takeScreenShot(driver, "FurnitureTypes");
        snb.scrollAndClickMoreFilters();
    }

    // Click Materials dropdown using Excel data
    @Test(priority = 7)
    public void dropdownClicked() throws InterruptedException {
        String name = ExcelUtils.getCellData("src/test/resources/testdata.xlsx", 0, 0);
        snb.clickMaterials(name);
        test.pass("Materials Dropdown Clicked");
    }

    // Select Metal option using Excel data
    @Test(priority = 8)
    public void metalOptionClicked() throws InterruptedException {
        String materialName = ExcelUtils.getCellData("src/test/resources/testdata.xlsx", 0, 1);
        snb.scrollAndClickMetal(materialName);
        test.pass("Metal Option Clicked");
    }

    // Apply filters, display results, take screenshot
    @Test(priority = 9)
    public void resultDisplayedAndClosedBrowser() throws InterruptedException {
        snb.clickApplyButton();
        snb.scrollToResults();
        snb.displayBenches();
        ScreenShotUtils.takeScreenShot(driver, "Result");
        snb.countResult();
        test.pass("Result count displayed along with Names");
    }

    // Close browser and end test
    @AfterClass
    public void close() {
        quitDriver();
        test.pass("Completed and closed browser");
    }
}
