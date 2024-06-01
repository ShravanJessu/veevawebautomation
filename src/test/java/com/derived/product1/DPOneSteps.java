package com.derived.product1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.automation.framework.common.Hooks;
import com.automation.framework.cp.pages.LoginPage;

public class DPOneSteps {
	WebDriver driver = Hooks.getDriver();
	LoginPage loginPage;

	@Given("User is on DP One Home Page")
	public void homePage() {
		driver.get("https://www.nba.com/sixers/");
		loginPage = new LoginPage(driver);
	}

	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_and_password(String username, String password) {
//        loginPage.login(username, password);
		System.out.println("browser title: "+ driver.getTitle());
	}

	@Then("User should be logged in")
	public void user_should_be_logged_in() {
		// Add validation code here
		driver.quit();
	}
}
