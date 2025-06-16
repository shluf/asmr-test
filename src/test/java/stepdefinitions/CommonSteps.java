package stepdefinitions;

import hooks.UseDriver;
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
import pageobjects.rtrw.DashboardRtRwPage;
import pageobjects.rtrw.DetailPengajuanPage;
import pageobjects.warga.DashboardWargaPage;
import pageobjects.warga.PengajuanPage;
import pageobjects.rtrw.PengajuanWargaPage;

public class CommonSteps {

    private final WebDriver driver;
    private final LoginPage loginPage;
    private final LandingPage landingPage;
    private final RegisterPage registerPage;
    private final DashboardAdminPage dashboardAdminPage;
    private final ApprovalRolePage approvalRolePage;
    private final DashboardRtRwPage dashboardRtRwPage;
    private final DetailPengajuanPage detailPengajuanPage;
    private final PengajuanPage pengajuanPage;
    private final DashboardWargaPage dashboardWargaPage;
    private final PengajuanWargaPage pengajuanWargaPage;


    public CommonSteps() {
        this.driver = UseDriver.getDriver();
        this.loginPage = new LoginPage(driver);
        this.landingPage = new LandingPage(driver);
        this.registerPage = new RegisterPage(driver);
        this.dashboardAdminPage = new DashboardAdminPage(driver);
        this.approvalRolePage = new ApprovalRolePage(driver);
        this.dashboardRtRwPage = new DashboardRtRwPage(driver);
        this.detailPengajuanPage = new DetailPengajuanPage(driver);
        this.pengajuanPage = new PengajuanPage(driver);
        this.dashboardWargaPage = new DashboardWargaPage(driver);
        this.pengajuanWargaPage = new PengajuanWargaPage(driver);
    }

    @Given("I am on the landing page")
    public void i_am_on_the_landing_page() {
        driver.get("https://asmr-fe.vpsdzaky.cloud");
    }

    @Given("I am logged in as {string} with password {string}")
    public void i_am_logged_in_as_with_password(String email, String password) {
        driver.get("https://asmr-fe.vpsdzaky.cloud/login");
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @When("I log in as an admin with email {string} and password {string}")
    public void i_log_in_as_an_admin_with_email_and_password(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }
    
    @Then("I log in as {string} with password {string}")
    public void i_log_in_as_with_password(String email, String password) {
        driver.get("https://asmr-fe.vpsdzaky.cloud/login");
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @When("I as {string} open the {string} page")
    public void i_open_the_page(String role, String pageName) {
        if (pageName.equalsIgnoreCase("Pengajuan Warga")) {
            if (role.equalsIgnoreCase("RW")) {
                dashboardRtRwPage.goToPengajuanWarga("rw");
            } else {
                dashboardRtRwPage.goToPengajuanWarga("rt");
            }
        } else if (pageName.equalsIgnoreCase("Histori Pengajuan")) {
            dashboardWargaPage.goToHistoriPengajuan();
        } else if (pageName.equalsIgnoreCase("Approval Role")) {
            dashboardAdminPage.goToApprovalPage();
            Assert.assertEquals(pageName, approvalRolePage.getHeaderTitle());
        }
    }

    @And("I view and open the details of the latest letter")
    public void i_view_and_open_the_details_of_the_latest_letter() {
        pengajuanWargaPage.viewLatestSubmission();
    }

    @And("I click the {string} button")
    public void i_click_the_button(String buttonName) {
        if (buttonName.equalsIgnoreCase("Setujui")) {
            detailPengajuanPage.approveSubmission();
        } else if (buttonName.equalsIgnoreCase("Tolak")) {
            detailPengajuanPage.rejectSubmission();
        } else if (buttonName.equalsIgnoreCase("Ajukan")) {
            pengajuanPage.clickAjukan();
        } else if (buttonName.equalsIgnoreCase("Registrasi")) {
            landingPage.clickRegister();
        }
    }

    @And("I click the register button")
    public void i_click_the_register_button() {
        registerPage.clickRegister();
    }

    @And("I logout")
    public void i_logout() {
        dashboardRtRwPage.logout();
    }
} 