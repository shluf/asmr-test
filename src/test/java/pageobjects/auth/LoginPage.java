package pageobjects.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BasePage;
import type.Role;

import java.time.Duration;
import java.util.List;

public class LoginPage extends BasePage {

    private final By title = By.xpath("/html/body/section/div[2]/div/h1");
    private final By emailField = By.id("login");
    private final By passwordField = By.id("password");
    private final By forgotPasswordButton = By.xpath("/html/body/section/div[2]/div/form/div[4]/a");
    private final By loginButton = By.xpath("/html/body/section/div[2]/div/form/div[4]/button");

    private final List<String> emails = List.of(
            "admin.utama@example.com",
            "budi.rt@example.com",
            "citra.rw1@example.com",
            "warga.andi@example.com"
    );

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return titleElement.isDisplayed();
    }

    public String getActualUrl() {
        return driver.getCurrentUrl();
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickForgotPassword() {
        driver.findElement(forgotPasswordButton).click();
    }

    public void loginAs(Role role) {
        String emailToUse = switch (role) {
            case ADMIN -> emails.get(0);
            case RT -> emails.get(1);
            case RW -> emails.get(2);
            case WARGA -> emails.get(3);
        };

        enterEmail(emailToUse);
        enterPassword("password");
        clickLogin();
    }
}