package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.News;

import static org.testng.AssertJUnit.assertEquals;

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
        sendKeysToTitleField(news);
        sendKeysToSlugField(news);
        driver.findElement(By.xpath(DATE_FIELD_LOCATOR)).sendKeys(news.getDate());
        log("Data + '" + news.getDate() + "' was typed to date field");
        addFile(imageDirectory);
        sendKeysToDescriptionField(news);
        sendKeysToTextField(news);
        sendKeysToMetaTitle(news);
        sendKeysToSocialMetaTitle(news);
        sendKeysToMetaDescription(news);
        sendKeysToSocialMetaDescription(news);
        sendKeysToMetaKeywords(news);
        clickRusTab();
        sendKeysToRusTitleField(news);
        sendKeysToRusDescriptionField(news);
        sendKeysToRusTextField(news);
        sendKeysToRusMetaTitle(news);
        sendKeysToRusSocialMetaTitle(news);
        sendKeysToRusMetaDescription(news);
        sendKeysToRusSocialMetaDescription(news);
        sendKeysToRusMetaKeywords(news);
    }

    public void checkRequiredFieldsMessages() {
        String message1 = driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//ul//li")).getText();
        log("Message 1 is '"+message1+"'");
        assertEquals(message1, "The title field is required.");
        String message2 = driver.findElement(By.xpath("//div[@class = 'form-group col-md-6 has-error']/label[contains(text(), 'Title')]/../div[@class = 'help-block']")).getText();
        log("Message 2 is '"+message2+"'");
        assertEquals(message2, "The title field is required.");
    }
}
