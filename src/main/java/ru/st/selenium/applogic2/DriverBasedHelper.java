package ru.st.selenium.applogic2;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Reporter;
import ru.st.selenium.pages.PageManager;

public class DriverBasedHelper {

  protected WebDriver driver;
  protected WebDriverWait wait;
  protected PageManager pages;
  public final Logger log = Logger.getLogger(this.getClass().getSimpleName());

  public DriverBasedHelper(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 30);
    pages = new PageManager(driver);
  }

  public void log(String text) {
    log.info(text);
    Reporter.log(text);
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

  public String getLanguage() {
    String language = "";
    return language = driver.findElement(By.xpath("//div[@class = 'telephone']/p")).getText().equalsIgnoreCase("Телефоны:") ? "rus" :"eng";
  }
  
}
