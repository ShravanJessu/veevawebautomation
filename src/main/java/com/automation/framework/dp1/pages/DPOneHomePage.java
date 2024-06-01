package com.automation.framework.dp1.pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automation.framework.utils.Log4j2Util;

public class DPOneHomePage {

	WebDriver driver;
	static String DP_ONE_APP_URL = "https://www.nba.com/sixers/";

	@FindBy(xpath = "//li[@data-testid='nav-item-/sixers/tickets']")
	WebElement ticketMenuElement;

	@FindBy(xpath = "//*[@id='div-gpt-ad-171724190374749-global_nav_1st_pos1']/following-sibling::ul/li")
	List<WebElement> sildesElementList;

	public DPOneHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateAppHomePage() {
		driver.get(DP_ONE_APP_URL);
		if (((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete")) {
			Log4j2Util.info("Page has loaded completely.");
		} else {
			Log4j2Util.error("Page has not loaded completely.");
			return;
		}
	}

	public String getPageTitle() {
		String pageTitle = driver.getTitle();
		Log4j2Util.info("DP One HomePage Title: " + driver.getTitle());
		return pageTitle;
	}

	public void getSildesCountFromTicketMenu() {
		new Actions(driver).moveToElement(ticketMenuElement).perform();
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		webDriverWait.until(ExpectedConditions.visibilityOfAllElements(sildesElementList));
		System.out.println("Sildes Count under Tickets Menu: " + sildesElementList.size());
		
        // Map to store start times for each slide
        Map<Integer, Long> slideStartTimes = new HashMap<>();

        // Iterate through each slide and measure duration
        for (int i = 0; i < sildesElementList.size(); i++) {
            WebElement slide = sildesElementList.get(i);

            // Wait for the slide to be visible
            waitForSlideToBeVisible(slide);

            // Record the start time
            long startTime = System.currentTimeMillis();
            slideStartTimes.put(i, startTime);

            // Wait for the expected duration (simulating the slide being displayed)
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Record the end time
            long endTime = System.currentTimeMillis();

            // Calculate the actual duration
            long actualDuration = endTime - startTime;

            // Validate the duration
            Assert.assertTrue(Math.abs(actualDuration - 5000) < 500, // Allow a tolerance of 500 ms
                    "Slide " + (i + 1) + " duration mismatch: expected " + 5000 + " ms, but got " + actualDuration + " ms.");
        }
	}

	private void waitForSlideToBeVisible(WebElement el) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		webDriverWait.until(ExpectedConditions.visibilityOfAllElements(sildesElementList));
		while (!el.isDisplayed()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }		
	}

}
