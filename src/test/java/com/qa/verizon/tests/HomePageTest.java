package com.qa.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.HomePage;
import com.qa.verizon.util.AppConstants;

public class HomePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
	}

	@Test(priority = 1, description = "Verizon Wireless, Smartphone Deals & Plans | First to 5G")
	public void verifyHomePageTitle() throws InterruptedException {
		String title = homePage.getHomePageTitle();
		System.out.println("Homepage title is " + title);
		Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE);
		Thread.sleep(3000);
	}

	@Test(priority = 2, description = "Hover over Smartphones and chooses the phone")
	public void hoverPhonesAndClick() {
		homePage.hoverPhonesAndClick();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}