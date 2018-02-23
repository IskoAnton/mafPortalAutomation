package ru.st.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.Event;
import ru.st.selenium.model.MenuItem;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;


public class InternalPage extends AnyPage {

  public InternalPage(PageManager pages) {
    super(pages);
  }

  //локаторы для проверки всех элементов на странице
  private final String  HEADER_LOGO_LOCATOR = "//div[@class = 'logoName']";  // в хэдере в левом верхнем углу отображается название вкладки
  private final String  CLUBS_BUTTON_LOCATOR= "//nav[@class = 'headMenu']//a[contains(text(),'CLUBS') or contains(text(),'КЛУБЫ')]";
  private final String  THEGAME_BUTTON_LOCATOR= "//nav[@class = 'headMenu']//a[contains(text(),'THE GAME') or contains(text(),'ИГРА')]";
  private final String  NEWS_BUTTON_LOCATOR= "//nav[@class = 'headMenu']//a[contains(text(),'NEWS') or contains(text(),'НОВОСТИ')]";
  private final String  TOURNAMENTS_BUTTON_LOCATOR= "//nav[@class = 'headMenu']//a[contains(text(),'TOURNAMENTS') or contains(text(),'ТУРНИРЫ')]";
  private final String  HISTORY_BUTTON_LOCATOR= "//nav[@class = 'headMenu']//a[contains(text(),'HISTORY') or contains(text(),'ИСТОРИЯ')]";
  private final String  GALLERY_BUTTON_LOCATOR= "//nav[@class = 'headMenu']//a[contains(text(),'GALLERY') or contains(text(),'ГАЛЕРЕЯ')]";
  private final String  SHOP_BUTTON_LOCATOR= "//nav[@class = 'headMenu']//a[contains(text(),'SHOP') or contains(text(),'МАГАЗИН')]";
  private final String  LOGIN_BUTTON_WHEN_NOT_LOGGED_IN_LOCATOR= "//div[@class = 'sign_style']";
  private final String  LOGIN_BUTTON_WHEN_LOGGED_IN_LOCATOR= "//div[@id = 'myBtn']";
  private final String  CART_BUTTON_LOCATOR= "//div[@id = 'myDropdown']/a[4]";
  private final String  MENU_BUTTON_LOCATOR= "//a[@id = 'menu-toggle']";
  private final String  ACCOUNT_BUTTON_LOCATOR= "//div[@id = 'myDropdown']/a[1]";
  private final String  LOGOUT_BUTTON_LOCATOR= "//div[@id = 'myDropdown']/a[5]";
  private final String  RUS_LANGUAGE_BUTTON_LOCATOR= "//img[@alt = 'ru']";
  private final String  ENG_LANGUAGE_BUTTON_LOCATOR= "//img[@alt = 'en']";

  @FindBy(xpath = HEADER_LOGO_LOCATOR)
  private WebElement headerLogo;                                                                                       //Первая камера в списке камер

  @FindBy(xpath = CLUBS_BUTTON_LOCATOR)
  private WebElement clubsButton;

  @FindBy(xpath = THEGAME_BUTTON_LOCATOR)
  private WebElement thegameButton;

  @FindBy(xpath = NEWS_BUTTON_LOCATOR)
  private WebElement newsButton;

  @FindBy(xpath = TOURNAMENTS_BUTTON_LOCATOR)
  private WebElement tournamentsButton;

  @FindBy(xpath = HISTORY_BUTTON_LOCATOR)
  private WebElement historyButton;

  @FindBy(xpath = GALLERY_BUTTON_LOCATOR)
  private WebElement galleryButton;

  @FindBy(xpath = SHOP_BUTTON_LOCATOR)
  private WebElement shopButton;

  @FindBy(xpath = LOGIN_BUTTON_WHEN_NOT_LOGGED_IN_LOCATOR)
  private WebElement loginButtonWhenNotLoggedIn;

  @FindBy(xpath = LOGIN_BUTTON_WHEN_LOGGED_IN_LOCATOR)
  private WebElement loginButtonWhenLoggedIn;

  @FindBy(xpath = CART_BUTTON_LOCATOR)
  private WebElement cartButton;

  @FindBy(xpath = MENU_BUTTON_LOCATOR)
  private WebElement menuButton;

