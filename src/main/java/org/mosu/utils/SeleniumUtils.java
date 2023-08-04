package org.mosu.utils;

import org.mosu.driver.DriverManager;
import org.mosu.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;

public final class SeleniumUtils {
    private SeleniumUtils() {
    }
    private static final long WAIT_TIME = 30;
    
    public static void click(By by, WaitStrategy waitstrategy) {
        performExplicitWait(waitstrategy, by).click();

    }
    public static WebElement findWebElement(By by, WaitStrategy waitstrategy) {
        return performExplicitWait(waitstrategy, by);
    }
    public static void sendKeys(By by, String value, WaitStrategy waitstrategy) {
        performExplicitWait(waitstrategy, by).sendKeys(value);
    }

    public static String getTitle() {
        return DriverManager.getDriver().getTitle();
    }

    public static String getText(By by, WaitStrategy waitstrategy) {
        return performExplicitWait(waitstrategy, by).getText();
    }

    public static boolean isDisplayed(By by, WaitStrategy waitstrategy) {
        return performExplicitWait(waitstrategy, by).isDisplayed();
    }



    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_TIME));
        WebElement element = wait.until(
                switch (waitStrategy) {
                    case CLICKABLE -> ExpectedConditions.elementToBeClickable(by);
                    case PRESENCE -> ExpectedConditions.presenceOfElementLocated(by);
                    case VISIBLE -> ExpectedConditions.visibilityOfElementLocated(by);
                    case NONE -> null;
                }
        );
        return Optional.ofNullable(element).orElseThrow(() -> new NoSuchElementException("Element not found"));
    }

    public static Boolean isInvisibility(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_TIME));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }



//    private static final Map<WaitStrategy, Function<By, WebElement>> waitStrategyMapper = new EnumMap<>(WaitStrategy.class);
//    private static final long DEFAULT_WAIT_TIME_SECONDS = 30;
//    private static final WebDriverWait wait;
//
//    static {
//        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_WAIT_TIME_SECONDS));
//        waitStrategyMapper.put(WaitStrategy.CLICKABLE, by -> wait.until(ExpectedConditions.elementToBeClickable(by)));
//        waitStrategyMapper.put(WaitStrategy.PRESENCE, by -> wait.until(ExpectedConditions.presenceOfElementLocated(by)));
//        waitStrategyMapper.put(WaitStrategy.VISIBLE, by -> wait.until(ExpectedConditions.visibilityOfElementLocated(by)));
//    }
//
//    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {
//        return waitStrategyMapper.getOrDefault(waitStrategy, waitStrategyMapper.get(WaitStrategy.VISIBLE)).apply(by);
//    }
}
