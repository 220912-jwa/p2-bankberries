package com.bankberry.steps;

import com.bankberry.runner.Runner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginNegativeSteps {
    WebDriver driver = Runner.driver;

    @When("the user types in the incorrect username")
    public void theUserTypesInTheIncorrectUsername() {
        driver.findElement(By.id("usernameInput")).sendKeys("");
    }

    @Then("the user should see an alert")
    public void theUserShouldSeeAnAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @When("the user types in the incorrect password")
    public void theUserTypesInTheIncorrectPassword() {
        driver.findElement(By.id("passwordInput")).sendKeys("");
    }
}
