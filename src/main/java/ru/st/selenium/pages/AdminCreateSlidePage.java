package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.Slide;
import ru.st.selenium.model.TabItem;

public class AdminCreateSlidePage extends AdminCreateItemPage {
    public AdminCreateSlidePage(PageManager pages) {
        super(pages);
    }

    protected final String BUTTON_TEXT_FIELD_LOCATOR = "//input[@name='btn_text']";
    protected final String BUTTON_LINK_FIELD_LOCATOR = "//input[@name='btn_link']";
    protected final String RUS_BUTTON_TEXT_FIELD_LOCATOR = "//input[@name='btn_text_ru']";
    protected final String RUS_BUTTON_LINK_FIELD_LOCATOR = "//input[@name='btn_link_ru']";


    public void fillAllFieldsWithData(TabItem tabItem) {
        Slide slide = (Slide) tabItem;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TITLE_FIELD_LOCATOR)));
        sendKeysToTitleField(slide);
        sendKeysToDescriptionField(slide);
        driver.findElement(By.xpath(BUTTON_TEXT_FIELD_LOCATOR)).sendKeys(slide.getButtonText());
        log("Button text '" + slide.getButtonText() + "' was typed to button text field");
        driver.findElement(By.xpath(BUTTON_LINK_FIELD_LOCATOR)).sendKeys(slide.getButtonLink());
        log("Button link '" + slide.getButtonLink() + "' was typed to button link field");
        clickRusTab();
        sendKeysToRusTitleField(slide);
        sendKeysToRusDescriptionField(slide);
        driver.findElement(By.xpath(RUS_BUTTON_TEXT_FIELD_LOCATOR)).sendKeys(slide.getButtonText());
        log("Title " + slide.getTitle() + "was typed to title field");
        driver.findElement(By.xpath(RUS_BUTTON_LINK_FIELD_LOCATOR)).sendKeys(slide.getButtonLink());
        log("Title " + slide.getTitle() + "was typed to title field");
        //addFile(imageDirectory);
    }
}
