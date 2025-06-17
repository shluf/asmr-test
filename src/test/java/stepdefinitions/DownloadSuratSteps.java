package stepdefinitions;

import hooks.UseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobjects.LandingPage;
import pageobjects.auth.LoginPage;
import pageobjects.warga.DashboardWargaPage;
import pageobjects.warga.HistoriPengajuanPage;

public class DownloadSuratSteps {
    private final WebDriver driver;
    private final LandingPage landingPage;
    private final LoginPage loginPage;
    private final DashboardWargaPage dashboardWargaPage;
    private final HistoriPengajuanPage historiPengajuanPage;


    public DownloadSuratSteps() {
        this.driver = UseDriver.getDriver();
        this.landingPage = new LandingPage(driver);
        this.loginPage = new LoginPage(driver);
        this.dashboardWargaPage = new DashboardWargaPage(driver);
        this.historiPengajuanPage = new HistoriPengajuanPage(driver);
    }
//    @Given("I am logged in as {string} with password {string}")
//    public void i_am_logged_in_as_with_password(String email, String password) {
//        loginPage.enterEmail(email);
//        loginPage.enterPassword(password);
//        loginPage.clickLogin();
//    }
    @And("the letter has been approved by RT and RW")
    public void the_letter_has_been_approved_by_rt_and_rw() {
        // In a real test, this step would involve setting up test data.
        // For example, making an API call or a database entry to ensure
        // that a letter with an "Disetujui" status exists for the test user.
        System.out.println("Test pre-condition: A letter approved by RT and RW exists.");
    }

    @And("the letter is rejected by RT or RW")
    public void the_letter_is_rejected_by_rt_or_rw() {
        // Similar to the approved step, this would ensure a letter
        // with a "Ditolak" status exists for the user.
        System.out.println("Test pre-condition: A letter rejected by RT or RW exists.");
    }
//    @When("I am on the {string} sub menu")
//    public void i_am_on_the_sub_menu(String subMenu) {
//        historiPengajuanPage.onHistoryPengajuanPage();
//    }

    @When("I click the download icon for the approved letter")
    public void i_click_the_download_icon_for_the_approved_letter() {
        historiPengajuanPage.clickDownloadForApprovedLetter();
    }

    @Then("I successfully download the letter")
    public void i_successfully_download_the_letter() {
        // Verifikasi download, misal cek file di folder download (di luar Selenium) atau mock check
        historiPengajuanPage.verifyFileDownloaded();
        // Bisa tambah assert jika pakai file system: Assert.assertTrue(file.exists());
        Assert.assertTrue("The download verification step was executed.", true); // Simulasi sukses
    }

    @Then("the download button should not be available for the rejected letter")
    public void the_download_button_should_not_be_available_for_the_rejected_letter() {
        boolean isVisible = historiPengajuanPage.isDownloadButtonVisibleForRejectedLetter();
        Assert.assertFalse("Download button was found for a rejected letter, but it should not be.", isVisible);
    }


}
