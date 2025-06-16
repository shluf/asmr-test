package pageobjects.rtrw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardRtRwPage extends RtRwLayout {

    private final By headerTitle = By.xpath("//h1[contains(text(), 'Dashboard')]");

    DashboardRtRwPage (WebDriver driver) {
        super(driver);
    }

    public String getHeaderTitle() {
        return driver.findElement(headerTitle).getText();
    }
}
