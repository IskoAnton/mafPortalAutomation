package ru.st.selenium.pages;

import org.openqa.selenium.By;
import ru.st.selenium.model.News;

import static org.testng.Assert.assertEquals;

public class NewsItemPage extends NewsPage {

    public NewsItemPage(PageManager pages) {
        super(pages);
    }

    private final String  NEWS_TITLE_LOCATOR= "//div[@class = 'NewsTitle']";
    private final String  NEWS_DESCRIPTION_LOCATOR= "//div[@class = 'descWr']/div[@class = 'text']";
    private final String  NEWS_DATE_LOCATOR= "//div[@class = 'descWr']/div[@class = 'date']";

    public void checkDataOnNewsItemPage(News news) {
        String language = getLanguage();
        if (language.equalsIgnoreCase("rus")) {
            assertEquals(driver.findElement(By.xpath(NEWS_TITLE_LOCATOR)).getText(), news.getRusTitle());
            assertEquals(driver.findElement(By.xpath(NEWS_DESCRIPTION_LOCATOR)).getText(), news.getRusDescription());
            //TODO //assertEquals(driver.findElement(By.xpath(NEWS_DATE_LOCATOR)).getText(), news.getDate());
        } else if (language.equalsIgnoreCase("eng")) {
            assertEquals(driver.findElement(By.xpath(NEWS_TITLE_LOCATOR)).getText(), news.getTitle());
            assertEquals(driver.findElement(By.xpath(NEWS_DESCRIPTION_LOCATOR)).getText(), news.getDescription());
            //TODO //assertEquals(driver.findElement(By.xpath(NEWS_DATE_LOCATOR)).getText(), news.getDate());
        }
    }

}
