package pageobjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApprovalRolePage extends AdminLayout {
    private final WebDriverWait wait;
    private final By headerTitle = By.xpath("//h1[contains(text(), 'Approval Role')]");
    private final By SuccessMassage = By.xpath("//*[@id=\"alert-title\"]");
    private final By CloseSuccessButton = By.xpath("//*[@id=\"alert-close-button\"]");

    public ApprovalRolePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
    public void clickApproveButton(String name) {
        By buttonApprove = By.xpath("//td[text()='" + name + "']/..//button[@id='approve-button']");
        wait.until(ExpectedConditions.elementToBeClickable(buttonApprove)).click();
    }
    public void clickRejectButton(String name) {
        By buttonReject = By.xpath("//td[text()='" + name + "']/..//button[@id='reject-button']");
        wait.until(ExpectedConditions.elementToBeClickable(buttonReject)).click();
    }
    public void getAlertSuccessMessage() {
        attempt(() -> {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessMassage));
            wait.until(ExpectedConditions.elementToBeClickable(CloseSuccessButton)).click();
        });
    }

}
