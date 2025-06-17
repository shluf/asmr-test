# Proyek Pengujian Otomatis ASMR

Proyek ini berisi serangkaian pengujian otomatis untuk aplikasi ASMR, yang dibuat menggunakan Selenium dan Cucumber. Proyek ini mengikuti pola desain Page Object Model (POM) untuk pemeliharaan dan skalabilitas yang lebih baik.

## Ikhtisar Proyek

Tujuan dari proyek ini adalah untuk mengotomatisasi pengujian fungsional dari aplikasi AS_Musyawarah_Warga (ASMR). Pengujian ini mencakup berbagai alur kerja pengguna, seperti registrasi akun, login, pengajuan surat, dan proses persetujuan oleh RT/RW dan admin.

## Struktur Proyek

Proyek ini diatur ke dalam struktur direktori Maven standar:

```
.
├── QaseIO
│   └── Export Qase IO_Kelompok 10.pdf
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       ├── pageobjects
│   │       │   ├── admin
│   │       │   ├── auth
│   │       │   ├── rtrw
│   │       │   └── warga
│   │       └── type
│   └── test
│       ├── java
│       │   ├── hooks
│       │   └── stepdefinitions
│       └── resources
│           └── features
└── target
```

### Deskripsi File dan Direktori

* **`pom.xml`**: File Project Object Model (POM) Maven yang mendefinisikan dependensi proyek, plugin, dan konfigurasi build.
* **`QaseIO/Export Qase IO_Kelompok 10.pdf`**: Berisi ekspor kasus uji dari Qase, yang menguraikan skenario pengujian fungsional untuk aplikasi. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/QaseIO/Export Qase IO_Kelompok 10.pdf]
* **`src/main/java/pageobjects`**: Berisi kelas-kelas Page Object yang merepresentasikan berbagai halaman dalam aplikasi. Ini memisahkan logika interaksi UI dari skrip pengujian. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/main/java/pageobjects/BasePage.java]
    * **`admin`**: Page Objects yang terkait dengan dasbor admin. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/main/java/pageobjects/admin/AdminLayout.java, shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/main/java/pageobjects/admin/ApprovalRolePage.java, shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/main/java/pageobjects/admin/DashboardAdminPage.java]
    * **`auth`**: Page Objects untuk halaman otentikasi seperti login dan registrasi. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/main/java/pageobjects/auth/LoginPage.java, shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/main/java/pageobjects/auth/RegisterPage.java]
    * **`rtrw`**: Page Objects untuk dasbor RT/RW. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/main/java/pageobjects/rtrw/DashboardRtRwPage.java, shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/main/java/pageobjects/rtrw/PengajuanWargaPage.java, shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/main/java/pageobjects/rtrw/RtRwLayout.java]
    * **`warga`**: Page Objects untuk alur kerja spesifik warga, seperti pengajuan dan histori surat. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/main/java/pageobjects/warga/DashboardWargaPage.java, shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/main/java/pageobjects/warga/HistoriPengajuanPage.java, shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/main/java/pageobjects/warga/PengajuanPage.java, shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/main/java/pageobjects/warga/PengajuanSuratPage.java, shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/main/java/pageobjects/warga/WargaLayout.java]
* **`src/main/java/type`**: Berisi tipe enumerasi yang digunakan di seluruh proyek, seperti peran pengguna (Admin, RT, RW, Warga). [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/main/java/type/Role.java]
* **`src/test/java/hooks`**: Berisi kelas hook untuk mengelola siklus hidup driver WebDriver. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/test/java/hooks/UseDriver.java]
* **`src/test/java/stepdefinitions`**: Berisi kelas definisi langkah Cucumber yang mengimplementasikan langkah-langkah Gherkin dari file fitur. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/test/java/stepdefinitions/ApprovalAkunSteps.java, shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/test/java/stepdefinitions/ApprovalSuratSteps.java, shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/test/java/stepdefinitions/CommonSteps.java, shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/test/java/stepdefinitions/DownloadSuratSteps.java, shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/test/java/stepdefinitions/LoginSteps.java, shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/test/java/stepdefinitions/PengajuanSuratSteps.java, shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/test/java/stepdefinitions/RegisterWargaSteps.java]
* **`src/test/resources/features`**: Berisi file `.feature` Cucumber, yang ditulis dalam bahasa Gherkin untuk mendefinisikan skenario pengujian.
* **`src/test/java/TestRunner.java`**: Kelas runner JUnit untuk menjalankan pengujian Cucumber. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/src/test/java/TestRunner.java]

## Dependensi

Proyek ini menggunakan dependensi berikut, sebagaimana didefinisikan dalam `pom.xml`:

* **Selenium Java**: Untuk otomatisasi browser. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/pom.xml]
* **Cucumber Java & JUnit**: Untuk pengembangan berbasis perilaku (BDD) dan menjalankan pengujian. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/pom.xml]
* **JUnit & TestNG**: Kerangka kerja pengujian untuk menjalankan pengujian. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/pom.xml]

## Kasus Uji

Kasus uji untuk proyek ini didefinisikan dalam file `Export Qase IO_Kelompok 10.pdf` dan diimplementasikan sebagai skenario Cucumber. Beberapa kasus uji utama meliputi:

* **Registrasi Akun Warga**: Memverifikasi bahwa warga dapat berhasil mendaftar untuk akun baru dan bahwa permintaan persetujuan mereka muncul di dasbor admin. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/QaseIO/Export Qase IO_Kelompok 10.pdf]
* **Login Akun**: Memverifikasi bahwa berbagai peran pengguna (Warga, Admin, RT, RW) dapat berhasil login ke dalam sistem. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/QaseIO/Export Qase IO_Kelompok 10.pdf]
* **Pengajuan Surat**: Memastikan bahwa warga dapat mengisi dan mengajukan formulir permintaan surat. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/QaseIO/Export Qase IO_Kelompok 10.pdf]
* **Persetujuan Surat**: Memverifikasi alur kerja persetujuan surat oleh RT dan RW. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/QaseIO/Export Qase IO_Kelompok 10.pdf]
* **Penolakan Surat**: Memastikan bahwa RW dapat menolak permintaan surat. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/QaseIO/Export Qase IO_Kelompok 10.pdf]
* **Unduh Surat**: Memverifikasi bahwa warga dapat mengunduh surat yang telah disetujui dan tidak dapat mengunduh surat yang ditolak. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/QaseIO/Export Qase IO_Kelompok 10.pdf]

## Menjalankan Pengujian

Untuk menjalankan pengujian, gunakan perintah Maven berikut dari direktori root proyek:

```bash
mvn clean test
```

Perintah ini akan menjalankan semua skenario Cucumber yang ditentukan dalam file fitur menggunakan `TestRunner.java`. Laporan pengujian akan dibuat di direktori `target/`.

### Prasyarat

* Java Development Kit (JDK) versi 22 atau lebih tinggi. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/pom.xml]
* Apache Maven diinstal dan dikonfigurasi.
* Browser web yang kompatibel (misalnya, Chrome) dan WebDriver yang sesuai ditempatkan di PATH sistem.

## Pengaturan Proyek IDE

Proyek ini berisi file konfigurasi untuk IntelliJ IDEA, tetapi dapat diimpor ke IDE lain yang mendukung proyek Maven. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/.idea/misc.xml, shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/.idea/compiler.xml, shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/.idea/jarRepositories.xml] File `.gitignore` dikonfigurasi untuk mengecualikan file spesifik IDE dan file build dari kontrol versi. [cite: shluf/asmr-test/asmr-test-8c34ec98c28c950e0411a74efdc37be1bb5be821/.gitignore]
