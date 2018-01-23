package ru.st.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class TheGamePage extends InternalPage {
    public TheGamePage(PageManager pages) {
        super(pages);
    }
    private final String  THE_GAME_PAGE_TITLE_LOCATOR = "//h1[@class = 'title_name' and (contains(text(), 'The game') or contains(text(), 'Игра'))]";


    public TheGamePage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.xpath(THE_GAME_PAGE_TITLE_LOCATOR)));
        log("The game page was loaded successfully");
        return this;
    }
}
