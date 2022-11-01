package com.bankberry.steps;

import com.bankberry.runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavSteps {
    WebDriver driver = Runner.driver;

    @Given("the user is logged in and on the Account Home page")
    public void thatTheUserIsLoggedInAndOnTheAccountHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("C:\\Users\\Nicholas\\training-repos\\p2-bankberries\\P2\\src\\main\\resources\\public\\HTML\\index.html");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("managerButton")));
        driver.findElement(By.id("managerButton")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("submitButton")));
        driver.findElement(By.id("usernameInput")).sendKeys("mrKing@fakeDomain.com");
        driver.findElement(By.id("passwordInput")).sendKeys("password");
        driver.findElement(By.id("submitButton")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("accountBalance")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("savingsBalance")));
        WebElement checkingBalance = driver.findElement(By.id("accountBalance"));
        WebElement savingsBalance = driver.findElement(By.id("savingsBalance"));
        wait.until(ExpectedConditions.textToBePresentInElement((checkingBalance), "$"));
        wait.until(ExpectedConditions.textToBePresentInElement((savingsBalance), "$"));
    }

    @When("a user clicks on the {string}")
    public void aUserClicksOnThe(String arg0) {
        driver.findElement(By.linkText(arg0)).click();
    }

    @Then("the user should be on the {string} page")
    public void theUserShouldBeOnThePage(String arg0) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleIs(arg0));
        assertEquals(arg0, driver.getTitle());
    }

    @Then("the user can see their checking account details")
    public void theUserCanSeeTheirCheckingAccountDetails() {
        assertEquals("Checking Account", driver.findElement(By.id("checkingH1")).getText());
    }

    @Then("the user can see their savings account details")
    public void theUserCanSeeTheirSavingsAccountDetails() {
        assertEquals("Checking Account", driver.findElement(By.id("savingsH1")).getText());
    }
}
