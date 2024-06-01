package com.automation.framework.cp.pages;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.framework.utils.Log4j2Util;

public class CPMensShopPage {

	@FindBy(xpath = "//div[@class='pagination-component']//a[@aria-label='next page']//parent::li")
	WebElement nextPageButton;

	@FindBy(xpath = "//a[@href='/golden-state-warriors-men/t-14145130+ga-67+z-978556-2897172570']")
	WebElement mensLinkElement;

	@FindBy(xpath = "*[href='/golden-state-warriors-men-jackets/t-25690618+ga-01+d-3438843071+z-9-4167543?_ref=m-TOPNAV']")
	WebElement mensJacketElement;

	@FindBy(xpath = "//div[@class='product-count']/following-sibling::div//li[@class='next-page']")
	WebElement nextPage;

	@FindBy(xpath = "//div[@class='product-card-title']/a")
	List<WebElement> productTitle;

	@FindBy(xpath = "//div[@class='grid-small-1-medium-3 row small-up-1 medium-up-3']/div/div[@class='product-card row']")
	List<WebElement> mensProductListElements;

	@FindBy(xpath = "//div[@class='price-card']//span[@class='lowest']//span[@class='sr-only']")
	List<WebElement> productPriceTag;

	@FindBy(xpath = "/div/div[2]/div/button")
	WebElement mensShopWinPopUp;

	@FindBy(id = "typeahead-input-desktop")
	WebElement searchBox;

	WebDriver driver;

	public CPMensShopPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectProductFromAvailableOptions() {
//		if(mensShopWinPopUp.isDisplayed()) {
//			mensShopWinPopUp.click();
//		}
		WebDriverWait wbDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wbDriverWait.until(ExpectedConditions.visibilityOf(mensLinkElement));
		new Actions(driver).moveToElement(mensLinkElement).perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", mensJacketElement);
	}

	public void getProductDetails() {

		List<WebElement> allItems = collectAllItems();
		System.out.println("Available Products Count: " + allItems.size());
//		for (int i = 0; i < allItems.size(); i++) {
//			System.out.println("Product Name: " + productTitle.get(i).getText());
//			System.out.println("Product Price: " + productPriceTag.get(i).getText());
//		}
	}

	public List<WebElement> collectAllItems() {
		String filePath = System.getProperty("user.dir") + "/src/test/resources/data/cp_product.txt";
		List<WebElement> allItems = new ArrayList<>();
		try {
			if (new File(filePath).exists()) {
				new File(filePath).delete();
			}
			new File(filePath).createNewFile();

			BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));

			System.out.println("Size of mensProductListElements: "+ mensProductListElements.size());
			while (true) {
				for (int i = 0; i < mensProductListElements.size(); i++) {
					writer.write("Product Name: " + productTitle.get(i).getText() + " , " + "Product Price: "
							+ productPriceTag.get(i).getText());
					writer.newLine();
					allItems.add(mensProductListElements.get(i));
				}
				if (!nextPageButton.getAttribute("class").contains("disabled")) {
					nextPageButton.click();
				} else {
					break;
				}
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allItems;
	}

	private boolean isNextPageAvailable() {
		return nextPageButton.isEnabled();
	}

	public void findProductInSearch() {
		String originalWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		System.out.println(driver.getCurrentUrl() + " :: " + driver.getTitle());
//		if(mensShopWinPopUp.isDisplayed()) {
//			mensShopWinPopUp.click();
//		}
		if (((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete")) {
			Log4j2Util.info("Page has loaded completely.");
		} else {
			Log4j2Util.error("Page has not loaded completely.");
			return;
		}
		WebDriverWait wdDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		((JavascriptExecutor) driver).executeScript("arguments[0].value='Jackets';", searchBox);
		searchBox.sendKeys("Jackets" , Keys.ENTER);
	}

}
