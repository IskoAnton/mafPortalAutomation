package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.News;

public class AdminCreateNewsPage extends AdminCreateItemPage {
    public AdminCreateNewsPage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = TITLE_FIELD_LOCATOR)
    WebElement addFileButton;

    @FindBy(xpath = TEXT_FRAME_LOCATOR)
    WebElement textFrame;

    @Override
    public void fillAllFieldsWithData(Object obj) {
        News news = (News) obj;
        driver.findElement(By.xpath(TITLE_FIELD_LOCATOR)).sendKeys(news.getTitle());
        driver.findElement(By.xpath(SLUG_FIELD_LOCATOR)).sendKeys(news.getSlug());
        driver.findElement(By.xpath(DATE_FIELD_LOCATOR)).sendKeys(news.getDate());
        driver.findElement(By.xpath(DESCRIPTION_FIELD_LOCATOR)).sendKeys(news.getDescripion());
        //typeTextToTextField(news.getText());
        driver.findElement(By.xpath(META_TITLE_FIELD_LOCATOR)).sendKeys(news.getMetaTitle());
        driver.findElement(By.xpath(SOCIAL_META_TITLE_FIELD_LOCATOR)).sendKeys(news.getSocialMetaTitle());
        driver.findElement(By.xpath(META_DESCRIPTION_FIELD_LOCATOR)).sendKeys(news.getMetaDescription());
        driver.findElement(By.xpath(SOCIAL_META_DESCRIPTION_FIELD_LOCATOR)).sendKeys(news.getSocialMetaDescription());
        driver.findElement(By.xpath(META_KEYWORDS_LOCATOR)).sendKeys(news.getMetaKeywords());
        driver.findElement(By.xpath(RUS_TAB_LOCATOR)).click();
        driver.findElement(By.xpath(RUS_TITLE_FIELD_LOCATOR)).sendKeys(news.getRusTitle());
        driver.findElement(By.xpath(RUS_DESCRIPTION_FIELD_LOCATOR)).sendKeys(news.getRusDescripion());
        //        typeTextToTextField(news.getText());
        driver.findElement(By.xpath(RUS_META_TITLE_FIELD_LOCATOR)).sendKeys(news.getRusMetaTitle());
        driver.findElement(By.xpath(RUS_SOCIAL_META_TITLE_FIELD_LOCATOR)).sendKeys(news.getRusSocialMetaTitle());
        driver.findElement(By.xpath(RUS_META_DESCRIPTION_FIELD_LOCATOR)).sendKeys(news.getRusMetaDescription());
        driver.findElement(By.xpath(RUS_SOCIAL_META_DESCRIPTION_FIELD_LOCATOR)).sendKeys(news.getRusSocialMetaDescription());
        driver.findElement(By.xpath(RUS_META_KEYWORDS_LOCATOR)).sendKeys(news.getRusMetaKeywords());
    }



}
