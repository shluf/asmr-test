package stepdefinitions;

import hooks.UseDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobjects.LandingPage;
import pageobjects.admin.ApprovalRolePage;
import pageobjects.admin.DashboardAdminPage;
import pageobjects.auth.LoginPage;
import pageobjects.auth.RegisterPage;

import java.util.Map;

public class RegisterSteps {
    private final WebDriver driver;
    private final LoginPage loginPage;
    private final LandingPage landingPage;
    private final DashboardAdminPage dashboardAdminPage;
    private final ApprovalRolePage approvalRolePage;
    private final RegisterPage registerPage;

    public RegisterSteps() {
        this.driver = UseDriver.getDriver();
        this.loginPage = new LoginPage(driver);
        this.landingPage = new LandingPage(driver);
        this.approvalRolePage = new ApprovalRolePage(driver);
        this.dashboardAdminPage = new DashboardAdminPage(driver);
        this.registerPage = new RegisterPage(driver);
    }

    @Given("saya berada di landing page")
    public void saya_berada_di_landing_page() {
        driver.get("https://asmr-fe.vpsdzaky.cloud");
    }

    @When("saya klik tombol {string}")
    public void saya_klik_tombol(String buttonName) {
        if (buttonName.equalsIgnoreCase("Registrasi")) {
            landingPage.clickRegister();
        }
    }

    @And("saya memasukkan data registrasi sebagai berikut:")
    public void saya_memasukkan_data_registrasi_sebagai_berikut(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().getFirst();
        registerPage.fillRegistrationForm(data);
    }

    @And("saya klik tombol daftar")
    public void saya_klik_tombol_daftar() {
        registerPage.clickRegister();
    }

    @Then("saya seharusnya melihat pesan registrasi berhasil")
    public void saya_seharusnya_melihat_pesan_registrasi_berhasil() {
        registerPage.verifyAndCloseSuccessDialog();
    }

    @When("saya login sebagai admin dengan email {string} dan password {string}")
    public void saya_login_sebagai_admin_dengan_email_dan_password(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("saya seharusnya berada di Halaman {string}")
    public void sayaSeharusnyaBeradaDiHalaman(String pageName) {
        Assert.assertTrue(dashboardAdminPage.isLogoDisplayed());
        Assert.assertEquals(pageName, dashboardAdminPage.getHeaderTitle());
    }

    @And("saya membuka halaman {string}")
    public void saya_membuka_halaman(String pageName) {
        dashboardAdminPage.goToApprovalPage();
        Assert.assertEquals(pageName, approvalRolePage.getHeaderTitle());
    }

    @Then("saya seharusnya melihat {string} di dalam daftar approval")
    public void saya_seharusnya_melihat_di_dalam_daftar_approval(String name) {
        Assert.assertTrue("User is not in approval list", approvalRolePage.isUserInApprovalList(name));
    }

    @Then("saya seharusnya melihat popup dengan pesan registrasi gagal")
    public void sayaSeharusnyaMelihatPopupDenganPesanRegistrasiGagal() {

    }

    @And("saya klik tombol tutup")
    public void sayaKlikTombolTutup() {

    }

    @Then("seharusnya terdapat pesan error dibawah input")
    public void seharusnyaTerdapatPesanErrorDibawahInput() {
    }
} 