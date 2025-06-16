package pageobjects.warga;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PengajuanSuratPage extends WargaLayout {

    private final By headerTitle = By.xpath("//h1[contains(text(), 'Pengajuan Surat')]");

    PengajuanSuratPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderTitle() {
        return driver.findElement(headerTitle).getText();
    }
}
