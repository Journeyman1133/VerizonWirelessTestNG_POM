package com.qa.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.HomePage;
import com.qa.verizon.pages.PhonePage;
import com.qa.verizon.pages.SmartphonePage;
import com.qa.verizon.util.AppConstants;

public class PhonePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	SmartphonePage smartphonePage;
	PhonePage phonePage;
	WebDriverWait wait;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		smartphonePage = new SmartphonePage(driver);
		smartphonePage = homePage.hoverPhonesAndClick();
		phonePage = smartphonePage.choosePhone();
	}

	@Test(priority = 1)
	public void getPhonePageTitle() {
		String title = phonePage.getPhonePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, AppConstants.PHONE_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void chooseFeatures() {
		phonePage.chooseFeatures();
	}

	@Test(priority = 3)
	public void zipCodeEnter() {
		phonePage.zipCodeEnter();
	}

	@Test(priority = 4)
	public void moreFeatures() {
		phonePage.moreFeatures();
	}

	@Test(priority = 5)
	public void verifyPhone() {
		String iPhone = phonePage.verifyPhone();
		System.out.println(iPhone);
		Assert.assertEquals(iPhone, AppConstants.VERIFY_PHONE_TITLE);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
