package org.mosu.pages;

import org.mosu.enums.WaitStrategy;
import org.openqa.selenium.By;

import static org.mosu.utils.SeleniumUtils.*;

public class LoginPage{

    private static final By TXT_USERNAME = By.cssSelector("input[data-placeholder='Username']");
    private static final By TXT_PASSWORD = By.cssSelector("input[data-placeholder='Password']");
    private static final By BTN_LOGIN = By.cssSelector("button[color='primary']");
    private static final By IS_SUCCESS = By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]");
    private static final By IS_FAIL = By.cssSelector("mat-error[role='alert']");

    public LoginPage setUsername(String username) {
        sendKeys(TXT_USERNAME,username, WaitStrategy.VISIBLE);
        return this;
    }
    public LoginPage setPassword(String password) {
        sendKeys(TXT_PASSWORD,password,WaitStrategy.VISIBLE);
        return this;
    }
    public HomePage clickLogin() {
        click(BTN_LOGIN,WaitStrategy.CLICKABLE);
        return new HomePage();
    }
    public String loginShouldBeSuccess(){
        String text = getText(IS_SUCCESS, WaitStrategy.VISIBLE);
        return text.trim().substring(15, 23);
    }
    public String loginShouldBeFail(){
        String loginError = getText(IS_FAIL, WaitStrategy.VISIBLE);
        return loginError.trim();

    }

    public void loginToBookCartApplication(String username, String password){
        LoginPage loginPage = new LoginPage();
        loginPage.setUsername(username).setPassword(password).clickLogin();
    }
}
