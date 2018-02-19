package ru.st.selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.News;
import ru.st.selenium.model.PageItem;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AdminCreateNewPage extends AdminCreateItemPage {
    public AdminCreateNewPage(PageManager pages) {
        super(pages);
    }

    private final String RUS_TITLE_FIELD_LOCATOR = "//input[@name = 'title_rus']";

    public void fillAllFieldsWithData(Object obj) {
        PageItem pageItem = (PageItem) obj;
        driver.findElement(By.xpath(PAGE_NAME_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(PAGE_NAME_FIELD_LOCATOR)).sendKeys(pageItem.getPageName());
        log("Page name field filled with '" + pageItem.getPageName() + "'");
        sendKeysToTitleField(pageItem);
        sendKeysToSlugField(pageItem);
        sendKeysToTextField(pageItem);
        clickRusTab();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(RUS_TITLE_FIELD_LOCATOR)));
        driver.findElement(By.xpath(RUS_TITLE_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(RUS_TITLE_FIELD_LOCATOR)).sendKeys(pageItem.getRusTitle());
        sendKeysToRusTextField(pageItem);
    }

    public void checkRequiredFieldsMessages() {
        String language = getLanguage();
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The name field is required.']"));
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The title field is required.']"));
        log("Message 1 is 'The name field is required.'");
        log("Message 1 is 'The name field is required.'");
        driver.findElement(By.xpath("//label[contains(text(), 'Page name (only seen by admins)')]/../..//div[@class = 'help-block' and text() = 'The name field is required.']"));
        driver.findElement(By.xpath("//label[contains(text(), 'Page Title')]/../..//div[@class = 'help-block' and text() = 'The title field is required.']"));
        log("Message 2 is 'The name field is required.'");
        log("Message 2 is 'The title field is required.'");
    }
}
