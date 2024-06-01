package com.automation.framework.common;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.automation.framework.utils.Log4j2Util;

public class Hooks {
    private static WebDriver driver;

    @Before
    public void setUp() {
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
		} catch (Exception e) {
			Log4j2Util.error("Failed to initialize WebDriver", e);
			throw e;
		}
        
        
    }

    @After
    public void tearDown() {
    	Log4j2Util.info("Terminating the driver instance.");
        if (driver != null) {
            driver.quit();
            Log4j2Util.info("Driver Instance terminated Successfully.");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}