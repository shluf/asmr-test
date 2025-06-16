package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Duration;

public class UseDriver {
    private static WebDriver driver;

    @Before
    public void setup() {
        if (driver == null) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    @After(order = 1)
    public void takeScreenshot(Scenario scenario) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss").format(new Date());
            String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
            String status = scenario.isFailed() ? "FAILED" : "PASSED";
            String fileName = String.format("%s__%s__%s.jpg", scenarioName, status, timestamp);

            Path destinationDirectory = new File("target/screenshots").toPath();
            Files.createDirectories(destinationDirectory);

            Path destinationPath = destinationDirectory.resolve(fileName);
            Files.copy(screenshot.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

            final byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/jpeg", scenario.getName());
        } catch (IOException e) {
            PrintStream stream = System.err;
            e.printStackTrace(stream);
        }
    }

    @After(order = 0)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}