package common;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.framework.utils.Log4j2Util;

public class Hooks {
    private static WebDriver driver;
       
    @Before
    public void setUp() {
    	Log4j2Util.info("Initializing the driver instance.");
        String browser = System.getProperty("browser", "chrome"); // default to chrome if not specified
        try {
			switch (browser.toLowerCase()) {
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "msedge":
				driver = new EdgeDriver();
				break;
			case "safari":
				driver = new SafariDriver();
				break;
			case "chrome":
			default:
				driver = new ChromeDriver();
				break;
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Log4j2Util.info(browser.toUpperCase()+" Driver Instance Initialization Completed Sucessfully.");
		} catch (Exception e) {
			Log4j2Util.error("Failed to initialize WebDriver", e);
			throw e;
		}
        
    }

    @After
    public void tearDown(Scenario scenario) {
    	Log4j2Util.info("Terminating the driver instance.");
    	File textFile = new File(System.getProperty("user.dir")+"/src/test/resources/data/cp_product.txt");
        if (textFile.exists()) {
            try {
                byte[] fileContent = Files.readAllBytes(textFile.toPath());
                scenario.attach(fileContent, "text/plain", "cp_product.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (driver != null) {
            driver.quit();
            Log4j2Util.info("Driver Instance terminated Successfully.");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
