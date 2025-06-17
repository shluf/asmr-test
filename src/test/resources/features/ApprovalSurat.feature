# language: en
Feature: Letter Approval by RT and RW

  @positive
  Scenario: [TCRT-111] RT successfully approves a letter
    Given I am logged in as "budi.rt@example.com" with password "password"
    When I as "RT" open the "Pengajuan Warga" page
    And I view and open the details of the latest letter
    And a letter has been submitted by a citizen:
      | Name          | Letter type                   |
      | Andi Saputra  | Surat Domisili Tempat tinggal |
    And I click the "Setujui" button on the letter
    And I logout
    Then I log in as "warga.andi@example.com" with password "password"
    And I as "RT" open the "Histori Pengajuan" page
    And I view the details of the latest letter
    Then the letter status should be "Disetujui RT"

  @positive
  Scenario: [TCRW-111] RW successfully approves a letter
    Given I am logged in as "citra.rw1@example.com" with password "password"
    When I as "RW" open the "Pengajuan Warga" page
    And I view and open the details of the latest letter
    And the letter has been approved by RT:
      | Name          | Letter type                   |
      | Andi Saputra  | Surat Domisili Tempat tinggal |
    And I click the "Setujui" button on the letter
    Then I should see a successful approval popup
    And I click the close button on the successful approval popup
    Then Publish button should be visible
    Then I click the publish button
    Then I should see a successful approval popup
    And I click the close button on the successful approval popup
    And I logout
    Then I log in as "warga.andi@example.com" with password "password"
    And I as "Warga" open the "Histori Pengajuan" page
    And I view the details of the latest letter
    Then the letter status should be "Disetujui"


  Scenario: [TCRW-101] RW successfully rejects a letter
    Given I am logged in as "citra.rw1@example.com" with password "password"
    When I as "RW" open the "Pengajuan Warga" page
    And I view and open the details of the latest letter
    And the letter has been approved by RT:
      | Name          | Letter type                   |
      | Andi Saputra  | Surat Domisili Tempat tinggal |
    And I click the "Tolak" button on the letter
    Then I should see a successful approval popup
    And I click the close button on the successful approval popup
    And I logout
    Then I log in as "warga.andi@example.com" with password "password"
    And I as "Warga" open the "Histori Pengajuan" page
    And I view the details of the latest letter
    Then the letter status should be "Ditolak" 