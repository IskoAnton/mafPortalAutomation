package ru.st.selenium.pages;

import org.openqa.selenium.By;
import ru.st.selenium.model.Tournament;


import static org.testng.Assert.assertEquals;

public class TournamentItemPage extends TournamentsPage{
    public TournamentItemPage(PageManager pages) {
        super(pages);
    }

    private final String TOURNAMENT_TITLE_LOCATOR = "//div[@class = 'NewsTitle']";
    private final String TOURNAMENT_DESCRIPTION_LOCATOR = "//div[@class = 'descWr']/div[@class = 'text']";
    private final String  NEWS_DATE_LOCATOR= "//div[@class = 'descWr']/div[@class = 'date']";

    public void checkDataOnTournmentItemPage(Tournament tournament, String language) {
        if (language.equalsIgnoreCase("rus")) {
            assertEquals(driver.findElement(By.xpath(TOURNAMENT_TITLE_LOCATOR)).getText(), tournament.getRusTitle());
            assertEquals(driver.findElement(By.xpath(TOURNAMENT_DESCRIPTION_LOCATOR)).getText(), tournament.getRusDescripion());
            //TODO //assertEquals(driver.findElement(By.xpath(NEWS_DATE_LOCATOR)).getText(), news.getDate());
        } else if (language.equalsIgnoreCase("eng")) {
            assertEquals(driver.findElement(By.xpath(TOURNAMENT_TITLE_LOCATOR)).getText(), tournament.getTitle());
            assertEquals(driver.findElement(By.xpath(TOURNAMENT_DESCRIPTION_LOCATOR)).getText(), tournament.getDescripion());
            //TODO //assertEquals(driver.findElement(By.xpath(NEWS_DATE_LOCATOR)).getText(), news.getDate());
        }
    }
}
