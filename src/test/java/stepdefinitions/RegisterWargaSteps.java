package stepdefinitions;

import hooks.UseDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobjects.admin.ApprovalRolePage;
import pageobjects.admin.DashboardAdminPage;
import pageobjects.auth.RegisterPage;

import java.util.Map;

public class RegisterWargaSteps {
    private final WebDriver driver;
    private final DashboardAdminPage dashboardAdminPage;
    private final ApprovalRolePage approvalRolePage;
    private final RegisterPage registerPage;

    public RegisterWargaSteps() {
        this.driver = UseDriver.getDriver();
        this.approvalRolePage = new ApprovalRolePage(driver);
        this.dashboardAdminPage = new DashboardAdminPage(driver);
        this.registerPage = new RegisterPage(driver);
    }

    @Then("I enter the following registration data:")
    public void i_enter_the_following_registration_data(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().getFirst();
        registerPage.fillRegistrationForm(data);
    }

    @Then("I should see a successful registration message")
    public void i_should_see_a_successful_registration_message() {
        registerPage.verifyAndCloseSuccessDialog();
    }

    @Then("I should be on the {string} page")
    public void i_should_be_on_the_page(String pageName) {
        Assert.assertTrue(dashboardAdminPage.isLogoDisplayed());
        Assert.assertEquals(pageName, dashboardAdminPage.getHeaderTitle());
    }

    @Then("I should see {string} in the approval list")
    public void i_should_see_in_the_approval_list(String name) {
        Assert.assertTrue("User is not in approval list", approvalRolePage.isUserInApprovalList(name));
    }

    @Then("I should see a registration failed popup message")
    public void i_should_see_a_registration_failed_popup_message() {
        // Implementation for failed registration popup
    }

    @And("I click the close button")
    public void i_click_the_close_button() {
        // Implementation for clicking close button on popup
    }

    @Then("an error message should be displayed below the input")
    public void an_error_message_should_be_displayed_below_the_input() {
        // Implementation for verifying error message
    }
} 