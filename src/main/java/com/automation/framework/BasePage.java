package com.automation.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	WebDriver driver;
	Properties prop;

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	/**
	 * this method is used to initialize the driver on the basis of browser name
	 * 
	 * @param browser
	 * @return driver
	 */
	public WebDriver init_driver(Properties prop) {
		String browser = prop.getProperty("browser");

		if (browser.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
			
		} else if (browser.equals("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
//			WebDriverManager.getInstance(SafariDriver.class).setup();
			tldriver.set(new SafariDriver());
		} else {
			System.out.println("Please pass the correct browser name....");
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		return getDriver();
	}

	/**
	 * this method is used to initialize the properties from config.properties
	 * file...
	 * 
	 * @return prop
	 */
	public Properties init_properties() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/resources/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}
}
