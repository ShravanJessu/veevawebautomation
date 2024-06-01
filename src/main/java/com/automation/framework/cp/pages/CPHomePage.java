package com.automation.framework.cp.pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.framework.utils.Log4j2Util;

public class CPHomePage {

	WebDriver driver;
	static String CP_APP_URL = "https://www.nba.com/warriors";

	@FindBy(xpath = "//a[@class=' style__link_2QXEv']")
	WebElement optionMenu;
	
	@FindBy(xpath = "//a[@class='accent-primary-border style__link_2QXEv']/span[contains(text(),'Shop')]")
	WebElement shopOptionMenu;
	
	@FindBy(xpath = "//a[@href='https://shop.warriors.com/golden-state-warriors-men/t-14145130+ga-67+z-978556-2897172570']")
	WebElement shopMensLinkElement;

	@FindBy(xpath = "//a[@href='/warriors/news']")
	WebElement newsAndFeaturesElement;

	@FindBy(xpath = "/html/body/div[4]/div[1]/div")
	WebElement homeWinPopUp;

	static String CPHomePageWindowId;
	public CPHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateAppHomePage() {
		driver.get(CP_APP_URL);
		if (homeWinPopUp.isDisplayed()) {
			homeWinPopUp.click();
		}
		if (((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete")) {
			Log4j2Util.info("Page has loaded completely.");
		} else {
			Log4j2Util.error("Page has not loaded completely.");
			return;
		}
		CPHomePageWindowId = driver.getWindowHandle();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void routeToNewFeatureSite() {
		new Actions(driver).moveToElement(optionMenu).perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", newsAndFeaturesElement);
	}
	
	public void routeToMensShopSite() {
		new Actions(driver).moveToElement(shopOptionMenu).perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", shopMensLinkElement);
	}

}
