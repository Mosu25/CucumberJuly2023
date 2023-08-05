package org.mosu.pages;

import org.mosu.enums.WaitStrategy;
import org.openqa.selenium.By;

import static org.mosu.utils.SeleniumUtils.*;

public class HomePage {

    private static final By ADD_BOOK_TO_CART = By.xpath("(//button[@color='primary']//span)[1]");
    private static final By CLEAR_CART = By.xpath("//span[.='Clear cart']");
    private static final By SNACK_BAR = By.tagName("snack-bar-container");

    public HomePage addBookToCart() {
        click(ADD_BOOK_TO_CART, WaitStrategy.CLICKABLE);
        isDisplayed(SNACK_BAR,WaitStrategy.VISIBLE);
        isInvisibility(SNACK_BAR);
        return this;
    }
    public boolean clickClearCartButton() {
        click(CLEAR_CART, WaitStrategy.CLICKABLE);
        return isDisplayed(ADD_BOOK_TO_CART, WaitStrategy.VISIBLE);
    }
}
