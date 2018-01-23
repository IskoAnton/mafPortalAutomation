package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.Slide;

public class AdminCreateSlidePage extends AdminCreateItemPage {
    public AdminCreateSlidePage(PageManager pages) {
        super(pages);
    }

    protected final String BUTTON_TEXT_FIELD_LOCATOR = "//input[@name='btn_text']";
    protected final String BUTTON_LINK_FIELD_LOCATOR = "//input[@name='btn_link']";
    protected final String RUS_BUTTON_TEXT_FIELD_LOCATOR = "//input[@name='btn_text_ru']";
    protected final String RUS_BUTTON_LINK_FIELD_LOCATOR = "//input[@name='btn_link_ru']";


    public void fillAllFieldsWithData(Object obj) {
        Slide slide = (Slide) obj;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TITLE_FIELD_LOCATOR)));
        driver.findElement(By.xpath(TITLE_FIELD_LOCATOR)).sendKeys(slide.getTitle());
        driver.findElement(By.xpath(DESCRIPTION_FIELD_LOCATOR)).sendKeys(slide.getDescription());
        driver.findElement(By.xpath(BUTTON_TEXT_FIELD_LOCATOR)).sendKeys(slide.getButtonText());
        driver.findElement(By.xpath(BUTTON_LINK_FIELD_LOCATOR)).sendKeys(slide.getButtonLink());
        clickRusTab();
        driver.findElement(By.xpath(RUS_TITLE_FIELD_LOCATOR)).sendKeys(slide.getTitle());
        driver.findElement(By.xpath(RUS_DESCRIPTION_FIELD_LOCATOR)).sendKeys(slide.getDescription());
        driver.findElement(By.xpath(RUS_BUTTON_TEXT_FIELD_LOCATOR)).sendKeys(slide.getButtonText());
        driver.findElement(By.xpath(RUS_BUTTON_LINK_FIELD_LOCATOR)).sendKeys(slide.getButtonLink());
        String imageDirectory = System.getProperty("user.dir") + "\\src\\main\\resources\\uploads\\test.png";
        addFile(imageDirectory);
    }
}
