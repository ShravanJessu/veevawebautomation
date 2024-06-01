package com.derived.product1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import com.automation.framework.cp.pages.LoginPage;
import com.automation.framework.dp1.pages.DPOneHomePage;
import com.automation.framework.dp2.pages.DPTwoHomePage;

import common.Hooks;

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
	public void captureSildesCount() {
		dpOneHomePage.getSildesCountFromTicketMenu();
	}

	
}
