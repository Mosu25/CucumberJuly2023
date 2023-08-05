package org.mosu.driver;

import org.mosu.enums.BrowserName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class DriverFactory {

    private DriverFactory() {}

    private static final Map<BrowserName, Supplier<WebDriver>> driverSuppliers = new EnumMap<>(BrowserName.class);

    static {
        driverSuppliers.put(BrowserName.CHROME, ChromeDriver::new);
        driverSuppliers.put(BrowserName.FIREFOX, FirefoxDriver::new);
        driverSuppliers.put(BrowserName.EDGE, EdgeDriver::new);
    }

    public static WebDriver getDriver(BrowserName browserName) {
        return driverSuppliers.get(browserName).get();
    }
}
