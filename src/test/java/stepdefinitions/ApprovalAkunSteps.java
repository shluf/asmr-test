package stepdefinitions;

import hooks.UseDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobjects.LandingPage;
import pageobjects.admin.ApprovalRolePage;
import pageobjects.admin.DashboardAdminPage;
import pageobjects.auth.LoginPage;
import pageobjects.auth.RegisterPage;

public class ApprovalAkunSteps {
    private final WebDriver driver;
    private final LandingPage landingPage;
    private final DashboardAdminPage dashboardAdminPage;
    private final ApprovalRolePage approvalRolePage;


    public ApprovalAkunSteps() {
        this.driver = UseDriver.getDriver();
        this.landingPage = new LandingPage(driver);
        this.dashboardAdminPage = new DashboardAdminPage(driver);
        this.approvalRolePage = new ApprovalRolePage(driver);
    }
    @Given("User is on the Dashboard Admin page as Admin")
    public void user_is_on_the_dashboard_admin_page_as_admin() {
        driver.get("https://asmr-fe.vpsdzaky.cloud/admin");
    }

    @Given("User clicks on the Approval Akun menu")
    public void user_clicks_on_the_approval_akun_menu() {
        dashboardAdminPage.goToApprovalRole();
    }
    @Given("User is on the Approval Akun page")
    public void user_is_on_the_approval_akun_page() {
        driver.get( "https://asmr-fe.vpsdzaky.cloud/admin/approval-role");
    }
    @Given("User clicks on the Approve button  with name {string}")
    public void user_clicks_on_the_approve_button_with_name(String name) {
        approvalRolePage.clickApproveButton(name);
    }
    @Then("User should see a success message")
    public void user_should_see_a_success_message() {
       approvalRolePage.getAlertSuccessMessage();
    }



}
