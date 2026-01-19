//package com.productlistautomation.tests;
//
//import com.productlistautomation.base.BaseDriver;
//import com.productlistautomation.pages.HomePage;
//import com.productlistautomation.pages.SetteesAndBenches;
//import com.productlistautomation.utils.ExcelUtils;
//import com.productlistautomation.utils.ScreenShotUtils;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//public class SetteesAndBenchesTest extends BaseDriver {
////    public static void main(String[] args) throws InterruptedException {
//    WebDriver driver;
//    SetteesAndBenches snb;
//    @BeforeMethod
//    @Parameters("browser")
//    public void setup(String browser) throws InterruptedException {
//        driver = initDriver(browser);
//        HomePage homePage=new HomePage(driver);
//        homePage.openWebsite();
//        homePage.handleLoginPopup();
//        homePage.hoverFurnitureAndClickSetteesAndBenches();
//        snb=new SetteesAndBenches(driver);
//    }
//    @Test
//    public void run() throws InterruptedException {
////        snb=new SetteesAndBenches(driver);
//        snb.setteesCount();
//        snb.benchesCount();
//        snb.recamiersCount();
//        snb.scrollAndClickMoreFilters();
//        Thread.sleep(1500);
//
//        String name= ExcelUtils.getCellData("src/test/resources/testdata.xlsx",0,0);
//        snb.clickMaterials(name);
//        Thread.sleep(1500);
//
//        String materialName= ExcelUtils.getCellData("src/test/resources/testdata.xlsx",0,1);
//        snb.scrollAndClickMetal(materialName);
//        Thread.sleep(1500);
//
//        snb.clickApplyButton();
//        Thread.sleep(1500);
//        snb.scrollToResults();
//        Thread.sleep(1500);
//        snb.displayBenches();
//        ScreenShotUtils.takeScreenShot(driver,"setteesAndBenches");
//        Thread.sleep(1000);
//        snb.countResult();
//    }
//    @AfterMethod
//    public void close(){
//        quitDriver();
//    }
//}
