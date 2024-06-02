package com.derived.product1.steps;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.automation.framework.dp1.pages.DPOneHomePage;
import com.automation.framework.utils.ExcelUtils;

import common.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DPOneSteps {
	WebDriver driver = Hooks.getDriver();
	DPOneHomePage dpOneHomePage ;
	
	@Given("User is on DP One Home Page")
	public void homePage() {
		dpOneHomePage = new DPOneHomePage(driver);
		dpOneHomePage.navigateAppHomePage();
		 // Assert that the page title contains a specific string
		String expectedTitlePart = "Sixers - The official site of the NBA for the latest NBA Scores";
        String actualTitle = dpOneHomePage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitlePart), "Page title does not contain expected text.");
	}
	
	
	@When("User captures count of avaiables sildes from Tickets Menu")
	public void captureTicketSubSildesCount() {
		dpOneHomePage.getCountFromTicketMenuSlide();
	}
	
	@When("User captures each slide and validates data")
	public void captureSildesCount() {
		List<String> itemsList = dpOneHomePage.getSlidesAndValidate();
		String filePath = System.getProperty("user.dir") + "/src/test/resources/data/excel_data.xlsx";
		List<String> ticketData = ExcelUtils.readTestDataFromExcel(filePath, "Tickets");
		Assert.assertTrue(itemsList.equals(ticketData));
	}

	
}
