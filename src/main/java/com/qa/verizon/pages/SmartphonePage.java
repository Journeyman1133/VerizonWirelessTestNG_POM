package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.AppConstants;
import com.qa.verizon.util.ElementUtil;

public class SmartphonePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	By selectedPhone = By.xpath("//a[@aria-label='Apple iPhone 11 Pro Max']");
	
	public SmartphonePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getHomePageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleIs("Smartphones - Buy The Newest Cell Phones | Verizon Wireless"));
		return elementUtil.doGetPageTitle(AppConstants.SMARTPHONE_PAGE_TITLE);
	}

	public PhonePage choosePhone() {
		elementUtil.doClick(selectedPhone);
		return new PhonePage(driver);
	}
}
