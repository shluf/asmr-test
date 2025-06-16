package pageobjects.rtrw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PengajuanWargaPage extends RtRwLayout {
    private final WebDriverWait wait;

    private final By lihatSelengkapnyaButton = By.xpath("(//button[text()='Lihat Selengkapnya'])[1]");

    public PengajuanWargaPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void viewLatestSubmission() {
        wait.until(ExpectedConditions.elementToBeClickable(lihatSelengkapnyaButton)).click();
    }
} 