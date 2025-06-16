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

    @Given("The user is on the landing page")
    public void saya_berada_di_landing_page() {
        driver.get("https://asmr-fe.vpsdzaky.cloud");
    }

    @When("The user clicks the button")
    public void saya_klik_tombol() {
        landingPage.clickRegister();
    }

    @And("I enter registration data as follows:")
    public void saya_memasukkan_data_registrasi_sebagai_berikut(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().getFirst();
        registerPage.fillRegistrationForm(data);
    }

    @And("I click the register button")
    public void saya_klik_tombol_daftar() {
        registerPage.clickRegister();
    }

    @Then("I should see a successful registration message")
    public void saya_seharusnya_melihat_pesan_registrasi_berhasil() {
        registerPage.verifyAndCloseSuccessDialog();
    }
    @Then("I should see a popup with a failed registration message")
    public void saya_seharusnya_melihat_popup_dengan_pesan_registrasi_gagal() {
        registerPage.verifyErrorMessage();
    }

} 