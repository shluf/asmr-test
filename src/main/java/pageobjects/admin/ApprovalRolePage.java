package pageobjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApprovalRolePage extends AdminLayout {
    private final By headerTitle = By.xpath("//h1[contains(text(), 'Approval Role')]");

    public ApprovalRolePage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderTitle() {
        return driver.findElement(headerTitle).getText();
    }

    public boolean isUserInApprovalList(String name) {
        By userInList = By.xpath("//td[text()='" + name + "']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userInList)).isDisplayed();
    }
}
