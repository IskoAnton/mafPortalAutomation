package ru.st.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import ru.st.selenium.model.News;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;

public class NewsPage extends InternalPage {
    public NewsPage(PageManager pages) {
        super(pages);
    }

    private final String  NEWS_PAGE_TITLE_LOCATOR= "//h1[@class = 'title_name' and (contains(text(), 'News') or contains(text(), 'Новости'))]";

    public NewsPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.xpath(NEWS_PAGE_TITLE_LOCATOR)));
        log("News page was loaded successfully");
        return this;
    }

    public void clickNews(News news) {
        driver.findElement(By.xpath("//div[@class = 'News_item']//h2[contains(text(), '"+ news.getTitle() + "') or contains(text(), '"+ news.getRusTitle() + "')]")).click();
    }
}
