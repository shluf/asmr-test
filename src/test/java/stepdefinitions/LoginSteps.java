package stepdefinitions;

import hooks.UseDriver;
import pageobjects.LandingPage;
import pageobjects.admin.DashboardAdminPage;
import pageobjects.auth.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import type.Role;

public class LoginSteps {
    private final WebDriver driver;
    private final LoginPage loginPage;
    private final LandingPage landingPage;
    private final DashboardAdminPage dashboardAdminPage;

    public LoginSteps() {
        this.driver = UseDriver.getDriver();
        this.loginPage = new LoginPage(driver);
        this.landingPage = new LandingPage(driver);
        this.dashboardAdminPage = new DashboardAdminPage(driver);
    }

    @Given("User is on the landing page")
    public void user_is_on_the_landing_page() {
        driver.get("https://asmr-fe.vpsdzaky.cloud");
    }

    @When("User click login button")
    public void user_click_login_button() {
        if (landingPage.isHeroImageDisplayed()){
            landingPage.clickLogin();
        }
    }

    @Then("User should be redirected to the login page")
    public void user_should_be_redirected_to_the_login_page() {
        Assert.assertTrue("Title is not displayed.", loginPage.isTitleDisplayed());

        String expectedUrl = "https://asmr-fe.vpsdzaky.cloud/login";
        Assert.assertEquals(expectedUrl, loginPage.getActualUrl());
    }

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("https://asmr-fe.vpsdzaky.cloud/login");
    }

    @When("User submit valid credentials")
    public void user_submit_valid_credentials() {
        loginPage.loginAs(Role.ADMIN);
    }

    @Then("User should be redirected to the dashboard")
    public void user_should_be_redirected_to_the_dashboard() {
        Assert.assertTrue("Logo image is not displayed.", dashboardAdminPage.isLogoDisplayed());

        String expectedUrl = "https://asmr-fe.vpsdzaky.cloud/admin";
        Assert.assertEquals(expectedUrl, dashboardAdminPage.getActualUrl());
    }
}