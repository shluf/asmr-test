package stepdefinitions;

import hooks.UseDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobjects.warga.DashboardWargaPage;
import pageobjects.warga.HistoriPengajuanPage;
import pageobjects.warga.PengajuanPage;

import java.util.Map;

public class PengajuanSuratSteps {
    private final WebDriver driver;
    private final DashboardWargaPage dashboardWargaPage;
    private final PengajuanPage pengajuanPage;
    private final HistoriPengajuanPage historiPengajuanPage;

    public PengajuanSuratSteps() {
        this.driver = UseDriver.getDriver();
        this.dashboardWargaPage = new DashboardWargaPage(driver);
        this.pengajuanPage = new PengajuanPage(driver);
        this.historiPengajuanPage = new HistoriPengajuanPage(driver);
    }

    @And("I am on the {string} sub menu")
    public void i_am_on_the_sub_menu(String subMenu) {
        if (subMenu.equalsIgnoreCase("Pengajuan")) {
            dashboardWargaPage.goToPengajuan();
        } else if (subMenu.equalsIgnoreCase("Histori Pengajuan")) {
            dashboardWargaPage.goToHistoriPengajuan();
        }
    }

    @When("I fill the letter submission form as follows:")
    public void i_fill_the_letter_submission_form_as_follows(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().getFirst();
        pengajuanPage.fillForm(data);
    }

    @Then("I should see a successful submission popup")
    public void i_should_see_a_successful_submission_popup() {
        Assert.assertTrue("Success popup is not visible.", pengajuanPage.isSuccessPopupVisible());
    }

    @And("the letter has been approved by RT and RW")
    public void the_letter_has_been_approved_by_RT_and_RW() {
        System.out.println("Precondition: Letter is approved by RT and RW.");
    }

    @When("I click the download icon for the approved letter")
    public void i_click_the_download_icon_for_the_approved_letter() {
        historiPengajuanPage.clickDownloadForApprovedLetter();
    }

    @Then("I successfully download the letter")
    public void i_successfully_download_the_letter() {
        historiPengajuanPage.verifyFileDownloaded();
    }

    @And("the letter is rejected by RT or RW")
    public void the_letter_is_rejected_by_RT_or_RW() {
        System.out.println("Precondition: Letter is rejected by RT or RW.");
    }

    @Then("the download button should not be available for the rejected letter")
    public void the_download_button_should_not_be_available_for_the_rejected_letter() {
        Assert.assertFalse("Download button is visible for a rejected letter.", historiPengajuanPage.isDownloadButtonVisibleForRejectedLetter());
    }
} 