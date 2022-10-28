Feature: Transactions

  Scenario: A user can view their checking account transactions
    Given the user is logged in and on the Account Home page
    When the user clicks on Checking Account
    When the user clicks on Transfer funds
    When user selects Checking account in From textbox
    When user selects Saving account in To textbox
    When user types in funds amount to transfer
    When user clicks on submit
    Then user is redirected to Account home if transfer is successful
    When user clicks on Checking Account
    Then the user should see their checking account transactions

  Scenario: A user can view their savings account transactions
    Given the user is logged in and on the Account Home page
    When the user clicks on savings account
    Then the user should see their savings account transactions