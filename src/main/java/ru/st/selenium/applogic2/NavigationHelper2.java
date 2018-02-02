package ru.st.selenium.applogic2;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import ru.st.selenium.applogic.NavigationHelper;

import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class NavigationHelper2 extends DriverBasedHelper implements NavigationHelper {

  public final Logger log = Logger.getLogger(this.getClass().getSimpleName());

  private String baseUrl;

  public NavigationHelper2(ApplicationManager2 manager) {
    super(manager.getWebDriver());
    this.baseUrl = manager.getBaseUrl();
  }
  
  @Override
  public void gotoHomePage() {
    driver.get(baseUrl);
  }

  @Override
  public void gotoClubsPage() {
    pages.internalPage.clickClubsButton();

  }

  @Override
  public void gotoTheGamePage() {
    pages.internalPage.clickTheGameButton();
    //driver.get(baseUrl + "/the-game/");
  }

  @Override
  public void gotoNewsPage() {
    pages.internalPage.clickNewsButton();
    //driver.get(baseUrl + "/news/");
  }

  @Override
  public void gotoTournamentsPage() {
    pages.internalPage.clickTournamentsButton();
    //driver.get(baseUrl + "/tournaments/");
  }

  @Override
  public void gotoHistoryPage() {
    pages.internalPage.clickHistoryButton();
    driver.get(baseUrl + "/history/");
  }

  @Override
  public void gotoGalleryPage() {
    pages.internalPage.clickGalleryButton();
    //driver.get(baseUrl + "/gallery/");
  }

  @Override
  public void gotoShopPage() {
    pages.internalPage.clickShopButton();
    //driver.get(baseUrl + "/shop/");
  }

  @Override
  public void openRelativeUrl(String url) {
    driver.get(baseUrl + url);
  }

  public void gotoAdminPage() {
    driver.get(baseUrl + "/admin/");
  }


    //wait.until(presenceOfElementLocated(By.xpath("//button[@class = 'ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close']")));
    //pages.internalPage.clickButtonCloseAlert();


  @Override
  public void gotoLoginPage() {
    pages.internalPage.clickLoginButton();
  }

  String parentWindow = "";
  @Override
  public void switchToNewWindow() {
    parentWindow = driver.getWindowHandle();
    Set<String> handles = driver.getWindowHandles();
    for (String windowHandle: handles
         ) {
          if (!handles.equals(parentWindow)) {
            driver.switchTo().window(windowHandle);
          }
    }
  }

  public void switchToDefaultWindow() {
    driver.switchTo().window(parentWindow);
  }
}
