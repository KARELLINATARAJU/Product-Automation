//package com.productlistautomation.tests;
//import com.productlistautomation.base.BaseDriver;
//import com.productlistautomation.pages.HomePage;
//import com.productlistautomation.pages.SetteesAndBenches;
//import com.productlistautomation.utils.ExcelUtils;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//public class HomePageTest extends BaseDriver {
//    WebDriver driver;
//    HomePage homePage;
//
//    @BeforeMethod
//    @Parameters("browser")
//    public void setup(String browser) {
//        driver = initDriver(browser);
//        //Crete Home Page object
//        homePage = new HomePage(driver);
//        //Launch Browser
//        homePage.openWebsite();
//        homePage.handleLoginPopup();
//    }
//
//    @Test
//    public void verifyTitle() throws InterruptedException {
//        String title = homePage.getHomePageTitle();
//        if (title.equals("Online Furniture Shopping Store"))
//            System.out.println("Title verification passed");
//         else
//            System.out.println("Title verification Failed");
//          homePage.hoverFurnitureAndClickSetteesAndBenches();
//            Thread.sleep(1500);
//        }
//
//}
//
//
