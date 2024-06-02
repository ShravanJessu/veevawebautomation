package com.automation.framework.cp.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.framework.utils.CommonUtils;
import com.automation.framework.utils.Log4j2Util;

public class CPNewsAndFeaturesPage {

	@FindBy(xpath = "//h3[contains(text(),'VIDEOS')]/parent::div/following-sibling::div/div/ul/li")
	List<WebElement> feedElementList;

	@FindBy(xpath = "//h3[contains(text(),'VIDEOS')]/parent::div/following-sibling::div/div/ul")
	WebElement feedElementULList;

	@FindBy(xpath = "//h3[contains(text(),'VIDEOS')]/parent::div/following-sibling::div/div/ul/li//time/span")
	List<WebElement> spanElementList;

	WebDriver driver;
	CommonUtils commonUtils;

	public CPNewsAndFeaturesPage(WebDriver driver) {
		this.driver = driver;
		commonUtils = new CommonUtils(driver);
		PageFactory.initElements(driver, this);
	}

	public void getTotalFeedCount() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete")) {
			Log4j2Util.info("Page has loaded completely.");
		} else {
			Log4j2Util.error("Page has not loaded completely.");
			return;
		}

		Log4j2Util.info("Total feedElementList - " + feedElementList.size());
		int counter = 0;
		for (WebElement webElement : spanElementList) {
			if (webElement.getText().equals("1d") || webElement.getText().equals("2d")) {
				counter++;
			}
		}
		Log4j2Util.info("Greater Than 3d Feed Count Details: " + (feedElementList.size() - counter));
	}

}
