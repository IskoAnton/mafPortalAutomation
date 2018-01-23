package ru.st.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HistoryPage extends InternalPage {
    public HistoryPage(PageManager pages) {
        super(pages);
    }

    private final String  HISTORY_PAGE_TITLE_LOCATOR= "//h1[@class = 'title_name' and (contains(text(), 'History') or contains(text(), 'История'))]";

    public HistoryPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.xpath(HISTORY_PAGE_TITLE_LOCATOR)));
        log("History page was loaded successfully");
        return this;
    }
}
