package com.core.product.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.automation.framework.cp.pages.CPHomePage;
import com.automation.framework.cp.pages.CPMensShopPage;
import com.automation.framework.cp.pages.CPNewsAndFeaturesPage;

import common.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CPSteps {
	
		
	WebDriver driver = Hooks.getDriver();
	CPHomePage homePage = new CPHomePage(driver);
	CPNewsAndFeaturesPage cpNewsAndFeaturesPage = new CPNewsAndFeaturesPage(driver);;
	CPMensShopPage cpMensShopPage = new CPMensShopPage(driver);
	
	@Given("User is on CP Home Page")
	public void homePage() {
		homePage.navigateAppHomePage();
		 // Assert that the page title contains a specific string
		String expectedTitlePart = "Home | Golden State Warriors";
        String actualTitle = homePage.getPageTitle();;
        Assert.assertTrue(actualTitle.contains(expectedTitlePart), "Page title does not contain expected text.");
	}
	
	
	@When("User routed the new and feature site")
	public void routeToNewFeatureSite() {
		homePage.routeToNewFeatureSite();
	}
	
	@When("User routed the new and mens shop site")
	public void routeToMensShopSite() {
		homePage.routeToMensShopSite();
	}

	@Then("User captures feed details")
	public void captureFeedDetails() {
		cpNewsAndFeaturesPage.getTotalFeedCount();
	}
	
	@When("User select product from available options")
	public void selectProductFromAllOptions() {
		cpMensShopPage.findProductInSearch();
	}
	
	@Then("User captures all product details")
	public void captureProductDetails() {
		cpMensShopPage.getProductDetails();
	}
	
	
}
