package com.bankberry.steps;

import com.bankberry.runner.Runner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanAppSteps {
    WebDriver driver = Runner.driver;
    @When("the user clicks on Apply for Loan")
    public void theUserClicksOnApplyForLoan() {
        driver.findElement(By.partialLinkText("Apply for Loan")).click();

    }

    @Then("the user should be on the loan application submission page")
    public void theUserShouldBeOnTheLoanApplicationSubmissionPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        assertEquals("Desired Loan Amount", driver.findElement(By.id("amountLabel")).getText());
        assertEquals("Desired Loan Term", driver.findElement(By.id("termLabel")).getText());
    }

    @When("the user fills out an amount")
    public void theUserFillsOutAnAmount() {
        driver.findElement(By.id("amount")).sendKeys("5000");
    }

    @When("the user fills out the term")
    public void theUserFillsOutTheTerm() {
        Select se = new Select(driver.findElement(By.id("term")));
        se.selectByValue("60");
    }

    @When("the user clicks submit")
    public void theUserClicksSubmit() {
        driver.findElement(By.id("submit")).click();
    }

    @Then("the user should be redirected user home page")
    public void theUserShouldBeRedirectedUserHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tr[last()]/td[contains(text(), 'Under Review')][last()]")));
        assertEquals("Home",driver.getTitle());
    }

    @Then("the user should see the application in the pending applications table")
    public void theUserShouldSeeTheApplicationInThePendingApplicationsTable() {
        assertEquals("Under Review",driver.findElement(By.xpath("//tr[last()]/td[contains(text(), 'Under Review')][last()]")).getText());
    }
}
