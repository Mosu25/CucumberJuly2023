package org.mosu.driver;

import org.mosu.enums.BrowserName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Objects;


public final class Driver {

    private Driver(){}

    public static void initDriver(){

        WebDriver driver = DriverFactory.getDriver(BrowserName.CHROME);

        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        DriverManager.getDriver().get("https://bookcart.azurewebsites.net");
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}
