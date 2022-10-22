Feature: Transactions

  Scenario: A user can view their checking account transactions
    Given the user is on the user home page
    When the user clicks on checking account
    Then the user should see their checking account transactions

  Scenario: A user can view their savings account transactions
    Given the user is on the user home page
    When the user clicks on savings account
    Then the user should see their savings account transactions