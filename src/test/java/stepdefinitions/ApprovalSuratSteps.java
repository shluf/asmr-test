package stepdefinitions;

import hooks.UseDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobjects.rtrw.PengajuanWargaPage;
import pageobjects.warga.HistoriPengajuanPage;

import java.util.Map;

public class ApprovalSuratSteps {

    private final WebDriver driver;
    private final HistoriPengajuanPage historiPengajuanPage;
    private final PengajuanWargaPage pengajuanWargaPage;

    public ApprovalSuratSteps() {
        this.driver = UseDriver.getDriver();
        this.historiPengajuanPage = new HistoriPengajuanPage(driver);
        this.pengajuanWargaPage = new PengajuanWargaPage(driver);
    }

    @Given("a letter has been submitted by a citizen:")
    public void a_letter_has_been_submitted_by_a_citizen(DataTable data) {
        Map<String, String> dataSurat = data.asMap(String.class, String.class);
        Assert.assertTrue(pengajuanWargaPage.checkSubmission(dataSurat.get("Name")));
    }

    @And("I click the {string} button on the letter")
    public void i_click_the_button_on_the_letter(String buttonName) {
        switch (buttonName) {
            case "Setujui":
                pengajuanWargaPage.approveSubmission();
                break;
            case "Tolak":
                pengajuanWargaPage.rejectSubmission();
                break;
            default:
                throw new IllegalArgumentException("Invalid button name: " + buttonName);
        }
    }

    @Then("the letter status should be {string}")
    public void the_letter_status_should_be(String expectedStatus) {
        String actualStatus = historiPengajuanPage.getLatestSubmissionStatus();
        Assert.assertEquals("The submission status is not correct.", expectedStatus, actualStatus);
    }

    @And("I view the details of the latest letter")
    public void i_view_the_details_of_the_latest_letter() {
        historiPengajuanPage.viewLatestSubmissionDetail();
    }

    @And("the letter has been approved by RT:")
    public void the_letter_has_been_approved_by_RT(DataTable dataTable) {
        Map<String, String> dataSurat = dataTable.asMap(String.class, String.class);
        pengajuanWargaPage.checkSubmission(dataSurat.get("Name"));
    }


    @Then("I should see a successful approval popup")
    public void i_should_see_a_successful_approval_popup() {
        Assert.assertEquals("Berhasil!", pengajuanWargaPage.getPopupContent());
    }

    @And("I click the close button on the successful approval popup")
    public void i_click_the_close_button_on_the_successful_approval_popup() {
        pengajuanWargaPage.clickClosePopupButton();
    }

    @Then("Publish button should be visible")
    public void publish_button_should_be_visible() {
        Assert.assertTrue(pengajuanWargaPage.isPublishButtonVisible());
    }

    @And("I click the publish button")
    public void i_click_the_publish_button() {
        pengajuanWargaPage.clickPublishButton();
    }
}