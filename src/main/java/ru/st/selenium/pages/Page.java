package ru.st.selenium.pages;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * Abstract class representation of a Page in the UI. Page object pattern
 * 
 * @author Sebastiano Armeli-Battana
 */
public abstract class Page {

	protected WebDriver driver;
	protected WebDriverWait wait;
  	protected PageManager pages;
	public final Logger log = Logger.getLogger(this.getClass().getSimpleName());


	/*
	 * Constructor injecting the WebDriver interface
	 * 
	 * @param webDriver
	 */
	public Page(PageManager pages) {
	  this.pages = pages;
    driver = pages.getWebDriver();
    wait= new WebDriverWait(driver, 30);
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public Page ensurePageLoaded() {
	  return this;
	}

  public boolean waitPageLoaded() {
    try {
      ensurePageLoaded();
      return true;
    } catch (TimeoutException to) {
      return false;
    }
  }

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}


	public boolean isElementPresent(WebElement webElement) {
		try {
			driver.findElement((By) webElement);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void log(String text) {
		log.info(text);
		Reporter.log(text);
	}
}
