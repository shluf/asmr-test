# language: en
Feature: Citizen Account Registration
  As a Citizen
  I want to register on the platform
  So that I can access services

  @positive
  Scenario: [TCW-111] New citizen registers and waits for admin approval
    Given I am on the landing page
    When I click the "Registrasi" button
    Then I enter the following registration data:
      | Name         | NIK              | No. KK           | Place of Birth | Date of Birth | Gender    | Religion | Province | Regency            | RW     | RT     | Address      | Phone Number | Email                      | Password |
      | Clara Wijaya | 3201234567890001 | 3201234567890002 | Jakarta        | 01-01-1990    | Perempuan | Islam    | ACEH     | KABUPATEN SIMEULUE | RW 001 | RT 001 | Jl. Test 123 | 081234567890 | positive.warga@example.com | password |
    And I click the register button
    Then I should see a successful registration message
    Then I click the confirm button
    When I log in as an admin with email "admin.utama@example.com" and password "password"
    Then I should be on the "Dashboard Admin" page
    Then I as "Admin" open the "Approval Role" page
    Then I should see "Clara Wijaya" in the approval list

  @negative
  Scenario: [TCW-101] New citizen registers with invalid input and waits for admin approval
    Given I am on the landing page
    When I click the "Registrasi" button
    Then I enter the following registration data:
      | Name         | NIK            | No. KK         | Place of Birth | Date of Birth | Gender    | Religion | Province | Regency            | RW     | RT     | Address      | Phone Number | Email                      | Password |
      | Arya Wiguna  | 32012345678001 | 32012347890002 | Sleman         | 01-01-2004    | Laki-laki | Kristen  | ACEH     | KABUPATEN SIMEULUE | RW 001 | RT 001 | Jl. Test 123 | 081234567890 | negative.warga@example.com | pass     |
    And I click the register button
    Then I should see a registration failed popup message
    And I click the close button
    Then an error message should be displayed below the input