package org.mosu.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mosu.pages.HeaderPage;
import org.mosu.pages.HomePage;
import org.mosu.pages.LoginPage;
import org.testng.Assert;

public class AddToCartSteps {

//    private WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));

    HeaderPage headerPage = new HeaderPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("user login into the application with {string} and {string}")
    public void userLoginIntoTheApplicationWithAnd(String username, String password) {

        loginPage.loginToBookCartApplication(username,password);

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-placeholder='Username']"))).sendKeys(username);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-placeholder='Password']"))).sendKeys(password);
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[color='primary']"))).click();
//        boolean displayed = wait.until(ExpectedConditions
//                        .visibilityOfElementLocated(By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]")))
//                .isDisplayed();
//        Assert.assertEquals(displayed,true);
    }
    @Given("user search for a {string}")
    public void userSearchForA(String book) {
        headerPage.searchBook(book);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']"))).sendKeys(book);
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.mat-option-text"))).click();
    }
    @When("user add the book to the cart")
    public void userAddTheBookToTheCart() {
        homePage.addBookToCart();
//        wait.until(ExpectedConditions
//                .elementToBeClickable(By.xpath("(//button[@color='primary']//span)[1]"))).click();
    }
    @Then("the cart badge should get updated")
    public void theCartBadgeShouldGetUpdated() {
        String badgeCount = headerPage.validateBadge();
        Assert.assertEquals(Integer.parseInt(badgeCount)>0,true);

//        WebElement snackBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("snack-bar-container")));
//        wait.until(ExpectedConditions.visibilityOf(snackBar));
//        wait.until(ExpectedConditions.invisibilityOf(snackBar));
//        String count = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#mat-badge-content-0"))).getText();
//        Assert.assertEquals(Integer.parseInt(count)>0,true);
    }

}
