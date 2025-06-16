Feature: Registrasi Akun Warga
  As a Warga
  I want to register on the platform
  So that I can access services

  @positive
  Scenario: [TCW-111] Warga baru mendaftar dan menunggu approval dari admin
    Given saya berada di landing page
    When saya klik tombol "Registrasi"
    And saya memasukkan data registrasi sebagai berikut:
      | Nama         | NIK              | No. KK           | Tempat Lahir | Tanggal Lahir | Jenis Kelamin | Agama  | Provinsi     | Kabupaten          | RW      | RT      | Alamat       | No. Telepon  | Email                      | Password |
      | Clara Wijaya | 3201234567890001 | 3201234567890002 | Jakarta      | 01-01-1990    | Perempuan     | Islam  | ACEH         | KABUPATEN SIMEULUE | RW 001  | RT 001  | Jl. Test 123 | 081234567890 | positive.warga@example.com | password |
    And saya klik tombol daftar
    Then saya seharusnya melihat pesan registrasi berhasil
    When saya login sebagai admin dengan email "admin.utama@example.com" dan password "password"
    Then saya seharusnya berada di Halaman "Dashboard Admin"
    And saya membuka halaman "Approval Role"
    Then saya seharusnya melihat "Clara Wijaya" di dalam daftar approval

  @negative
  Scenario: [TCW-101] Warga baru mendaftar dan menunggu approval dari admin dengan memasukan input yang salah
    Given saya berada di landing page
    When saya klik tombol "Registrasi"
    And saya memasukkan data registrasi sebagai berikut:
      | Nama         | NIK            | No. KK         | Tempat Lahir | Tanggal Lahir | Jenis Kelamin | Agama    | Provinsi     | Kabupaten          | RW      | RT      | Alamat       | No. Telepon  | Email                      | Password |
      | Arya Wiguna  | 32012345678001 | 32012347890002 | Sleman       | 01-01-2004    | Laki-laki     | Kristen  | ACEH         | KABUPATEN SIMEULUE | RW 001  | RT 001  | Jl. Test 123 | 081234567890 | negative.warga@example.com | pass     |
    And saya klik tombol daftar
    Then saya seharusnya melihat popup dengan pesan registrasi gagal
    And saya klik tombol tutup
    Then seharusnya terdapat pesan error dibawah input