  @FindBy(xpath = ACCOUNT_BUTTON_LOCATOR)
  private WebElement accountButton;

  @FindBy(xpath = LOGOUT_BUTTON_LOCATOR)
  private WebElement logoutButton;

  public InternalPage clickLogo() {
    headerLogo.click();
    return pages.clubsPage;
  }

  public ClubsPage clickClubsButton() {
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CLUBS_BUTTON_LOCATOR)));
    clubsButton.click();
    return pages.clubsPage;
  }

  public TheGamePage clickTheGameButton() {
    thegameButton.click();
    return pages.theGamePage;
  }

  public NewsPage clickNewsButton() {
    newsButton.click();
    return pages.newsPage;
  }

  public TournamentsPage clickTournamentsButton() {
    tournamentsButton.click();
    return pages.tournamentsPage;
  }

  public HistoryPage clickHistoryButton() {
    historyButton.click();
    return pages.historyPage;
  }

  public ShopPage clickShopButton() {
    shopButton.click();
    log("Shop button was clicked |||||| ");
    return pages.shopPage;
  }

  public GalleryPage clickGalleryButton() {
    galleryButton.click();
    log("Gallery button was clicked |||||| ");
    return pages.galleryPage;
  }

  public void clickLoginButton() {
    try {
      Thread.sleep(2000);
      loginButtonWhenNotLoggedIn.click();
      log("Login button was clicked |||||| ");
    } catch (Exception e) {
      loginButtonWhenLoggedIn.click();
      log("Login button was clicked |||||| ");
    }
  }

  public void clickAccountButton() {
    clickLoginButton();
    wait.until(visibilityOf(accountButton));
    accountButton.click();
  }

  public CartPage clickCartButton() {
    clickLoginButton();
    wait.until(visibilityOf(cartButton));
    cartButton.click();
    log("Cart button was clicked |||||| ");
    return pages.cartPage;
  }

   public InternalPage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.xpath(HEADER_LOGO_LOCATOR)));
    log("Internal page was loaded successfully |||||| ");
    return this;
  }

  public void clickLogoutButton() {
    clickLoginButton();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    wait.until(visibilityOf(logoutButton));
    logoutButton.click();
  }

  public void setLanguage(String language) {
    if (language.equalsIgnoreCase("rus")) {
      driver.findElement(By.xpath(RUS_LANGUAGE_BUTTON_LOCATOR)).click();
      log("Language was set as rus");
    } else if (language.equalsIgnoreCase("eng")) {
      driver.findElement(By.xpath(ENG_LANGUAGE_BUTTON_LOCATOR)).click();
      log("Language was set as eng");
    }

  }

  public String getLanguage() {
    String language = "";
    return language = driver.findElement(By.xpath("//div[@class = 'telephone']/p")).getText().equalsIgnoreCase("Телефоны:") ? "rus" :"eng";
  }

  public void checkMenuItemOnPage(MenuItem menuItem) {
    String language = getLanguage();
    String menuItemName = driver.findElement(By.xpath("//nav[@class = 'headMenu']//a[contains(text(), '"+menuItem.getLabel()+"') or contains(text(), '"+menuItem.getRusLabel()+"')]")).getText().trim();
    if (language.equals("eng")) {
      assertEquals(menuItem.getLabel().toLowerCase(), menuItemName.toLowerCase());
    }
    if (language.equals("rus")) {
      assertEquals(menuItem.getRusLabel().toLowerCase(), menuItemName.toLowerCase());
    }

  }

  public void checkMenuItemDoesntExist(MenuItem menuItem) {
    String language = getLanguage();
    boolean isPresent = true;
    if (language.equals("rus")) {
      isPresent = isElementPresent(By.xpath("//nav[@class = 'headMenu']//a[contains(text(), '"+menuItem.getRusLabel()+"')]"));
      log("There is no event '" + menuItem.getRusLabel() + "' on clubs page");
    }
    if (language.equals("eng")) {
      isPresent = isElementPresent(By.xpath("//nav[@class = 'headMenu']//a[contains(text(), '"+menuItem.getLabel()+"')]"));
      log("There is no event '" + menuItem.getLabel() + "' on clubs page");
    }
    assertFalse(isPresent);
  }
}
