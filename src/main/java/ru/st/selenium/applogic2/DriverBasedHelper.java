package ru.st.selenium.applogic2;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
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
  
}
