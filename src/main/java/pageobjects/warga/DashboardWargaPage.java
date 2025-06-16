package pageobjects.warga;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardWargaPage extends WargaLayout {

    private final By headerTitle = By.xpath("//h1[contains(text(), 'Dashboard')]");

    DashboardWargaPage (WebDriver driver) {
        super(driver);
    }

    public String getHeaderTitle() {
        return driver.findElement(headerTitle).getText();
    }
}
