package com.derived.product2.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.automation.framework.dp2.pages.DPTwoHomePage;

import common.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DPTwoSteps {
	WebDriver driver = Hooks.getDriver();
	DPTwoHomePage homePage;
	
	@Given("User is on DP Two Home Page")
	public void homePage() {
		homePage = new DPTwoHomePage(driver);
		homePage.navigateAppHomePage();
		 // Assert that the page title contains a specific string
		String expectedTitlePart = "Bulls - The official site of the NBA for the latest NBA Scores";
        String actualTitle = homePage.getPageTitle();;
        Assert.assertTrue(actualTitle.contains(expectedTitlePart), "Page title does not contain expected text.");
	}

	@When("User scolls to page footer section")
	public void scrollToFooterSec() {
		homePage.scrollToFooterSection();
	}

	@Then("User captures all availables links and stores in file")
	public void captureLinksAndStoreCsvFile() {
		homePage.getAvaiablesLinksFromFooter();
		homePage.storeLinksIntoCSVFile();
	}
	
}
