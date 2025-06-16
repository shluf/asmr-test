# language: en
Feature: Letter Approval by RT and RW

  Scenario: [TCRT-111] RT successfully approves a letter
    Given I am logged in as "budi.rt@example.com" with password "password"
    And a letter has been submitted by a citizen
    When I as "RT" open the "Pengajuan Warga" page
    And I view and open the details of the latest letter
    And I click the "Setujui" button
    And I logout
    Then I log in as "warga.andi@example.com" with password "password"
    And I as "RT" open the "Histori Pengajuan" page
    And I view the details of the latest letter
    Then the letter status should be "Disetujui RT"

  Scenario: [TCRW-111] RW successfully approves a letter
    Given I am logged in as "citra.rw1@example.com" with password "password"
    And the letter has been approved by RT
    When I as "RW" open the "Pengajuan Warga" page
    And I view and open the details of the latest letter
    And I click the "Setujui" button
    And I logout
    Then I log in as "warga.andi@example.com" with password "password"
    And I as "RW" open the "Histori Pengajuan" page
    And I view the details of the latest letter
    Then the letter status should be "Disetujui"

  Scenario: [TCRW-101] RW successfully rejects a letter
    Given I am logged in as "citra.rw1@example.com" with password "password"
    And the letter has been approved by RT
    When I as "RW" open the "Pengajuan Warga" page
    And I view and open the details of the latest letter
    And I click the "Tolak" button
    And I logout
    Then I log in as "warga.andi@example.com" with password "password"
    And I as "RW" open the "Histori Pengajuan" page
    And I view the details of the latest letter
    Then the letter status should be "Ditolak" 