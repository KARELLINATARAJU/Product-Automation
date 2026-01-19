package com.productlistautomation.utils;

import org.openqa.selenium.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class ScreenShotUtils {
    public static void takeScreenShot(WebDriver driver,String name){
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File("screenshots/"+ name + ".png");
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved "+dest.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Screenshot failed "+ e.getMessage());
        }
    }
}
