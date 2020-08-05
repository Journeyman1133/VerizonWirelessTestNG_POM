package com.qa.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.HomePage;
import com.qa.verizon.pages.SmartphonePage;
import com.qa.verizon.util.AppConstants;

public class SmartphonePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	SmartphonePage smartphonePage;

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
	}

	@Test(priority = 1, description = "Smartphone Page Title = Smartphones - Buy The Newest Cell Phones | Verizon Wireless")
	public void verifyHomePageTitle() throws InterruptedException {
		String title = homePage.getHomePageTitle();
		System.out.println("Homepage title is " + title);
		Assert.assertEquals(title, AppConstants.SMARTPHONE_PAGE_TITLE);
		Thread.sleep(3000);
	}

	@Test(priority = 2, description = "Chooses the phone you like")
	public void choosePhone() {
		smartphonePage.choosePhone();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
