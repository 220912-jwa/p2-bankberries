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

public class NavSteps {
    WebDriver driver = Runner.driver;

    @Given("the user is logged in and on the Account Home page")
    public void thatTheUserIsLoggedInAndOnTheAccountHomePage() {
        driver.get("");
        driver.findElement(By.id("managerButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("submitButton")));
        driver.findElement(By.id("usernameInput")).sendKeys("");
        driver.findElement(By.id("passwordInput")).sendKeys("");
        driver.findElement(By.id("submitButton")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("savingsTable")));
    }

    @When("a user clicks on the {string}")
    public void aUserClicksOnThe(String arg0) {
        driver.findElement(By.linkText(arg0)).click();
    }

    @Then("the user should be on the {string} page")
    public void theUserShouldBeOnThePage(String arg0) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("")));
        assertEquals(arg0, driver.findElement(By.id("")).getText());
    }
}
