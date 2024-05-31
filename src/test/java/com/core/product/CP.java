//package com.core.product;
//
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import com.automation.framework.BasePage;
//
//import org.testng.annotations.BeforeTest;
//
//import java.time.Duration;
//import java.util.Properties;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterTest;
//
//public class CPTests {
//
//	WebDriver driver;
//	BasePage basePage;
//	Properties prop;
//	SoftAssert softAssert;
//	WebDriverWait wt;
//	static String CP_APP_URL = "https://www.nba.com/warriors";
//
//	@Test
//	public void sampleTest() throws InterruptedException {
//		driver.get(CP_APP_URL);
//		  
//		if (driver.findElement(By.xpath("/html/body/div[4]/div[1]/div")).isDisplayed()) {
//			driver.findElement(By.xpath("/html/body/div[4]/div[1]/div")).click();
//		}
//		JavascriptExecutor j = (JavascriptExecutor) driver;
//		if (j.executeScript("return document.readyState").toString().equals("complete")) {
//			System.out.println("Page loaded properly.");
//		}
//		WebElement shopEle = driver.findElement(By.xpath("(//span[contains(text(),'Shop')])[1]"));
//
//		try {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].click();", shopEle);
//		} catch (Exception e) {
//			System.out.println("Element not located");
//		}
//
//		
//		if (driver.findElement(By.xpath("//button[@class='button large modal-close-button unstyled']")).isDisplayed()) {
//			driver.findElement(By.xpath("//button[@class='button large modal-close-button unstyled']")).click();
//		}
//		
//		
//		
//		int sizeOfList = driver.findElements(By.xpath("//nav[@class='top-nav-light-container hover']//li")).size();
//		System.out.println(sizeOfList);
//		
//		WebElement mensEle = driver.findElement(By.xpath("//nav[@class='top-nav-light-container hover']//a[@id='0']"));
////		driver.findElement(By.xpath("//a[@id='0']")).click();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", mensEle);
////		driver.findElement(By.xpath("//li[@role='menuitem']//li[@role='menuitem']//a[@title=\"Men's\"]")).click();
//		System.out.println(driver.getTitle());
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
//
//}
//package com;


