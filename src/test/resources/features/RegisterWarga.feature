Feature: Warga Registration
  As a Warga
  I want to register on the platform
  So that I can access services


@positive
Scenario: Warga registers successfully
  Given User is on the landing page As Warga
  Given User clicks register button
  Given User is on the registration page
  When user enters name "Joko"
  And user enters NIK "1234567890123456"
  And user enters Nomer KK "9876543210987654"
  And user enters tempat lahir "Yogyakarta"
  And user enters tanggal lahir "01-01-1990"
  And user selects jenis kelamin
  And user selects agama
  And user selects provinsi
  And user selects kabupaten
  And user selects RW
  And user selects RT
  And user enters phone "081234567890"
  And user enters alamat "Jl. Merdeka No.1"
  And user enters email "joko.warga@mail.com"
  And user enters password "Password123"
  And user enters konfirmasi password "Password123"
  And user clicks register button
  Then user should see registration success message

@negative
Scenario: Warga registers with invalid NIK
  Given User is on the landing page As Warga
  Given User clicks register button
  Given User is on the registration page
  When user enters name "Budi"
  And user enters NIK "12345"
  And user enters Nomer KK "9876543210987654"
  And user enters tempat lahir "Yogyakarta"
  And user enters tanggal lahir "01-01-1990"
  And user selects jenis kelamin
  And user selects agama
  And user selects provinsi
  And user selects kabupaten
  And user selects RW
  And user selects RT
  And user enters phone "081234567890"
  And user enters alamat "Jl. Merdeka No.1"
  And user enters email "budi@example.com"
  And user enters password "Password123"
  And user enters konfirmasi password "Password123"
  And user clicks register button
  Then user should see Password error message
