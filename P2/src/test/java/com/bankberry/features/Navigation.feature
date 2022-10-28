Feature: Navigation

  Scenario Outline: A user can navigate with the navigation links to the correct page
    Given the user is logged in and on the Account Home page
    When a user clicks on the "<Link>"
    Then the user should be on the "<Link Title>" page

    Examples:
      | Link            | Link Title        |
      | Checking Account| Checking Home     |
      | Savings Account | Savings Home      |
      | Apply for a loan| Loan Application  |
      | Home            | Home              |
