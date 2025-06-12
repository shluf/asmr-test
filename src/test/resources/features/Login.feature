Feature: User Login

  As a user, I want to log in to the application to access my dashboard.

  @Login
  Scenario: Successful login with valid credentials
    Given User is on the landing page
    When User click login button
    Then User should be redirected to the login page
    Given User is on the login page
    When User submit valid credentials
    Then User should be redirected to the dashboard