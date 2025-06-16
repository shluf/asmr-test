package pageobjects.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BasePage;

import java.time.Duration;

public class RegisterPage extends BasePage {
    private final By title = By.xpath("/html/body/section/div[2]/div/h1");
    private final By Name  = By.xpath("//*[@id=\"nama\"]");
    private final By NIK = By.xpath("//*[@id=\"nik\"]");
    private final By NomerKK = By.xpath("//*[@id=\"nomer_kk\"]");
    private final By TempatLahir = By.id("tempat_lahir");
    private final By TanggalLahir = By.xpath("//*[@id=\"tanggal_lahir\"]");
    private final By JenisKelamin = By.xpath("/html/body/section/div[2]/div/form/div/div[1]/div[5]/select/option[1]");
    private final By Agama = By.xpath("/html/body/section/div[2]/div/form/div/div[1]/div[6]/select/option[1]");
    private final By Provinsi = By.xpath("/html/body/section/div[2]/div/form/div/div[1]/div[7]/select/option[15]");
    private  final By Kabupaten  = By.xpath("/html/body/section/div[2]/div/form/div/div[1]/div[8]/select/option[7]");
    private final By RW = By.xpath("/html/body/section/div[2]/div/form/div/div[1]/div[9]/div/div[1]/select/option[1]");
    private final By RT = By.xpath("/html/body/section/div[2]/div/form/div/div[1]/div[9]/div/div[2]/select/option[1]");
    private final By Phone = By.xpath("//*[@id=\"phone\"]");
    private final By Alamat = By.xpath("//*[@id=\"alamat\"]");
    private final By Email = By.xpath("//*[@id=\"email\"]");
    private final By Password = By.xpath("//*[@id=\"password\"]");
    private final By KonfirmasiPassword = By.xpath("//*[@id=\"password_confirmation\"]");
    private final By RegisterButton = By.xpath("/html/body/section/div[2]/div/form/div/div[3]/button");
    private final By PasswordMustBeAtLeast8char = By.xpath("//*[@id=\"radix-:r1r:\"]");



    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    public boolean isTitleDisplayed() {
        return driver.findElement(title).isDisplayed();
    }
    public String getActualUrl() {
        return driver.getCurrentUrl();
    }
    public void enterName(String name) {
        driver.findElement(Name).sendKeys(name);
    }
    public void enterNIK(String nik) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement nikInput = wait.until(ExpectedConditions.elementToBeClickable(NIK));
        nikInput.clear();
        nikInput.sendKeys(nik);
    }
    public void enterNomerKK(String nomerKK) {
        driver.findElement(NomerKK).sendKeys(nomerKK);
    }
    public void enterTempatLahir(String tempatLahir) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement tempatLahirInput = wait.until(ExpectedConditions.elementToBeClickable(TempatLahir));
        tempatLahirInput.clear();
        tempatLahirInput.sendKeys(tempatLahir);
    }
    public void enterTanggalLahir(String tanggalLahir) {
        driver.findElement(TanggalLahir).sendKeys(tanggalLahir);
    }
    public void selectJenisKelamin() {
        driver.findElement(JenisKelamin).click();
    }
    public void selectAgama() {
        driver.findElement(Agama).click();
    }
    public void selectProvinsi() {
        driver.findElement(Provinsi).click();
    }
    public void selectKabupaten() {
        driver.findElement(Kabupaten).click();
    }
    public void selectRW() {
        driver.findElement(RW).click();
    }
    public void selectRT() {
        driver.findElement(RT).click();
    }
    public void enterPhone(String phone) {
        driver.findElement(Phone).sendKeys(phone);
    }
    public void enterAlamat(String alamat) {
        driver.findElement(Alamat).sendKeys(alamat);
    }
    public void enterEmail(String email) {
        driver.findElement(Email).sendKeys(email);
    }
    public void enterPassword(String password) {
        driver.findElement(Password).sendKeys(password);
    }
    public void enterKonfirmasiPassword(String konfirmasiPassword) {
        driver.findElement(KonfirmasiPassword).sendKeys(konfirmasiPassword);
    }
    public void clickRegisterButton() {
        driver.findElement(RegisterButton).click();
    }
    public boolean isPasswordErrorDisplayed() {
        return driver.findElement(PasswordMustBeAtLeast8char).isDisplayed();
    }



}
