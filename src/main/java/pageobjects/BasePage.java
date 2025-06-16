package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.StaleElementReferenceException;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void attempt(Runnable action) {
        int attempts = 0;
        while(attempts < 3) {
            try {
                action.run();
                return;
            } catch (StaleElementReferenceException _) { }

            attempts++;
        }
    }
}