package org.mosu.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mosu.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginSteps {

    @Given("User enter the username as {string}")
    public void userEnterTheUsernameAs(String username) {
        DriverManager.getDriver().findElement(By.xpath("//input[@data-placeholder='Username']")).sendKeys(username);
    }

    @Given("User enter the password as {string}")
    public void userEnterThePasswordAs(String password) {
        DriverManager.getDriver().findElement(By.xpath("//input[@data-placeholder='Password']")).sendKeys(password);
    }

    @When("User click on the login button")
    public void userClickOnTheLoginButton() {
        DriverManager.getDriver().findElement(By.xpath("//button[@color='primary']//span[1]")).click();
    }

    @Then("Login should be success")
    public void loginShouldBeSuccess() {
        WebElement userName = DriverManager.getDriver()
                .findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]"));
        String substring = userName.getText().trim().substring(15, 23);
        System.out.println("userName = " + substring);
        Assert.assertEquals(substring, "Mosu2023");

//        Driver.quitDriver();
    }

    @When("Login should fail")
    public void loginShouldFail() {
        String loginError = DriverManager.getDriver()
                .findElement(By.cssSelector("mat-error[role='alert']")).getText();
        Assert.assertEquals(loginError.trim(), "Username or Password is incorrect.");
//        Driver.quitDriver();
    }


}
