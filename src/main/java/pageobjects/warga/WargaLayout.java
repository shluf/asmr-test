package pageobjects.warga;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import pageobjects.BasePage;

public class WargaLayout extends BasePage {

    private final By logoImage = By.xpath("/html/body/div/div[1]/div/div[1]/a");
    private final By dashboardLink = By.cssSelector("a[href='/warga']");
    private final By pengajuanLink = By.cssSelector("a[href='/warga/pengajuan']");
    private final By historiPengajuanLink = By.cssSelector("a[href='/warga/histori-pengajuan']");
    private final By akunLink = By.cssSelector("a[href='/warga/akun']");
    private final By bantuanLink = By.cssSelector("a[href='/warga/bantuan']");

    public WargaLayout(WebDriver driver) {
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
    
    public void goToPengajuan() {
        driver.findElement(pengajuanLink).click();
    }

    public void goToHistoriPengajuan() {
        driver.findElement(historiPengajuanLink).click();
    }

    public void goToAkun() {
        driver.findElement(akunLink).click();
    }

    public void goToBantuan() {
        driver.findElement(bantuanLink).click();
    }
}
