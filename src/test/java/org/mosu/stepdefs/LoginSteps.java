package org.mosu.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mosu.pages.LoginPage;
import org.testng.Assert;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("User enter the username as {string}")
    public void userEnterTheUsernameAs(String username) {
            loginPage.setUsername(username);
//        DriverManager.getDriver().findElement(By.xpath("//input[@data-placeholder='Username']")).sendKeys(username);
    }

    @Given("User enter the password as {string}")
    public void userEnterThePasswordAs(String password) {
        loginPage.setPassword(password);
//        DriverManager.getDriver().findElement(By.xpath("//input[@data-placeholder='Password']")).sendKeys(password);
    }

    @When("User click on the login button")
    public void userClickOnTheLoginButton() {
        loginPage.clickLogin();
//        DriverManager.getDriver().findElement(By.xpath("//button[@color='primary']//span[1]")).click();
    }

    @Then("Login should be success")
    public void loginShouldBeSuccess() {

        String loginSuccess = loginPage.loginShouldBeSuccess();
        Assert.assertEquals(loginSuccess, "Mosu2023");

//        WebElement userName = DriverManager.getDriver()
//                .findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]"));
//        String substring = userName.getText().trim().substring(15, 23);
//        Assert.assertEquals(substring, "Mosu2023");

//        Driver.quitDriver();
    }

    @When("Login should fail")
    public void loginShouldFail() {

        String loginError = loginPage.loginShouldBeFail();
        Assert.assertEquals(loginError.trim(), "Username or Password is incorrect.");

//        String loginError = DriverManager.getDriver()
//                .findElement(By.cssSelector("mat-error[role='alert']")).getText();
//        Assert.assertEquals(loginError.trim(), "Username or Password is incorrect.");
//        Driver.quitDriver();
    }


}
