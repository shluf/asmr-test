package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage extends BasePage {

    private final By loginButton = By.xpath("/html/body/main/nav/div/div[3]/a[2]");
    private final By registerButton = By.xpath("/html/body/main/nav/div/div[3]/a[1]");
    private final By heroImage = By.xpath("/html/body/main/div/section[1]/div[1]/img");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHeroImageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(heroImage));
        return titleElement.isDisplayed();
    }

    public String getActualUrl() {
        return driver.getCurrentUrl();
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }
}