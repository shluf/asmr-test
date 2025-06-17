# Proyek Pengujian Otomatis ASMR

Proyek ini berisi serangkaian pengujian otomatis untuk aplikasi ASMR dengan alamat website sebagai berikut ini asmr-fe.vpsdzaky.cloud, yang dibuat menggunakan Selenium dan Cucumber. Proyek ini mengikuti pola desain Page Object Model (POM) untuk pemeliharaan dan skalabilitas yang lebih baik.

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
* **`QaseIO/Export Qase IO_Kelompok 10.pdf`**: Berisi ekspor kasus uji dari Qase, yang menguraikan skenario pengujian fungsional untuk aplikasi.
* **`src/main/java/pageobjects`**: Berisi kelas-kelas Page Object yang merepresentasikan berbagai halaman dalam aplikasi. Ini memisahkan logika interaksi UI dari skrip pengujian.
    * **`admin`**: Page Objects yang terkait dengan dasbor admin.
    * **`auth`**: Page Objects untuk halaman otentikasi seperti login dan registrasi.
    * **`rtrw`**: Page Objects untuk dasbor RT/RW.
    * **`warga`**: Page Objects untuk alur kerja spesifik warga, seperti pengajuan dan histori surat.
* **`src/main/java/type`**: Berisi tipe enumerasi yang digunakan di seluruh proyek, seperti peran pengguna (Admin, RT, RW, Warga).
* **`src/test/java/hooks`**: Berisi kelas hook untuk mengelola siklus hidup driver WebDriver.
* **`src/test/java/stepdefinitions`**: Berisi kelas definisi langkah Cucumber yang mengimplementasikan langkah-langkah Gherkin dari file fitur.
* **`src/test/resources/features`**: Berisi file `.feature` Cucumber, yang ditulis dalam bahasa Gherkin untuk mendefinisikan skenario pengujian.
* **`src/test/java/TestRunner.java`**: Kelas runner JUnit untuk menjalankan pengujian Cucumber.

## Dependensi

Proyek ini menggunakan dependensi berikut, sebagaimana didefinisikan dalam `pom.xml`:

* **Selenium Java**: Untuk otomatisasi browser.
* **Cucumber Java & JUnit**: Untuk pengembangan berbasis perilaku (BDD) dan menjalankan pengujian.
* **JUnit & TestNG**: Kerangka kerja pengujian untuk menjalankan pengujian.

## Kasus Uji

Kasus uji untuk proyek ini didefinisikan dalam file `Export Qase IO_Kelompok 10.pdf` dan diimplementasikan sebagai skenario Cucumber. Beberapa kasus uji utama meliputi:

* **Registrasi Akun Warga**: Memverifikasi bahwa warga dapat berhasil mendaftar untuk akun baru dan bahwa permintaan persetujuan mereka muncul di dasbor admin.
* **Login Akun**: Memverifikasi bahwa berbagai peran pengguna (Warga, Admin, RT, RW) dapat berhasil login ke dalam sistem.
* **Pengajuan Surat**: Memastikan bahwa warga dapat mengisi dan mengajukan formulir permintaan surat.
* **Persetujuan Surat**: Memverifikasi alur kerja persetujuan surat oleh RT dan RW.
* **Penolakan Surat**: Memastikan bahwa RW dapat menolak permintaan surat.
* **Unduh Surat**: Memverifikasi bahwa warga dapat mengunduh surat yang telah disetujui dan tidak dapat mengunduh surat yang ditolak.

## Menjalankan Pengujian

Untuk menjalankan pengujian, gunakan perintah Maven berikut dari direktori root proyek:

```bash
mvn clean test
```

Perintah ini akan menjalankan semua skenario Cucumber yang ditentukan dalam file fitur menggunakan `TestRunner.java`. Laporan pengujian akan dibuat di direktori `target/`.

### Prasyarat

* Java Development Kit (JDK) versi 22 atau lebih tinggi.
* Apache Maven diinstal dan dikonfigurasi.
* Browser web yang kompatibel (misalnya, Chrome) dan WebDriver yang sesuai ditempatkan di PATH sistem.

## Pengaturan Proyek IDE

Proyek ini berisi file konfigurasi untuk IntelliJ IDEA, tetapi dapat diimpor ke IDE lain yang mendukung proyek Maven. File `.gitignore` dikonfigurasi untuk mengecualikan file spesifik IDE dan file build dari kontrol versi.
