package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.AppConstants;
import com.qa.verizon.util.ElementUtil;
import com.qa.verizon.util.JSUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	JSUtil jsUtil;
	
	By shop = By.xpath("//div[@class='gnav20-primary-menu gnav20-grouping']");
	By smartphones = By.partialLinkText("Smartphone");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JSUtil(driver);
	}

	public String getHomePageTitle() {
		return elementUtil.doGetPageTitle(AppConstants.HOME_PAGE_TITLE);
	}

	public SmartphonePage hoverPhonesAndClick() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBe(shop, "Shop"));
		WebElement phoneList = driver.findElement(shop);
		Actions builder = new Actions(driver);
		builder.moveToElement(phoneList).build().perform();
		elementUtil.doClick(smartphones);
		return new SmartphonePage(driver);
	}
}