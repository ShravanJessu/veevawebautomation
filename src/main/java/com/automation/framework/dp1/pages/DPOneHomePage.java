package com.automation.framework.dp1.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.framework.utils.CommonUtils;
import com.automation.framework.utils.Log4j2Util;

public class DPOneHomePage {

	WebDriver driver;
	CommonUtils commonUtils;
	static String DP_ONE_APP_URL = "https://www.nba.com/sixers/";

	@FindBy(xpath = "//nav[@class='NavBar_headerPrimaryMenu__kZbi8']//a/span[contains(text(),'Tickets')]")
	WebElement ticketMenuElement;

	@FindBy(xpath = "(//a[@href='/sixers/tickets']/span[contains(text(),'Tickets')])[1]//parent::a/following-sibling::nav//li/a")
	List<WebElement> ticketSubSildesElementList;

	public DPOneHomePage(WebDriver driver) {
		this.driver = driver;
		commonUtils = new CommonUtils(driver);
		PageFactory.initElements(driver, this);
	}

	public void navigateAppHomePage() {
		commonUtils.navigateToApp(DP_ONE_APP_URL);
		commonUtils.isPageLoadComplete();
	}

	public String getPageTitle() {
		Log4j2Util.info("DP One HomePage Title: " + commonUtils.getPageTitle());
		return commonUtils.getPageTitle();
	}

	public List<String> getSlidesAndValidate() {
		for (WebElement webElement : ticketSubSildesElementList) {
			Log4j2Util.info("ticketSubSildesElementList Item :" + webElement.getText());
		}
		List<String> listItemTexts = ticketSubSildesElementList.stream().map(WebElement::getText)
				.collect(Collectors.toList());
		return listItemTexts;
	}

	public void getCountFromTicketMenuSlide() {
		commonUtils.moveToElement(ticketMenuElement);
		Log4j2Util.info("Sildes Count under Team Menu: " + ticketSubSildesElementList.size());
	}

}
