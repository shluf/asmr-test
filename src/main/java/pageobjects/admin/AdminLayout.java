package pageobjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BasePage;

import java.time.Duration;

public class AdminLayout extends BasePage {
    private final By logoImage = By.xpath("/html/body/div/div[1]/div/div[1]/a");

    private final By dashboardLink = By.cssSelector("a[href='/admin']");
    private final By biodataUserLink = By.cssSelector("a[href='/admin/biodata-user']");
    private final By rekapPengajuanWargaLink = By.cssSelector("a[href='/admin/rekap-pengajuan']");
    private final By approvalRoleLink = By.cssSelector("a[href='/admin/approval-role']");
    private final By kelolaRTRWLink = By.cssSelector("a[href='/admin/kelola-rtrw']");

    public AdminLayout(WebDriver driver) {
        super(driver);
    }

    public String getActualUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isLogoDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoImage));
        return titleElement.isDisplayed();
    }

    public void goToApprovalPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(approvalRoleLink)).click();
    }

    public void goToDashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dashboardLink)).click();
    }

    public void goToBiodataUser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(biodataUserLink)).click();
    }

    public void goToRekapPengajuanWarga() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(rekapPengajuanWargaLink)).click();
    }

    public void goToApprovalRole() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(approvalRoleLink)).click();
    }

    public void goToKelolaRTRW() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(kelolaRTRWLink)).click();
    }
}
