package com.automation.framework.cp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.framework.utils.CommonUtils;

public class CPHomePage {

	WebDriver driver;
	CommonUtils commonUtils;
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

	public CPHomePage(WebDriver driver) {
		this.driver = driver;
		commonUtils = new CommonUtils(driver);
		PageFactory.initElements(driver, this);
	}

	public void navigateAppHomePage() {
		commonUtils.navigateToApp(CP_APP_URL);
		if (homeWinPopUp.isDisplayed()) {
			homeWinPopUp.click();
		}
		commonUtils.isPageLoadComplete();
	}

	public String getPageTitle() {
		return commonUtils.getPageTitle();
	}

	public void routeToNewFeatureSite() {
		commonUtils.moveToElement(optionMenu);
		commonUtils.jseClick(newsAndFeaturesElement);
	}
	
	public void routeToMensShopSite() {
		commonUtils.moveToElement(shopOptionMenu);
		commonUtils.jseClick(shopMensLinkElement);
	}

}
