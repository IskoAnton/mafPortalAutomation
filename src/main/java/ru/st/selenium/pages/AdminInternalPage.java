package ru.st.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AdminInternalPage extends AnyPage {
    public AdminInternalPage(PageManager pages) {
        super(pages);
    }

    private final String LOGO_LOCATOR = "//span[@class = 'logo-lg']";
    private final String DRAWER_BUTTON_LOCATOR = "//a[@class = 'sidebar-toggle']";
    private final String LOGIN_BUTTON_IN_HEADER_LOCATOR = "//a[contains(text(), 'Login')]";
    private final String REGISTER_BUTTON_LOCATOR = "//a[contains(text(), 'Register')]";
    private final String LOGOUT_BUTTON_LOCATOR = "//header//a[contains(text(), ' Выйти') or contains(text(), ' Logout')]";


    public AdminInternalPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.xpath(LOGOUT_BUTTON_LOCATOR)));
        log("AdminInternalPage page was loaded successfully");
        return this;
    }

    @FindBy(xpath = DRAWER_BUTTON_LOCATOR)
    private WebElement drawerButton;

    @FindBy(xpath = LOGIN_BUTTON_IN_HEADER_LOCATOR)
    private WebElement loginButtonInHeader;

    @FindBy(xpath = REGISTER_BUTTON_LOCATOR)
    private WebElement registerButton;

    @FindBy(xpath = LOGOUT_BUTTON_LOCATOR)
    private WebElement logoutButton;



    public void clickDrawerButton() {
        log("Trying to click drawer button");
        drawerButton.click();
        log("Drawer button was clicked successfully");
    }

    public void clickLogoutButton() {
        log("Trying to click logout button");
        logoutButton.click();
        log("Logout button was clicked");
    }

    public void clickOnAdminTab(String adminTab) {
        wait.until(visibilityOf(driver.findElement(By.xpath("//span[./text() = '" + adminTab + "']"))));
        List<WebElement> list = driver.findElements(By.xpath("//span[./text() = '" + adminTab + "']"));
        if (list.size()==1) {
            list.get(0).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log("Tab " + adminTab + " was clicked");
        }
        if (list.size()==2 && !list.get(1).isDisplayed()) {
            list.get(0).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log("Tab " + adminTab + " was clicked");
        }

        if (list.size()==2 && list.get(1).isDisplayed()) {
            list.get(1).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log("Tab " + adminTab + " was clicked");
        }
    }

    public void clickLogo() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LOGO_LOCATOR)));
        driver.findElement(By.xpath(LOGO_LOCATOR)).click();
    }

    public List<WebElement> getItemsInTable() {
        return driver.findElements(By.xpath("//table[@id = 'crudTable']/tbody/tr"));
    }

    public String getLanguage() {
        String language = "";
        String logoutWord = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li/a[1]")).getText();
        if (logoutWord.equals("Выйти")) {
            language = "rus";
        } else if (logoutWord.equals("Logout")) {
            language = "eng";
        }
        return language;
    }

}
