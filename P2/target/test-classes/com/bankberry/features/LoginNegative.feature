Feature: Login

  Scenario: A user logs in with the incorrect username and the correct password.
    Given the user is on the homepage
    When the user clicks on login
    Then the users should be on the "Login page"
    When the user types in the incorrect username
    When the user types in the correct password
    When the user clicks the login button
    Then the user should see an alert

    Scenario: A user logs in with the correct username and the incorrect password.
      Given the user is on the homepage
      When the user clicks on login
      Then the users should be on the "Login page"
      When the user types in the correct username
      When the user types in the incorrect password
      When the user clicks the login button
      Then the user should see an alert