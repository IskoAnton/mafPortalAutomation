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
        driver.findElement(By.xpath(PAGE_NAME_FIELD_LOCATOR)).sendKeys(pageItem.getPageName());
        log("Page name field filled with '" + pageItem.getPageName() + "'");
        driver.findElement(By.xpath(TITLE_FIELD_LOCATOR)).sendKeys(pageItem.getPageTitle());
        log("Title field filled with '" + pageItem.getPageTitle() + "'");
        driver.findElement(By.xpath(SLUG_FIELD_LOCATOR)).sendKeys(pageItem.getPageSlug());
        log("Slug field filled with '" + pageItem.getPageSlug() + "'");
        //driver.findElement(By.xpath(CONTENT_FIELD_LOCATOR)).sendKeys(pageItem.getContent());
        driver.findElement(By.xpath(META_TITLE_FIELD_LOCATOR)).sendKeys(pageItem.getMetaTitle());
        log("Metatitle field filled with '" + pageItem.getMetaTitle() + "'");
        driver.findElement(By.xpath(SOCIAL_META_TITLE_FIELD_LOCATOR)).sendKeys(pageItem.getSocialMetaTitle());
        log("Social Metatitle field filled with '" + pageItem.getSocialMetaTitle() + "'");
        driver.findElement(By.xpath(META_DESCRIPTION_FIELD_LOCATOR)).sendKeys(pageItem.getMetaDescription());
        log("Meta description field filled with '" + pageItem.getMetaDescription() + "'");
        driver.findElement(By.xpath(SOCIAL_META_DESCRIPTION_FIELD_LOCATOR)).sendKeys(pageItem.getSocialMetaTitle());
        log("Social meta description field filled with '" + pageItem.getSocialMetaDescription() + "'");
        driver.findElement(By.xpath(META_KEYWORDS_LOCATOR)).sendKeys(pageItem.getMetaKeywords());
        log("Metakeywords field filled with '" + pageItem.getMetaKeywords() + "'");
        driver.findElement(By.xpath(RUS_TAB_LOCATOR)).click();
        log("Rus tab has been clicked");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(RUS_TITLE_FIELD_LOCATOR)));
        driver.findElement(By.xpath(RUS_TITLE_FIELD_LOCATOR)).sendKeys(pageItem.getRusPageTitle());
        log("Rus title field filled with '" + pageItem.getRusPageTitle() + "'");
        //driver.findElement(By.xpath(RUS_CONTENT_FIELD_LOCATOR)).sendKeys(pageItem.getRusContent());
        driver.findElement(By.xpath(RUS_META_TITLE_FIELD_LOCATOR)).sendKeys(pageItem.getRusMetaTitle());
        log("Rus meta title field filled with '" + pageItem.getRusMetaTitle() + "'");
        driver.findElement(By.xpath(RUS_SOCIAL_META_TITLE_FIELD_LOCATOR)).sendKeys(pageItem.getRusSocialMetaTitle());
        log("Rus social meta title field filled with '" + pageItem.getRusSocialMetaTitle() + "'");
        driver.findElement(By.xpath(RUS_META_DESCRIPTION_FIELD_LOCATOR)).sendKeys(pageItem.getRusMetaDescription());
        log("Rus meta description field filled with '" + pageItem.getRusMetaDescription() + "'");
        driver.findElement(By.xpath(RUS_SOCIAL_META_DESCRIPTION_FIELD_LOCATOR)).sendKeys(pageItem.getRusSocialMetaDescription());
        log("Rus social meta description field filled with '" + pageItem.getRusSocialMetaDescription() + "'");
        driver.findElement(By.xpath(RUS_META_KEYWORDS_LOCATOR)).sendKeys(pageItem.getRusMetaKeywords());
        log("Rus meta keywords field filled with '" + pageItem.getRusMetaKeywords()+ "'");
    }
}
