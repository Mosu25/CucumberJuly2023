package org.mosu.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.mosu.driver.Driver;
import org.mosu.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Hooks {

    @Before
    public void setup() {
        Driver.initDriver();
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//span[.='Login']/.."))).click();
    }

    @After (order = 1)
    public void tearDown(Scenario scenario){
        boolean failed = scenario.isFailed();
        if (!failed){
            TakesScreenshot takesScreenshot = (TakesScreenshot) DriverManager.getDriver();
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
        Driver.quitDriver();
    }

    @After("@clean")
    public void clearCart(){

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By
                        .xpath("(//mat-icon[contains(@class,'mat-icon notranslate')])[3]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Clear cart']"))).click();
        boolean isDisplayed = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//button[@color='primary']//span[1]")))
                .isDisplayed();
        Assert.assertEquals(isDisplayed,true);
    }

}
