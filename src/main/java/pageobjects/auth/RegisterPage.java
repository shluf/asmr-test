package pageobjects.auth;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BasePage;

import java.time.Duration;
import java.util.Map;

public class RegisterPage extends BasePage {

    private final WebDriverWait wait;
    private final By title = By.xpath("//h1[text()='Register']");
    private final By namaField = By.id("nama");
    private final By nikField = By.id("nik");
    private final By noKKField = By.id("nomer_kk");
    private final By tempatLahirField = By.id("tempat_lahir");
    private final By tanggalLahirField = By.id("tanggal_lahir");
    private final By jenisKelaminField = By.id("jenis_kelamin");
    private final By agamaField = By.id("agama");
    private final By provinsiField = By.id("provinsi");
    private final By kabupatenField = By.id("kabupaten");
    private final By rwField = By.id("id_rw");
    private final By rtField = By.id("id_rt");
    private final By noTeleponField = By.id("phone");
    private final By alamatField = By.id("alamat");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By confirmPasswordField = By.id("password_confirmation");
    private final By registerButton = By.xpath("/html/body/section/div[2]/div/form/div/div[3]/button");
    private final By successMessage = By.xpath("//h2[text()='Berhasil']");
    private final By closeSuccessButton = By.xpath("//button[normalize-space()='Tutup']");
    private final By errorMessage = By.xpath("//h2[text()='Gagal']");


    public RegisterPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean isTitleDisplayed() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        
        String titleText = "";
        if (titleElement.isDisplayed()) {
            titleText = titleElement.getText();
        }
        return titleText.equals("Register");
    }

    public String getActualUrl() {
        return driver.getCurrentUrl();
    }

    public void enterNama(String nama) {
        attempt(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(namaField)).sendKeys(nama));
    }

    public void enterAlamat(String alamat) {
        attempt(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(alamatField)).sendKeys(alamat));
    }

    public void enterNik(String nik) {
        attempt(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(nikField)).sendKeys(nik));
    }

    public void enterNoKK(String noKK) {
        attempt(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(noKKField)).sendKeys(noKK));
    }

    public void enterTempatLahir(String tempatLahir) {
        attempt(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(tempatLahirField)).sendKeys(tempatLahir));
    }

    public void enterTanggalLahir(String tanggalLahir) {
        attempt(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(tanggalLahirField)).sendKeys(tanggalLahir));
    }

    public void selectJenisKelamin(String jenisKelamin) {
        attempt(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(jenisKelaminField)).click();
            By optionLocator = By.xpath(String.format("//div[@role='option'][normalize-space()='%s']", jenisKelamin));
            wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
        });
    }

    public void selectAgama(String agama) {
        attempt(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(agamaField)).click();
            By optionLocator = By.xpath(String.format("//div[@role='option'][normalize-space()='%s']", agama));
            wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
        });
    }

    public void selectProvinsi(String provinsi) {
        attempt(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(provinsiField)).click();
            By optionLocator = By.xpath(String.format("//div[@role='option'][normalize-space()='%s']", provinsi));
            wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
        });
    }

    public void selectKabupaten(String kabupaten) {
        attempt(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(kabupatenField)).click();
            By optionLocator = By.xpath(String.format("//div[@role='option'][normalize-space()='%s']", kabupaten));
            wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
        });
    }

    public void selectRw(String rw) {
        attempt(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(rwField)).click();
            By optionLocator = By.xpath(String.format("//div[@role='option'][normalize-space()='%s']", rw));
            wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
        });
    }

    public void selectRt(String rt) {
        attempt(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(rtField)).click();
            By optionLocator = By.xpath(String.format("//div[@role='option'][normalize-space()='%s']", rt));
            wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
        });
    }

    public void enterNoTelepon(String noTelepon) {
        attempt(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(noTeleponField)).sendKeys(noTelepon));
    }

    public void enterEmail(String email) {
        attempt(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email));
    }

    public void enterPassword(String password) {
        attempt(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password));
    }

    public void enterConfirmPassword(String confirmPassword) {
        attempt(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField)).sendKeys(confirmPassword));
    }

    public void clickRegister() {
        attempt(() -> {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(registerButton));
            // Scroll tombol ke tengah layar agar terlihat
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);
            // Tunggu sampai tombol benar-benar tidak tertutup elemen lain
            wait.until(ExpectedConditions.visibilityOf(button));
            wait.until(ExpectedConditions.elementToBeClickable(button));
            try {
                button.click();
            } catch (ElementClickInterceptedException e) {
                // Jika masih ketutup, fallback pakai JS click
                System.out.println("ElementClickInterceptedException terjadi. Coba klik dengan JS.");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
            }
        });
    }

    public void fillRegistrationForm(Map<String, String> data) {
        enterNama(data.get("Nama"));
        enterNik(data.get("NIK"));
        enterNoKK(data.get("No. KK"));
        enterTempatLahir(data.get("Tempat Lahir"));
        enterTanggalLahir(data.get("Tanggal Lahir").replaceAll("-", ""));
        selectJenisKelamin(data.get("Jenis Kelamin"));
        selectAgama(data.get("Agama"));
        selectProvinsi(data.get("Provinsi"));
        selectKabupaten(data.get("Kabupaten"));
        selectRw(data.get("RW"));
        selectRt(data.get("RT"));
        enterAlamat(data.get("Alamat"));
        enterNoTelepon(data.get("No. Telepon"));
        enterEmail(data.get("Email"));
        enterPassword(data.get("Password"));
        enterConfirmPassword(data.get("Password"));
    }

    public void verifyAndCloseSuccessDialog() {
        attempt(() -> {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            wait.until(ExpectedConditions.elementToBeClickable(closeSuccessButton)).click();
        });
    }
    public void verifyErrorMessage() {
        attempt(() -> {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            wait.until(ExpectedConditions.elementToBeClickable(closeSuccessButton)).click();
        });
    }
}
