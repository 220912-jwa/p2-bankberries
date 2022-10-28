Feature: Login

  Scenario: The user logs in with the correct username and password.
    Given the user is on the homepage
    When the user clicks on member login
    Then the users should be on the Member Login page
    When the user types in the correct username
    When the user types in the correct password
    When the user clicks the login button
    Then the user should be on the Account Home page