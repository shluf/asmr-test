package pageobjects.admin;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BasePage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class DashboardAdminPage extends BasePage {

    private final By logoImage = By.xpath("/html/body/div/div[1]/div/div[1]/a");
    private final By kelolaRTRWButton = By.xpath("//a[contains(@href, '/admin/kelola-rtrw') and contains(text(),'Kelola RT/RW')]");

    public DashboardAdminPage(WebDriver driver) {
        super(driver);
    }

    public String getActualUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isLogoDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated( logoImage));
        return titleElement.isDisplayed();
    }
    public void KelolaRTRW() {
        WebElement kelolaRTRWButton = driver.findElement(this.kelolaRTRWButton);
        kelolaRTRWButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/kelola-rtrw"));
    }

}
