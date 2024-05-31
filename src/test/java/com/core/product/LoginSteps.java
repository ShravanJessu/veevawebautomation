package com.core.product;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.automation.framework.cp.pages.LoginPage;

public class LoginSteps {
	WebDriver driver;
	LoginPage loginPage;

	@Given("User is on Login Page")
	public void user_is_on_login_page() {
		String browser = System.getProperty("browser", "msedge");
		switch (browser.toLowerCase()) {
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "msedge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "chrome":
		default:
			driver = new ChromeDriver();
			break;
		}
//		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		loginPage = new LoginPage(driver);
	}

	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_and_password(String username, String password) {
//        loginPage.login(username, password);
		System.out.println("browser title: "+driver.getTitle());
	}

	@Then("User should be logged in")
	public void user_should_be_logged_in() {
		// Add validation code here
		driver.quit();
	}
}
