package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.AppConstants;
import com.qa.verizon.util.ElementUtil;

public class PhonePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	By color = By.xpath("//div[contains(@style, 'rgb(0, 73, 83)')]");
	By size = By.xpath("//div[@class='sizePad']//p[contains(text(),'256GB')]");
	By payment = By.xpath("//div/div[contains(text(),'Retail price')]");
	By continueBtn = By.id("ATC-Btn");
	By zipCode = By.id("zipcode");
	By confirmBtn = By.className("defaultPrimaryCTA");
	By newCustomer = By.xpath("//button[@aria-label='New Customer']");
	By next = By.xpath("//button[@aria-label='Next']");
	By tradeIn = By.xpath("//button[@aria-label='No I would not like to trade in']");
	By declineDeviceSelectProtectionBtn = By.xpath("//button[@aria-label='Decline device protection']"); 
	By secondDeviceProtection = By.xpath("//button[@class='secondary button cancelProtectionButton']");
	By selectPlanList = By.xpath("//button[@aria-label='Start Unlimited']");
	By saveCart = By.className("saveCartPadding");
	By verifyMyPhone = By.xpath("//span[contains(text(),'iPhone® 11 Pro Max')]");

	public PhonePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getPhonePageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleIs("Apple iPhone 11 Pro Max: Colors, Reviews, & More | Buy Now"));
		return elementUtil.doGetPageTitle(AppConstants.PHONE_PAGE_TITLE);
	}

	public void chooseFeatures() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(color));
		elementUtil.doClick(color);
		elementUtil.doClick(size);
		elementUtil.doClick(payment);
		elementUtil.doClick(continueBtn);

	}

	public void zipCodeEnter() {
		elementUtil.clearTheBox(zipCode);
		elementUtil.doSendKeys(zipCode, "08823");
		elementUtil.doClick(confirmBtn);
	}

	public void moreFeatures() {
		elementUtil.doClick(newCustomer);
		elementUtil.doClick(next);
		elementUtil.doClick(tradeIn);
		elementUtil.doClick(declineDeviceSelectProtectionBtn);
		elementUtil.doClick(secondDeviceProtection);
		elementUtil.doClick(selectPlanList);
		elementUtil.doClick(saveCart);
	}

	public String verifyPhone() {

		return elementUtil.doGetText(verifyMyPhone);

	}
}