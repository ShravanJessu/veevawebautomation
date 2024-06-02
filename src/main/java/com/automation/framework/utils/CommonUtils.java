package com.automation.framework.utils;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CommonUtils(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	public WebElement getElement(By locator) {
		waitForElementPresent(locator);
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("some exception got occurred while creating the webelement : " + locator);
			System.out.println(e.getMessage());
		}
		return element;
	}
	
	public void clickOnElement(WebElement element) {
		try {
			if (element.isDisplayed()) {
				element.click();
			}	
		} catch (Exception e) {
			System.out.println("some exception got occurred while clicking on the webelement : " + element);
			System.out.println(e.getMessage());
		}
			
	}
	
	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception got occurred while clicking on the webelement : " + locator);
			System.out.println(e.getMessage());

		}
	}

	public void doActionsClick(By locator) {
		try {
			Actions action = new Actions(driver);
			action.click(getElement(locator)).build().perform();
		} catch (Exception e) {
			System.out.println("some exception got occurred while clicking on the webelement : " + locator);
			System.out.println(e.getMessage());

		}
	}

	public void doSendKeys(By locator, String... value) {
		try {
			getElement(locator).clear();
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception got occurred while sending the text to the webelement : " + locator);
			System.out.println(e.getMessage());

		}
	}

	public void doActionsSendKeys(By locator, String... value) {
		try {
			Actions action = new Actions(driver);
			action.sendKeys(getElement(locator), value).build().perform();
		} catch (Exception e) {
			System.out.println("some exception got occurred while passing the values to the webelement : " + locator);
			System.out.println(e.getMessage());
		}
	}

	public String doGetText(By locator) {
		String text = null;
		try {
			text = getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("some exception got occurred while getting the test from webelement : " + locator);
			System.out.println(e.getMessage());
		}
		return text;
	}

	public boolean doIsDisplayed(By locator) {
		
		boolean flag = false;
		try {
			flag = getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out
					.println("some exception got occurred while checking isDisplayed for the webelement : " + locator);
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public String doGetTitle() {
		String title = null;
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			System.out.println("some exception got occurred while getting the title of the page");
			System.out.println(e.getMessage());
		}
		return title;
	}

	public void doActionsMoveToElement(By locator) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(getElement(locator)).build().perform();
		} catch (Exception e) {
			System.out.println("some exception got occurred while moving on the webelement : " + locator);
			System.out.println(e.getMessage());
		}
	}

	public void waitForPageUrl(String url) {
		wait.until(ExpectedConditions.urlToBe(url));
	}

	public void waitForPageTitle(String title) {
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void waitForElementPresent(By locator){
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void switchToChildWindow() {
		Log4j2Util.info("Performing Switching to Child Window Tab..");
		String originalWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		Log4j2Util.info("Parent Window Tab Id: "+ originalWindow);
		Log4j2Util.info("Available Window Tab Ids: "+allWindows);
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				Log4j2Util.info("Successfully Switched to Child Window Tab..");
				break;
			}
		}		
	}

	public boolean isPageLoadComplete() {
		boolean flag = false;
		if (((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete")) {
			flag = true;
			return flag;
		} else {
			return flag;
		}
	}

	public void moveToElement(WebElement element) {
		new Actions(driver).moveToElement(element).perform();		
	}

	public void jseClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void jseScroll(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void navigateToApp(String appUrl) {
		driver.get(appUrl);
	}
}
