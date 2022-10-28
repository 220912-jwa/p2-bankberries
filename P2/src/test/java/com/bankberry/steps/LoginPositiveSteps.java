package com.bankberry.steps;

import com.bankberry.runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPositiveSteps {
    WebDriver driver = Runner.driver;
    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        driver.get("");
    }

    @When("the user clicks on member login")
    public void theUserClicksOnMemberLogin() {
        driver.findElement(By.id("managerButton")).click();
    }

    @Then("the users should be on the Member Login page")
    public void theUsersShouldBeOnThe() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("submitButton")));
        assertEquals("Bankberries Member Login", driver.findElement(By.id("loginH1")).getText());
    }

    @When("the user types in the correct username")
    public void theUserTypesInTheCorrectUsername() {
        driver.findElement(By.id("usernameInput")).sendKeys("mrKing@fakeDomain.com");
    }

    @When("the user types in the correct password")
    public void theUserTypesInTheCorrectPassword() {
        driver.findElement(By.id("passwordInput")).sendKeys("password");
    }

    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        driver.findElement(By.id("submitButton")).click();
    }

    @Then("the user should be on the Account Home page")
    public void theUserShouldBeOnThePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("savingsTable")));
        assertEquals("This is an actual home page",driver.findElement(By.id("homeH1")).getText());
    }
}
