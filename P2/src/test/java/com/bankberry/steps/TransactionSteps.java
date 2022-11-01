package com.bankberry.steps;

import com.bankberry.runner.Runner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TransactionSteps {
    WebDriver driver = Runner.driver;
    @When("the user clicks on Checking Account")
    public void theUserClicksOnCheckingAccount() {
        driver.findElement(By.linkText("Checking Account")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Transfer funds")));
    }

    @When("the user clicks on Transfer funds")
    public void theUserClicksOnTransferFunds() {
        driver.findElement(By.linkText("Transfer funds")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Submit')]")));
    }

    @When("user selects Checking account in From textbox")
    public void userSelectsCheckingAccountInFromTextbox() {
        Select se = new Select(driver.findElement(By.id("accounts")));
        se.selectByVisibleText("Checking Account");
    }

    @When("user selects Saving account in To textbox")
    public void userSelectsSavingAccountInToTextbox() {
        Select se = new Select(driver.findElement(By.id("toAccounts")));
        se.selectByVisibleText("Savings Account");
    }

    @When("user types in funds amount to transfer")
    public void userTypesInFundsAmountToTransfer() {
        driver.findElement(By.id("transferAmount")).sendKeys("150");
    }

    @When("user clicks on submit")
    public void userClicksOnSubmit() {
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
    }

    @Then("user is redirected to Account home when transfer is successful")
    public void userIsRedirectedToAccountHomeWhenTransferIsSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("accountBalance")));
        assertEquals("This is an actual home page",driver.findElement(By.id("homeH1")).getText());
    }



    @When("the user clicks on Savings Account")
    public void theUserClicksOnSavingsAccount() {
        driver.findElement(By.linkText("Savings Account")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Transfer funds")));
    }

    @When("user selects Savings account in From textbox")
    public void userSelectsSavingsAccountInFromTextbox() {
        Select se = new Select(driver.findElement(By.id("accounts")));
        se.selectByVisibleText("Savings Account");
    }

    @When("user selects Checking account in To textbox")
    public void userSelectsCheckingAccountInToTextbox() {
        Select se = new Select(driver.findElement(By.id("toAccounts")));
        se.selectByVisibleText("Checking Account");
    }


}
