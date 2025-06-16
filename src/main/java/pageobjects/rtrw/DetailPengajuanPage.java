package pageobjects.rtrw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetailPengajuanPage extends RtRwLayout {
    private final WebDriverWait wait;

    private final By setujuiButton = By.xpath("//button[text()='Setujui']");
    private final By tolakButton = By.xpath("//button[text()='Tolak']");

    public DetailPengajuanPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void approveSubmission() {
        wait.until(ExpectedConditions.elementToBeClickable(setujuiButton)).click();
    }

    public void rejectSubmission() {
        wait.until(ExpectedConditions.elementToBeClickable(tolakButton)).click();
    }
} 