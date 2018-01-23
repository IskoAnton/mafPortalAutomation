package ru.st.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.st.selenium.applogic.AdminUserHelper;
import ru.st.selenium.model.User;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class AdminUsersPage extends AdminAnyTabPage {
    public AdminUsersPage(PageManager pages) {super(pages);}

    private final String SEARCH_FIELD_LOCATOR = "//input[@type = 'search']";

    @FindBy(xpath = SEARCH_FIELD_LOCATOR)
    private WebElement searchField;

    public AdminUsersPage ensurePageLoaded() {
        wait.until(presenceOfElementLocated(By.xpath(SEARCH_FIELD_LOCATOR)));
        log("Admin Users page was loaded successfully");
        return this;
    }

    public void typeToSearchField(String text) {
        searchField.sendKeys(text);
        log("Text " + text + " was typed to the search field");
    }

    public void pressDeleteUser(User user) {
        if (isElementPresent(By.xpath("//tr//a[contains(text(), '" + user.getLogin() + "')]"))) {
            driver.findElement(By.xpath("//tr//a[contains(text(), 'isko.antontest@gmail.com')]//..//..//a[@data-button-type = 'delete']")).click();
            Alert alert = driver.switchTo().alert();
            alert.accept();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log("Alert about deleting was accepted");
            log("User " + user.getLogin() + " deleted");

        } else log("There is no user with login " + user.getLogin());

    }



}
