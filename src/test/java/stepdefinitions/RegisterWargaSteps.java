package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.LandingPage;
import pageobjects.admin.DashboardAdminPage;
import pageobjects.auth.LoginPage;
import pageobjects.auth.RegisterPage;
import pageobjects.warga.DashboardWargaPage;

import java.time.Duration;

public class RegisterWargaSteps {
    private final WebDriver driver;
    private final LandingPage landingPage;
    private final RegisterPage registerPage;

    public RegisterWargaSteps() {
        this.driver = hooks.UseDriver.getDriver();
        this.landingPage = new LandingPage(driver);
        this.registerPage = new RegisterPage(driver);
    }
//    @Given("User is on the landing page As Warga")
//    public void user_is_on_the_landing_page_as_warga() {
//        driver.get("https://asmr-fe.vpsdzaky.cloud");
//        Assert.assertTrue("Landing page is not displayed", landingPage.isProductsTitleDisplayed());
//        String expectedUrl = "https://asmr-fe.vpsdzaky.cloud/";
//        Assert.assertEquals("User is not on the landing page", expectedUrl, driver.getCurrentUrl());
//    }
//    @Given("User clicks register button")
//    public void user_click_register_button() {
//        landingPage.clickRegister();
//    }
//    @Given("User is on the registration page")
//    public void user_is_on_the_register_page() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div[2]/div/h1")));
//        Assert.assertTrue("Registration title is not displayed", registerPage.isTitleDisplayed());
//    }
//    @When("user enters name {string}")
//    public void user_enters_name(String name) {
//        registerPage.enterName(name);
//    }
//
//    @When("user enters NIK {string}")
//    public void user_enters_NIK(String nik) {
//        registerPage.enterNIK(nik);
//    }
//
//    @When("user enters Nomer KK {string}")
//    public void user_enters_nomer_kk(String nomerKK) {
//        registerPage.enterNomerKK(nomerKK);
//    }
//
//    @When("user enters tempat lahir {string}")
//    public void user_enters_tempat_lahir(String tempatLahir) {
//        registerPage.enterTempatLahir(tempatLahir);
//    }
//
//    @When("user enters tanggal lahir {string}")
//    public void user_enters_tanggal_lahir(String tanggalLahir) {
//        registerPage.enterTanggalLahir(tanggalLahir);
//    }
//
//    @When("user selects jenis kelamin")
//    public void user_selects_jenis_kelamin() {
//        registerPage.selectJenisKelamin();
//    }
//
//    @When("user selects agama")
//    public void user_selects_agama() {
//        registerPage.selectAgama();
//    }
//
//    @When("user selects provinsi")
//    public void user_selects_provinsi() {
//        registerPage.selectProvinsi();
//    }
//
//    @When("user selects kabupaten")
//    public void user_selects_kabupaten() {
//        registerPage.selectKabupaten();
//    }
//
//    @When("user selects RW")
//    public void user_selects_rw() {
//        registerPage.selectRW();
//    }
//
//    @When("user selects RT")
//    public void user_selects_rt() {
//        registerPage.selectRT();
//    }
//
//    @When("user enters phone {string}")
//    public void user_enters_phone(String phone) {
//        registerPage.enterPhone(phone);
//    }
//
//    @When("user enters alamat {string}")
//    public void user_enters_alamat(String alamat) {
//        registerPage.enterAlamat(alamat);
//    }
//
//    @When("user enters email {string}")
//    public void user_enters_email(String email) {
//        registerPage.enterEmail(email);
//    }
//
//    @When("user enters password {string}")
//    public void user_enters_password(String password) {
//        registerPage.enterPassword(password);
//    }
//
//    @When("user enters konfirmasi password {string}")
//    public void user_enters_konfirmasi_password(String konfirmasiPassword) {
//        registerPage.enterKonfirmasiPassword(konfirmasiPassword);
//    }
//
//    @When("user clicks register button")
//    public void user_clicks_register_button() {
//        registerPage.clickRegisterButton();
//    }
//
//    @Then("user should see registration success message")
//    public void user_should_see_registration_success_message() {
//        // Tunggu dan cek notifikasi sukses (ganti xpath/css sesuai notifikasi-mu)
//        boolean isSuccessVisible = driver.getPageSource().contains("Register berhasil")
//                || driver.getPageSource().contains("Pendaftaran berhasil");
//
//        Assert.assertTrue("Registration success message is not visible", isSuccessVisible);
//        driver.quit();
//    }
//    @Then("user should see Password error message")
//    public void user_should_see_nik_error_message() {
//        Assert.assertTrue(" error message is not displayed", registerPage.isPasswordErrorDisplayed());
//        driver.quit();
//    }
}

