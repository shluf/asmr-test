Feature: Citizen Account Registration
  As a Citizen
  I want to register on the platform
  So that I can access services

  @positive
  Scenario: [TCW-111] A new citizen registers and waits for admin approval
    Given The user is on the landing page
    When The user clicks the "Register" button
    And I enter registration data as follows:
      | Name          | NIK              | Family Card No.   | Birthplace | Date of Birth | Gender     | Religion | Province | District            | RW     | RT     | Address       | Phone Number  | Email                      | Password |
      | Clara Wijaya  | 3201234567890001 | 3201234567890002  | Jakarta    | 01-01-1990    | Female     | Islam    | ACEH     | KABUPATEN SIMEULUE  | RW 001 | RT 001 | Jl. Test 123  | 081234567890  | positive.warga@example.com | password |
    And I click the register button
    Then I should see a successful registration message


  @negative
  Scenario: [TCW-101] A new citizen registers and waits for admin approval with incorrect input
    Given The user is on the landing page
    When The user clicks the "Register" button
    And I enter registration data as follows:
      | Name         | NIK            | Family Card No.  | Birthplace | Date of Birth | Gender    | Religion | Province | District            | RW     | RT     | Address       | Phone Number  | Email                      | Password |
      | Arya Wiguna  | 32012345678001 | 32012347890002   | Sleman     | 01-01-2004    | Male      | Christian| ACEH     | KABUPATEN SIMEULUE  | RW 001 | RT 001 | Jl. Test 123  | 081234567890  | negative.warga@example.com | pass     |
    And I click the register button
    Then I should see a popup with a failed registration message

