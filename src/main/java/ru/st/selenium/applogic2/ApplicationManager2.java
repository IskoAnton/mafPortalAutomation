package ru.st.selenium.applogic2;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import ru.st.selenium.applogic.*;
import ru.st.selenium.listeners.WebEventListener;
import ru.st.selenium.pages.PageManager;
import ru.st.selenium.util.Browser;
import ru.st.selenium.util.PropertyLoader;
import ru.st.selenium.webdriver.WebDriverFactory;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventListener;


public class ApplicationManager2 implements ApplicationManager {

  private UserHelper userHelper;
  private AdminUserHelper adminUserHelper;
  private NavigationHelper navHelper;
  private ShopHelper shopHelper;

  private WebDriver driver;
  //private EventFiringWebDriver driver;
  //private WebEventListener eventListener;
  private String baseUrl;
  private PageManager pages;


  public ApplicationManager2() {
    String log4jConfPath = "log4j.properties";
    PropertyConfigurator.configure(log4jConfPath);
    baseUrl = PropertyLoader.loadProperty("site.url");
    String gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

    Browser browser = new Browser();
    browser.setName(PropertyLoader.loadProperty("browser.name"));
    browser.setVersion(PropertyLoader.loadProperty("browser.version"));
    browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

    if (browser.getName().equalsIgnoreCase("firefox")) {
      System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
    }

    String username = PropertyLoader.loadProperty("user.username");
    String password = PropertyLoader.loadProperty("user.password");

    driver = WebDriverFactory.getInstance(gridHubUrl, browser, username, password);
    /*driver = new EventFiringWebDriver(dr);
    eventListener = new WebEventListener();
    driver.register(eventListener);*/
    driver.manage().deleteAllCookies();

    // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    userHelper = new UserHelper2(this);
    adminUserHelper = new AdminUserHelper2(this);
    navHelper = new NavigationHelper2(this);
    shopHelper = new ShopHelper2(this);
    getNavigationHelper().gotoHomePage();
    pages = new PageManager(driver);
  }

  @Override
  public UserHelper getUserHelper() {
    return userHelper;
  }

  @Override
  public AdminUserHelper getAdminUserHelper() {
    return adminUserHelper;
  }

  @Override
  public PageManager getPages() {
    return pages;
  }


  @Override
  public NavigationHelper getNavigationHelper() {
    return navHelper;
  }

  @Override
  public ShopHelper getShopHelper() {
    return shopHelper;
  }

  protected WebDriver getWebDriver() {
    return driver;
  }

  protected String getBaseUrl() {
    return baseUrl;
  }

  @Override
  public void stop() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Override
  public void maximizeBrowser() {
    driver.manage().window().maximize();
  }

  @Override
  public void refreshBrowser() {
    driver.navigate().refresh();
  }

  @Override
  public void takeScreenShotOnFailure(ITestResult testResult, String testName) throws IOException {

    String folderDate = "";
    if (testResult.getStatus() == ITestResult.FAILURE) {
      System.out.println(testResult.getStatus());
      File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

      if (folderDate.equals("")) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy_HH-mm-ss");
        folderDate = dateFormat.format(new Date());
      }

      String screenshotAbsolutePath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "surefire-reports" + File.separator + "FailedTestsScreenshots" + File.separator + folderDate + File.separator + testName + ".jpg";
      String screenshotHttpPath = "file:" + File.separator + File.separator + screenshotAbsolutePath;
      System.out.println("screenshotAbsolutePath " + screenshotAbsolutePath);
      System.out.println("screenshotHttpPath " + screenshotHttpPath);
      FileUtils.copyFile(scrFile, new File(screenshotAbsolutePath));
      System.setProperty("org.uncommons.reportng.escape-output", "false");
      Reporter.log("<p><br><br>Bug in test \"" + testName + "\"<br><img width=\"1024\" src = " + screenshotHttpPath + "> </p></a><br/>");
    }
  }
}
