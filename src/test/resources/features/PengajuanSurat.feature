# language: en
Feature: Citizen Letter Submission
  As a citizen, I want to be able to submit a letter request.

  @positive
  Scenario: [TCW-311] Citizen successfully submits a letter
    Given I am on the landing page
    When I click the "Login" button
    Then I am logged in as "warga.andi@example.com" with password "password"
    And I am on the "Pengajuan" sub menu
    When I fill the letter submission form as follows:
      | Name         | NIK              | Gender    | Religion | Place and Date of Birth | Phone Number | Address                            | Letter Type                   |
      | Andi Saputra | 3404010101000001 | Laki-laki | Islam    | Sleman, 01-01-1995      | 081234567891 | Jl. Merpati No. 101, Kampung Damai | Surat Domisili Tempat tinggal |
    And I click the "Ajukan" button
    Then I should see a successful submission popup