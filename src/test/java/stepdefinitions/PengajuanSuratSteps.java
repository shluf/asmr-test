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

} 