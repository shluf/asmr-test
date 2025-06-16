package stepdefinitions;

import hooks.UseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobjects.warga.HistoriPengajuanPage;

public class ApprovalSuratSteps {

    private final WebDriver driver;
    private final HistoriPengajuanPage historiPengajuanPage;

    public ApprovalSuratSteps() {
        this.driver = UseDriver.getDriver();
        this.historiPengajuanPage = new HistoriPengajuanPage(driver);
    }

    @Given("a letter has been submitted by a citizen")
    public void a_letter_has_been_submitted_by_a_citizen() {
        System.out.println("Precondition: A letter has been submitted by a citizen.");
    }

    @Then("the letter status should be {string}")
    public void the_letter_status_should_be(String expectedStatus) {
        String actualStatus = historiPengajuanPage.getLatestSubmissionStatus();
        Assert.assertEquals("The submission status is not correct.", expectedStatus, actualStatus);
    }

    @And("I view the details of the latest letter")
    public void iViewTheDetailsOfTheLatestLetter() {
    }

    @And("the letter has been approved by RT")
    public void the_letter_has_been_approved_by_RT() {
        // Placeholder for precondition.
        System.out.println("Precondition: Letter has been approved by RT.");
    }

}