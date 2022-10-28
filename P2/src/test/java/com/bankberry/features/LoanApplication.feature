Feature: Loan application

  Scenario: A user can submit a loan application
    Given the user is on the homepage
    When the user clicks on Apply for Loan
    Then the user should be on the loan application submission page
    When the user fills out an amount
    When the user fills out the term
    When the user clicks submit
    Then the user should see an alert
    Then the user should be redirected user home page
    Then the user should see the application in the pending applications table