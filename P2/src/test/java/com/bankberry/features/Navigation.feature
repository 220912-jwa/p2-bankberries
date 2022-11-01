Feature: Navigation

  Scenario Outline: A user can navigate with the navigation links to the correct page
    Given the user is logged in and on the Account Home page
    When a user clicks on the "<Link>"
    Then the user should be on the "<Link Title>" page

    Examples:
      | Link            | Link Title        |
      | Apply for Loan| Loan Application  |
      | Home            | Home              |
      | Contact Us      | Contact Us        |
      | Profile         | Profile           |


  Scenario: A user can view Checking Account details
      Given the user is logged in and on the Account Home page
      When the user clicks on Checking Account
      Then the user can see their checking account details


  Scenario: A user can view Savings Account details
    Given the user is logged in and on the Account Home page
    When the user clicks on Savings Account
    Then the user can see their savings account details