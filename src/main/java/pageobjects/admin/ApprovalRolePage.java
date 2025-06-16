package pageobjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApprovalRolePage extends AdminLayout {
    private final WebDriverWait wait;
    private final By headerTitle = By.xpath("//h1[contains(text(), 'Approval Role')]");
    private final By ButtonApprove = By.xpath("//button[normalize-space()='Setujui']");
    private final By ButtonReject = By.xpath("//button[contains(text(), 'Tolak')]");
    private final By SuccessMassage = By.xpath("(//h2[normalize-space()='Berhasil!'])");
    private final By CloseSuccessButton = By.xpath("(//button[normalize-space()='Tutup'])");


    public ApprovalRolePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public boolean isTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(headerTitle)).isDisplayed();
    }

    public String getHeaderTitle() {
        return driver.findElement(headerTitle).getText();
    }

    public boolean isUserInApprovalList(String name) {
        By userInList = By.xpath("//td[text()='" + name + "']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userInList)).isDisplayed();
    }
    public void clickApproveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ButtonApprove)).click();
    }
    public void clickRejectButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ButtonReject)).click();
    }
    public void getAlertSuccessMessage() {
        attempt(() -> {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessMassage));
            wait.until(ExpectedConditions.elementToBeClickable(CloseSuccessButton)).click();
        });
    }

}
