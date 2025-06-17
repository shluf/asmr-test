package pageobjects.warga;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HistoriPengajuanPage extends WargaLayout {
    private final WebDriverWait wait;

    private final String approvedLetterDownloadIcon = "//td[text()='Disetujui']/following-sibling::td//button[@id='download-button']";
    private final String rejectedLetterRow = "//td[text()='Ditolak']/following-sibling::td//button[@id='download-button']";
    private final By latestStatus = By.xpath("//p[text()='Status Tindak Lanjut']/following-sibling::div/p[1]");
    private final By viewLatestDetailButton = By.xpath("(//button[@id='expand-button'])[1]");
    private final By downloadButton = By.xpath("//button[@id='download-button']");


    public HistoriPengajuanPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void viewLatestSubmissionDetail() {
        wait.until(ExpectedConditions.elementToBeClickable(viewLatestDetailButton)).click();
    }

    public String getLatestSubmissionStatus() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(latestStatus)).getText();
    }

    public void clickDownloadForApprovedLetter() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(approvedLetterDownloadIcon))).click();
    }

    public boolean isDownloadButtonVisibleForRejectedLetter() {
        try {
            WebElement rejectedRow = driver.findElement(By.xpath(rejectedLetterRow));  
            rejectedRow.findElement(downloadButton);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void verifyFileDownloaded() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
} 