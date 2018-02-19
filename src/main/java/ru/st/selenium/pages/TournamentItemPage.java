package ru.st.selenium.pages;

import org.openqa.selenium.By;
import ru.st.selenium.model.Event;
import ru.st.selenium.model.Tournament;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class TournamentItemPage extends TournamentsPage{
    public TournamentItemPage(PageManager pages) {
        super(pages);
    }

    private final String TOURNAMENT_TITLE_LOCATOR = "//div[@class = 'NewsTitle']";
    private final String TOURNAMENT_DESCRIPTION_LOCATOR = "//div[@class = 'descWr']/div[@class = 'text']";
    private final String  NEWS_DATE_LOCATOR= "//div[@class = 'descWr']/div[@class = 'date']";

    public void checkDataOnTournmentItemPage(Tournament tournament) {
        String language = getLanguage();
        if (language.equalsIgnoreCase("rus")) {
            assertEquals(driver.findElement(By.xpath(TOURNAMENT_TITLE_LOCATOR)).getText(), tournament.getRusTitle());
            log("Tournament rus title '" + tournament.getRusTitle() + "' is OK");
            assertEquals(driver.findElement(By.xpath(TOURNAMENT_DESCRIPTION_LOCATOR)).getText(), tournament.getRusDescription());
            log("Tournament rus text '" + tournament.getRusText() + "' is OK");
            //TODO //assertEquals(driver.findElement(By.xpath(NEWS_DATE_LOCATOR)).getText(), news.getDate());
        } else if (language.equalsIgnoreCase("eng")) {
            assertEquals(driver.findElement(By.xpath(TOURNAMENT_TITLE_LOCATOR)).getText(), tournament.getTitle());
            log("Tournament rus title '" + tournament.getTitle() + "' is OK");
            assertEquals(driver.findElement(By.xpath(TOURNAMENT_DESCRIPTION_LOCATOR)).getText(), tournament.getDescription());
            log("Tournament rus text '" + tournament.getText() + "' is OK");
            //TODO //assertEquals(driver.findElement(By.xpath(NEWS_DATE_LOCATOR)).getText(), news.getDate());
        }
    }

    public void checkTournamentDoesntExist(Tournament tournament) {
        String language = getLanguage();
        boolean isPresent = true;
        if (language.equals("rus")) {
            isPresent = isElementPresent(By.xpath("//div[@class = 'ListTitle' and contains(text() , '" +tournament.getRusTitle()+ "')]"));
            log("There is no tournament '" + tournament.getRusTitle() + "' on tournament page");
        }
        if (language.equals("eng")) {
            isPresent = isElementPresent(By.xpath("//div[@class = 'ListTitle' and contains(text() , '" +tournament.getTitle()+ "')]"));
            log("There is no tournament '" + tournament.getTitle() + "' on tournament page");
        }
        assertFalse(isPresent);
    }
}
