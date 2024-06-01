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

import com.automation.framework.utils.Log4j2Util;

public class DPTwoHomePage {

	WebDriver driver;
	static String DP_TWO_APP_URL = "https://www.nba.com/bulls/";

	@FindBy(xpath = "//footer[@class='text-xs text-white dark-primary-background print:hidden']")
	WebElement footerElement;

	@FindBy(xpath = "//footer[@class='text-xs text-white dark-primary-background print:hidden']//a[not(@href = following::a/@href)]")
	List<WebElement> footerLinks;

	public DPTwoHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateAppHomePage() {
		driver.get(DP_TWO_APP_URL);
		if (((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete")) {
			Log4j2Util.info("Page has loaded completely.");
		} else {
			Log4j2Util.error("Page has not loaded completely.");
			return;
		}
	}
	
	public String getPageTitle() {
		String pageTitle = driver.getTitle();
		Log4j2Util.info("DP Two HomePage Title: " + driver.getTitle());
		return pageTitle;
	}

	public void scrollToFooterSection() {
		Log4j2Util.info("Scrolling to footer section.");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footerElement);
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
		boolean fileExists = new File(csvFilePath).exists();
		if (fileExists) {
			new File(csvFilePath).delete();
		}
		try (FileWriter csvWriter = new FileWriter(csvFilePath, true)) {
			if (!fileExists) {
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
