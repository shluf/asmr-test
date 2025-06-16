package pageobjects.rtrw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import pageobjects.BasePage;

public class RtRwLayout extends BasePage {
    private final WebDriverWait wait;

    private final By logoImage = By.xpath("/html/body/div/div[1]/div/div[1]/a");
    private final String dashboardRtLink = "a[href='/%s']";
    private final String pengajuanMasalahLink = "a[href='/%s/pengajuan-masalah']";
    private final String rekapPengajuanLink = "a[href='/%s/rekap-pengajuan']";
    private final String pengajuanWargaLink = "a[href='/%s/pengajuan-warga']";
    private final String bantuanLink = "a[href='/%s/bantuan']";
    private final By userIcon = By.cssSelector("#radix-\\:r3b\\:");
    private final By logoutButton = By.xpath("//div[text()='Logout']");

    RtRwLayout (WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getActualUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isLogoDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoImage));
        return titleElement.isDisplayed();
    }

    public void goToDashboard(String role) {
        driver.findElement(By.cssSelector(String.format(dashboardRtLink, role.toLowerCase()))).click();
    }

    public void goToPengajuanMasalah(String role) {
        driver.findElement(By.cssSelector(String.format(pengajuanMasalahLink, role.toLowerCase()))).click();
    }

    public void goToRekapPengajuan(String role) {
        driver.findElement(By.cssSelector(String.format(rekapPengajuanLink, role.toLowerCase()))).click();
    }

    public void goToPengajuanWarga(String role) {
        driver.findElement(By.cssSelector(String.format(pengajuanWargaLink, role.toLowerCase()))).click();
    }

    public void goToBantuan(String role) {
        driver.findElement(By.cssSelector(String.format(bantuanLink, role.toLowerCase()))).click();
    }

    public void logout() {
        driver.findElement(userIcon).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}
