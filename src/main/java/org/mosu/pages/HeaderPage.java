package org.mosu.pages;

import org.mosu.enums.WaitStrategy;
import org.openqa.selenium.By;

import static org.mosu.utils.SeleniumUtils.*;

public class HeaderPage {

    private static final By LOGIN_LINK = By.xpath("//span[.='Login']/..");
    private static final By SEARCH_BOOK = By.cssSelector("input[type='search']");
    private static final By CLICK_SEARCHED_BOOK = By.cssSelector("span.mat-option-text");
    private static final By BADGE_COUNT = By.cssSelector("#mat-badge-content-0");
    private static final By CLICK_BADGE_Link = By.xpath("(//mat-icon[contains(@class,'mat-icon notranslate')])[3]");
    private static final By IS_DISPLAY_USERNAME = By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]");

    public void clickLoginLink() {
        click(LOGIN_LINK, WaitStrategy.CLICKABLE);
    }

    public HeaderPage searchBook(String bookName) {
        isDisplayed(IS_DISPLAY_USERNAME,WaitStrategy.VISIBLE);
        sendKeys(SEARCH_BOOK,bookName,WaitStrategy.VISIBLE);
        click(CLICK_SEARCHED_BOOK,WaitStrategy.CLICKABLE);
        return this;
    }

    public String validateBadge() {
       return getText(BADGE_COUNT, WaitStrategy.VISIBLE);

    }
    public HeaderPage clickBadgeLink(){
        click(CLICK_BADGE_Link,WaitStrategy.CLICKABLE);
        return this;
    }

}
