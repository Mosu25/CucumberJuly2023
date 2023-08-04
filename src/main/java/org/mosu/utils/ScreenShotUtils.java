package org.mosu.utils;

import io.cucumber.java.Scenario;
import org.mosu.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenShotUtils {

    private ScreenShotUtils(){}

    public static void getScreenShot(Scenario scenario){
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverManager.getDriver();
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png",scenario.getName());
    }

}
