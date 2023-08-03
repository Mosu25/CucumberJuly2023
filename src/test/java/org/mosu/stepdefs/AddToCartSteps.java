package org.mosu.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mosu.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddToCartSteps {

    private WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
    @Given("user login into the application with {string} and {string}")
    public void userLoginIntoTheApplicationWithAnd(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-placeholder='Username']"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-placeholder='Password']"))).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[color='primary']"))).click();
        boolean displayed = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]")))
                .isDisplayed();
        Assert.assertEquals(displayed,true);
    }
    @Given("user search for a {string}")
    public void userSearchForA(String book) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']"))).sendKeys(book);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.mat-option-text"))).click();
    }
    @When("user add the book to the cart")
    public void userAddTheBookToTheCart() {
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("(//button[@color='primary']//span)[1]"))).click();
    }
    @Then("the cart badge should get updated")
    public void theCartBadgeShouldGetUpdated() {
        WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("snack-bar-container")));
        wait.until(ExpectedConditions.visibilityOf(snackBar));
        wait.until(ExpectedConditions.invisibilityOf(snackBar));
        String count = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#mat-badge-content-0"))).getText();
        Assert.assertEquals(Integer.parseInt(count)>0,true);
    }

}
