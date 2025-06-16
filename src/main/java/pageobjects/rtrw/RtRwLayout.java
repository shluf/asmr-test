package pageobjects.rtrw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import pageobjects.BasePage;

public class RtRwLayout extends BasePage {

    private final By logoImage = By.xpath("/html/body/div/div[1]/div/div[1]/a");
    private final By dashboardRtLink = By.cssSelector("a[href='/rt']");
    private final By dashboardRwLink = By.cssSelector("a[href='/rw']");
    private final By pengajuanMasalahLink = By.cssSelector("a[href='/rt/pengajuan-masalah']");
    private final By rekapPengajuanLink = By.cssSelector("a[href='/rt/rekap-pengajuan']");
    private final By bantuanLink = By.cssSelector("a[href='/rt/bantuan']");

    RtRwLayout (WebDriver driver) {
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

    public void goToDashboardRt() {
        driver.findElement(dashboardRtLink).click();
    }

    public void goToDashboardRw() {
        driver.findElement(dashboardRwLink).click();
    }

    public void goToPengajuanMasalah() {
        driver.findElement(pengajuanMasalahLink).click();
    }

    public void goToRekapPengajuan() {
        driver.findElement(rekapPengajuanLink).click();
    }

    public void goToBantuan() {
        driver.findElement(bantuanLink).click();
    }
}
