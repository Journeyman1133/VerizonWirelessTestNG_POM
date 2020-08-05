package com.qa.verizon.util;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.verizon.base.BasePage;

public class ElementUtil extends BasePage {

	WebDriver driver;
	WebDriverWait wait;
	JSUtil jsUtil;
	Properties prop;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, AppConstants.DEFAULT_TIME);
		jsUtil = new JSUtil(driver);
	}

	public void clearTheBox(By locator) {
		driver.findElement(locator).clear();
	}

	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception occured while clicking the element.." + locator);
		}
	}

	public String doGetPageTitle(String title) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.titleContains(title));
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println("some exception occured while getting the title..");
		}
		return null;
	}

	public String doGetText(By locator) {
		try {
			return getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("some exception occured while getting the text from page.." + locator);
		}
		return null;
	}

	public boolean doIsDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("some exception occured for isDisplayed.." + locator);
		}
		return false;
	}

	public boolean doIsEnabled(By locator) {
		try {
			return getElement(locator).isEnabled();
		} catch (Exception e) {
			System.out.println("some exception occured for isEnabled.." + locator);
		}
		return false;
	}

	public boolean doIsSelected(By locator) {
		try {
			return getElement(locator).isSelected();
		} catch (Exception e) {
			System.out.println("some exception occured for isSelected.." + locator);
		}
		return false;
	}

	public void doSendKeys(By locator, String value) {
		try {
			WebElement element = getElement(locator);
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception occured while sending the value.." + locator);
		}
	}

	public WebElement getElement(By locator) {
		WebElement element = null;

		try {
			element = driver.findElement(locator);
			if (highlightElement) {
				jsUtil.flash(element);
			}
		} catch (Exception e) {
			System.out.println("some exception occured while getting the element.." + locator);
		}
		return element;
	}

	public void SelectbyValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
		;
	}
	
	/**
	 * wait element
	 * 
	 * @param locator
	 * @return
	 */
	public void waitForElementPresentBy(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * Visibility element
	 * 
	 * @param locator
	 * @return
	 */
	public boolean waitForElementVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}
	
	/**
	 * Title wait method
	 * 
	 * @param title
	 * @return
	 */
	public boolean waitForTitlePresent(String title) {
		wait.until(ExpectedConditions.titleIs(title));
		return true;
	}
}