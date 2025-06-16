package pageobjects.warga;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BasePage;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class PengajuanPage extends BasePage {
    private final WebDriverWait wait;
    private final Actions actions;

    private final By namaInput = By.name("nama_pemohon");
    private final By nikInput = By.name("nik_pemohon");
    private final By tempatTanggalLahirInput = By.name("tempat_tanggal_lahir_pemohon");
    private final By teleponInput = By.name("phone_pemohon");
    private final By alamatInput = By.name("alamat_pemohon");
    private final By jenisKelaminField = By.id("jenis_kelamin_pemohon");
    private final By agamaField = By.id("agama_pemohon");
    private final String jenisSuratLabel = "//span[normalize-space()='%s']/parent::label";
    private final By lainnyaRadioLabel = By.xpath("//span[normalize-space()='Lainnya :']/parent::label");
    private final By lainnyaTextarea = By.xpath("//textarea[@placeholder='Detail Pengajuan']");
    private final By ajukanButton = By.xpath("//button[text()='Ajukan']");
    private final By successPopup = By.id("alert-content");
    private final By closePopupButton = By.id("alert-close-button");

    public PengajuanPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void fillForm(Map<String, String> data) {
        if (data.containsKey("Name")) {
            driver.findElement(namaInput).sendKeys(data.get("Name"));
        }
        if (data.containsKey("NIK")) {
            driver.findElement(nikInput).sendKeys(data.get("NIK"));
        }
        if (data.containsKey("Gender")) {
            selectJenisKelamin(data.get("Gender"));
        }
        if (data.containsKey("Religion")) {
            selectAgama(data.get("Religion"));
        }
        if (data.containsKey("Place and Date of Birth")) {
            driver.findElement(tempatTanggalLahirInput).sendKeys(data.get("Place and Date of Birth"));
        }
        if (data.containsKey("Phone Number")) {
            driver.findElement(teleponInput).sendKeys(data.get("Phone Number"));
        }
        if (data.containsKey("Address")) {
            driver.findElement(alamatInput).clear();
            driver.findElement(alamatInput).sendKeys(data.get("Address"));
        }
        if (data.containsKey("Letter Type")) {
            selectJenisSurat(data.get("Letter Type"));
        }
    }

    public void selectJenisKelamin(String jenisKelamin) {
        attempt(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(jenisKelaminField)).click();
            By optionLocator = By.xpath(String.format("//div[@role='option' and normalize-space()='%s']", jenisKelamin));
            wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
        });
    }

    public void selectAgama(String agama) {
        attempt(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(agamaField)).click();
            By optionLocator = By.xpath(String.format("//div[@role='option' and normalize-space()='%s']", agama));
            wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
        });
    }

    public void selectJenisSurat(String jenisSurat) {
        attempt(() -> {
            By radioLabelLocator = By.xpath(String.format(jenisSuratLabel, jenisSurat));
            List<WebElement> elements = driver.findElements(radioLabelLocator);

            if (!elements.isEmpty()) {
                WebElement elementToClick = wait.until(ExpectedConditions.elementToBeClickable(radioLabelLocator));
                actions.moveToElement(elementToClick).click().perform();
            } else {
                WebElement lainnyaElement = wait.until(ExpectedConditions.elementToBeClickable(lainnyaRadioLabel));
                actions.moveToElement(lainnyaElement).click().perform();

                WebElement textarea = wait.until(ExpectedConditions.visibilityOfElementLocated(lainnyaTextarea));
                textarea.sendKeys(jenisSurat);
            }
        });
    }

    public void clickAjukan() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(ajukanButton));
        actions.moveToElement(button).click().perform();
    }

    public boolean isSuccessPopupVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successPopup)).isDisplayed();
    }

    public void clickClosePopupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(closePopupButton)).click();
    }
}