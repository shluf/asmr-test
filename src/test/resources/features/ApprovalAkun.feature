Feature: Approval Akun

  As an Admin
  I want to approve warga accounts
  So that warga can access the application after approval

  Background:
    Given User is on the landing page
    When User click login button
    Then User should be redirected to the login page
    When User submit valid credentials
    Then User should be redirected to the dashboard

  @approval
  Scenario: [TCA-211] Admin approves a warga account successfully
    Given User is on the Dashboard Admin page as Admin
    And User clicks on the Approval Akun menu
    And User is on the Approval Akun page
    When User clicks on the Approve button  with name "Clara Wijaya"
    Then User should see a success message