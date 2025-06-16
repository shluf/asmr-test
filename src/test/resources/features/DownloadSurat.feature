# language: en
Feature: Citizen Letter Download
  As a citizen, I want to be able to download an approved letter.

  @positive
  Scenario: [TCW-411] Citizen successfully downloads an approved letter
    Given I am logged in as "warga.andi@example.com" with password "password"
    And the letter has been approved by RT and RW
    When I am on the "Histori Pengajuan" sub menu
    And I click the download icon for the approved letter
    Then I successfully download the letter

  @negative
  Scenario: [TCW-401] Citizen cannot download a rejected letter
    Given I am logged in as "warga.andi@example.com" with password "password"
    And the letter is rejected by RT or RW
    When I am on the "Histori Pengajuan" sub menu
    Then the download button should not be available for the rejected letter 