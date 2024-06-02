package com.automation.framework.dp2.pages;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.framework.utils.CommonUtils;
import com.automation.framework.utils.Log4j2Util;

public class DPTwoHomePage {

	WebDriver driver;
	CommonUtils commonUtils;
	static String DP_TWO_APP_URL = "https://www.nba.com/bulls/";

	@FindBy(xpath = "//footer[@class='text-xs text-white dark-primary-background print:hidden']")
	WebElement footerElement;

	@FindBy(xpath = "//footer[@class='text-xs text-white dark-primary-background print:hidden']//a[not(@href = following::a/@href)]")
	List<WebElement> footerLinks;

	public DPTwoHomePage(WebDriver driver) {
		this.driver = driver;
		commonUtils = new CommonUtils(driver);
		PageFactory.initElements(driver, this);
	}

	public void navigateAppHomePage() {
		commonUtils.navigateToApp(DP_TWO_APP_URL);
		commonUtils.isPageLoadComplete();
	}
	
	public String getPageTitle() {
		Log4j2Util.info("DP Two HomePage Title: " +  commonUtils.getPageTitle());
		return commonUtils.getPageTitle();
	}

	public void scrollToFooterSection() {
		Log4j2Util.info("Scrolling to footer section.");
		commonUtils.jseScroll(footerElement);
		Log4j2Util.info("Successfully completed scrolling to footer section.");
	}

	public void getAvaiablesLinksFromFooter() {
		Log4j2Util.info("Available Links Count: " + footerLinks.size());
		// To print each higher link on console
//		footerLinks.stream().forEach(element -> Log4j2Util.info("Link URL : " + element.getAttribute("href")));
	}

	public void storeLinksIntoCSVFile() {
		Set<String> uniqueLinks = new HashSet<>();
		List<String> duplicateLinks = new ArrayList<String>();
		boolean duplicateLinksFound = false;

		String csvFilePath = System.getProperty("user.dir") + "/src/test/resources/data/dp_two_footer_links.csv";
		File fileObj = new File(csvFilePath);
		if (fileObj.exists()) {
			fileObj.delete();
		}
		try {
			fileObj.createNewFile();
			FileWriter csvWriter = new FileWriter(csvFilePath, true);
			if (!fileObj.exists()) {
				csvWriter.append("Link");
				csvWriter.append("\n");
			}
			for (WebElement link : footerLinks) {
				String href = link.getAttribute("href");
				if (href != null && !href.isEmpty() && uniqueLinks.add(href)) {
					csvWriter.append(href);
					csvWriter.append("\n");
				} else {
					duplicateLinks.add(href);
					duplicateLinksFound = true;
				}
			}

			if (duplicateLinksFound) {
				Log4j2Util.info("Following duplicates link(s) found : \n" + duplicateLinks);
			} else {
				Log4j2Util.info("No duplicates link(s) found");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
