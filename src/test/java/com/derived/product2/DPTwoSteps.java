package com.derived.product2;

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
import com.automation.framework.dp2.pages.HomePage;

import common.Hooks;

public class DPTwoSteps {
	WebDriver driver = Hooks.getDriver();
	HomePage homePage;
	
	@Given("User is on DP Two Home Page")
	public void homePage() {
		homePage = new HomePage(driver);
		homePage.navigateAppHomePage();
		homePage.getPageTitle();
		 // Assert that the page title contains a specific string
		String expectedTitlePart = "Bulls - The official site of the NBA for the latest NBA Scores";
        String actualTitle = driver.getTitle();
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
