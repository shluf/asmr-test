package pageobjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardAdminPage extends AdminLayout {

    private final By headerTitle = By.xpath("//h1[contains(text(), 'Dashboard Admin')]");

    public DashboardAdminPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderTitle() {
        return driver.findElement(headerTitle).getText();
    }
}
