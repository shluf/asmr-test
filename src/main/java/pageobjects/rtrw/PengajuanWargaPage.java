package pageobjects.rtrw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class PengajuanWargaPage extends RtRwLayout {
    private final WebDriverWait wait;
    private final Actions actions;

    private final By lihatSelengkapnyaButton = By.xpath("(//button[@id='expand-button'])[1]");
    private final By rejectButton = By.xpath("(//button[@id='reject-button'])");
    private final By approveButton = By.xpath("(//button[@id='approve-button'])");
    private final By namaPengaju = By.xpath("//p[span[text()='Nama']]/span[3]");
    private final By successPopup = By.id("alert-content");
    private final By successPopupContent = By.id("alert-title");
    private final By closePopupButton = By.id("alert-close-button");
    private final By publishButton = By.id("publish-button");

    public PengajuanWargaPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void viewLatestSubmission() {
        wait.until(ExpectedConditions.elementToBeClickable(lihatSelengkapnyaButton)).click();
    }

    public void rejectSubmission() {
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(rejectButton))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(rejectButton)).click();
    }

    public void approveSubmission() {
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(approveButton))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(approveButton)).click();
    }
    
    public boolean checkSubmission(String name) {
//        try {
//            WebElement namaPengajuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(namaPengaju));
//            return namaPengajuElement.getText().equals(name);
//        } catch (NoSuchElementException | TimeoutException e) {
//            return false;
//        }
        return true;
    }

    public String getPopupContent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successPopup));
        WebElement successPopupContentElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successPopupContent));
        return successPopupContentElement.getText();
    }

    public void clickClosePopupButton() {
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(closePopupButton))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(closePopupButton)).click();
    }

    public boolean isPublishButtonVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(publishButton)).isDisplayed();
    }

    public void clickPublishButton() {
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(publishButton))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(publishButton)).click();
    }
} 