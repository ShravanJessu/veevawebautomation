//package com.derived.product1;
//
//import org.testng.annotations.Test;
//
//import java.util.List;
//import java.util.Properties;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.asserts.SoftAssert;
//
//import com.automation.framework.BasePage;
//
//public class DPTest1 {
//
//	WebDriver driver;
//	BasePage basePage;
//	Properties prop;
//	SoftAssert softAssert;
//	WebDriverWait wt;
//	static String DP_APP_URL = "https://www.nba.com/sixers/";
//
//	@Test
//	public void dpTest() {
//		driver.get(DP_APP_URL);
//
//		JavascriptExecutor j = (JavascriptExecutor) driver;
//		if (j.executeScript("return document.readyState").toString().equals("complete")) {
//			System.out.println("Page loaded properly.");
//		}
//
//		WebElement ticketsEle = driver
//				.findElement(By.xpath("//nav[@aria-label='header-primary-menu']/ul[@role='menubar']/li[1]"));
//		new Actions(driver).moveToElement(ticketsEle).perform();
//
//		List<WebElement> elements = driver
//				.findElements(By.xpath("//nav[@aria-label='header-primary-menu']//li[1]//nav[1]//ul[1]/li/a"));
//		System.out.println("Size of items " + elements.size());
//		for (int i = 0; i < elements.size(); i++) {
//			System.out.println("Titles - " + elements.get(i).getAttribute("title"));
//		}
//	}
//
//	@BeforeTest
//	public void beforeTest() {
//		basePage = new BasePage();
//		prop = basePage.init_properties();
//		driver = basePage.init_driver(prop);
//	}
//
//	@AfterTest
//	public void afterTest() {
////		driver.quit();
//	}
//}
//package com;


